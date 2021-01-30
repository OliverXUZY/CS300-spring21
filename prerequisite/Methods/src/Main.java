
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s:args) {
			System.out.println(s);
		}
		double x = 10;
		double y = x;
		System.out.println(y);
		//System.out.println(y.equals(x));
		
		String h = "H"; 
		String s1 = h + "i"; 
		String s2 = h + "i";
		System.out.println(s1.equals(s2));
		
		//int[] a = new int[] {1,2,3};
		int[] a = {1,2,3};
		int[] b = a;
		System.out.println(a.equals(b));
		

	}

}
