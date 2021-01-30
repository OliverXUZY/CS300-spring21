
public class Helloworld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println("Hello World!");
		//INSTRUCTOR NOTE: avoid literals by using constants
        //must have only 1 variable or constant per line
        final int SQUARE_SIZE = 7;
        final char INSIDE_CHAR = ' ';
        final char BORDER_CHAR = '#';

        //INSTRUCTOR NOTE: use vertical whitespace to group and delineate
        //sections of code
        for (int i = 1; i <= SQUARE_SIZE; ++i) {
            System.out.print(BORDER_CHAR);
        }
        System.out.println();

	}

}
