
public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[3]; int[] b = new int[3]; int[] c = new int[] {1,2,3,4,5,6}; int[][] d = new int[2][3];
		a = new int[4]; b = new int[4];
		a[0] = 300;
		a[1] = 1;
		System.out.println(a[0]);
		System.out.println(a);
		
		System.out.println( "The length of a is: " + a.length );
		
		for(int i = 0; i < c.length; i++) {
			//System.out.print(a[i] + "\n");
			//System.out.print(b[i] + "\n");
			System.out.print(c[i] + "\n");
			System.out.println("The length of c is " + c.length);
			
			
		}
		System.out.println(d.length);
	
	}

}
