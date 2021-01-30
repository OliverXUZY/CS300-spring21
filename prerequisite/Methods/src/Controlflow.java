
public class Controlflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 12;
		if (x>0) {
			System.out.println(x);
		} else if (x<0) {
			System.out.println(-x);
		} else {
			System.out.println("zero");
		}
		
		for (int i = 0; i<5; i++) {
			System.out.println(i);
		}
		
		int i = 0;
		while(i<=3) {
			System.out.println("This is " + i);
			i++;
		}
		
		for(int count = 10; count >= 0; count -=2) {
			System.out.println(count);
		}

	}

}
