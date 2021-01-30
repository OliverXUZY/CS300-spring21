import java.util.ArrayList;
import java.util.Hashtable;

public class Objects {

	public static void main0(String[] args) {
		// TODO Auto-generated method stub
		ArrayList nums = new ArrayList();
		Hashtable mapping = new Hashtable();

	}
	public static void ResetArrayList1(ArrayList list) {
		list = new ArrayList();
	}
	public static void ResetArrayList2(ArrayList list) {
		list.clear();
	}
	public static void ResetInt(int val) {
		val = 0;
	}
	
	public static void main(String[] args) { 
		ArrayList nums = new ArrayList ();
		int x = 300;
		nums.add(300);
		
		// making a parameter refer to a new object
		// doesn’t affect our reference
		ResetArrayList1(nums);
		System.out.println(nums.size()); // s t i l l is 1
		
		// however, the parameter is another reference
		// to our same object , and it can be used to
		// modify that object
		ResetArrayList2(nums); 
		System.out.println(nums.size()); // now is 0
		
		// changes to primitives (non objects) are
		// not visible outside the method ResetInt(x);
		System.out.println(x); 
	}
	
}
