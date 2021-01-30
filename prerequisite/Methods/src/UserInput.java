import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.println("Please enter your age: ");
		int age = in.nextInt();
		System.out.println("Please enter your name: ");
		String name1 = in.nextLine();
		String name2 = in.nextLine();
		System.out.println("(" + age +"," + name1 + "," + name2 + ")");
		//System.out.println("(" + age + "," + name2 + ")");
		in.close();

	}

}
