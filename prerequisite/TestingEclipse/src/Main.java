import java.util.Arrays;

public class Main {
	public static final String[][] GROCERY_ITEMS = new String[][] {{"Apple", "$1.59"}, {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"}, {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"}, {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"}, {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"}, {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"}, {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("A foo walks into a bar... \n\n\n... and says \"Hello World!\"");
		
		
		int[] highTemps = {93, 80, 62, 75, 74, 89, 97};
		
		// worked when printing array
		for(int i = 0; i < highTemps.length; i++) {
			//System.out.print(a[i] + "\n");
			//System.out.print(b[i] + "\n");
			System.out.print(highTemps[i] + "\n");
		}
		
		//didn't work
		System.out.println(highTemps);
		
		System.out.println("This is: " + Arrays.toString(highTemps));
		
		System.out.println(Integer.MIN_VALUE);
		
		Integer num1 = 10;
		Integer num2 = 8;
		Integer num3 = 10;
		int regularInt = 20;
		
		System.out.println(num1.compareTo(num2));
		System.out.println(num1.compareTo(regularInt));
		
		String x = "dog";
		String y = "fat";
		System.out.println(x.equals(y));
		
		
		System.out.println("Next: ");
		System.out.println(Arrays.toString(GROCERY_ITEMS[0]));
		
		System.out.println(Arrays.toString(GROCERY_ITEMS));
		
		double d = Double.parseDouble( GROCERY_ITEMS[0][1].substring(1));
		System.out.println(d);
		
		System.out.println("11\t11");
		
		int a = 1;
		System.out.println(a ==1 || a > 2);
		
		String[] stri = new String[] {"a","b"};
		System.out.println("compare string: " + Arrays.equals(stri, new String[] {"a","b"}));
		
		System.out.println("compare string: " + Arrays.equals(new String[2], new String[2]));
		
		System.out.println(Arrays.toString(new String[2]));
		
		for(String s:stri) {
			System.out.println(s);
		}
		
		
		
		
		
	}

}
