package string_behavoiur;

public class Test {
	public static void main(String[] args) {
		String str1 = "Hello";
		
		String str2 = str1;
		// After the copy the address is the same
		System.out.println("After the copy:");
		System.out.println(Integer.toHexString(str1.hashCode()));
		System.out.println(Integer.toHexString(str2.hashCode()));
		
		str2 = "World";
		// However, since the String is immutable, the change causes a new
		// object to be created with a new address.
		System.out.println("After the change in str2:");
		System.out.println(Integer.toHexString(str1.hashCode()));
		System.out.println(Integer.toHexString(str2.hashCode()));
	}
}
