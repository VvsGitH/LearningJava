package com.serlvets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.classes.Post;


@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create HTTPS request
		URL url = new URL("https://jsonplaceholder.typicode.com/posts");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		// Send request
		// getResponseCode is blocking: the thread is blocked until the request is completed!
		int status = con.getResponseCode();
		System.out.println("----- Request status: " + status + " -----");
		
		BufferedReader in;
		String inputLine;
		StringBuffer content;
		
		if (status == 200) {
			// Read the response in a StringBuffer
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			con.disconnect();
			
			// Parse the StringBuffer in a JSON Array
			JSONArray jarr = new JSONArray(content.toString());
			System.out.println("----- Parsed array of size: " + jarr.length() + " -----");
			
			if (jarr.length() > 0) {
				// Parse the JSONArray in an array of Posts
				Post[] postList = new Post[jarr.length()];
				for (int i = 0; i < jarr.length(); i++) {
					postList[i] = new Post(
							jarr.getJSONObject(i).getInt("id"),
							jarr.getJSONObject(i).getInt("userId"),
							jarr.getJSONObject(i).getString("title"),
							jarr.getJSONObject(i).getString("body"));
				}
				
				// Insert the array in the servlet request and forward it to the JSP
				request.setAttribute("posts", postList);
				RequestDispatcher rd = request.getRequestDispatcher("posts.jsp");
				rd.forward(request, response);
			}
			
		} else {
			// The REST call returned an error
			// Read and print the errors
			in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			con.disconnect();
			
			System.out.println("Errors: " + content.toString());
			
			// Return to index.html with an error message
			response.getWriter().append("<p>Error in the servlet!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}		
		
	}
	
}
