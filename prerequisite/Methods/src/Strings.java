
public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "dog";
		String y = "cat";
		String z = "dog";
		System.out.println(x + y);
		System.out.println(x.equals(x));
		System.out.println(x.length());
		System.out.println(x.contains("og"));
		System.out.println(x.toUpperCase());
		System.out.println(x);
		System.out.println(x.charAt(0));
		System.out.println(x.substring(1));
		System.out.println((x+y).substring(2, 4));
		
		System.out.println(x.equals(z));

	}

}
