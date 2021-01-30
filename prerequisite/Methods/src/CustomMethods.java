
public class CustomMethods {
	
	public static String concatenate(String a, String b) {
		return a + b;
	}
	
	public static int add(int... xs) {
		int sum = 0;
		for(int i = 0; i < xs.length; i++) {
			sum += xs[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( concatenate("3","4") );
		System.out.println( add(3,4,5) );
		//System.out.println( add(new int[]{1,2,3,4,5,6}) );
		System.out.println( add(new int[]{1,2,3,4,5,6}) );

	}

}
