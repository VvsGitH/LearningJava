package ex1;

// import java.io.*;

// Riscrivere il programma eliminando la dichiarazione import java.io.*;.

public class Ex1_Package {
	public static void main(String[] args) throws java.io.IOException {
		// stampa su schermo il file passato tramite linea di comando
		java.io.FileInputStream istream = new java.io.FileInputStream(args[0]);
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(istream));
		String linea = in.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = in.readLine();
		}
		in.close();
	}
}