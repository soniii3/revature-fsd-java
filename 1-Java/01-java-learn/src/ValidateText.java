import java.util.Scanner;
public class ValidateText {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Short Name :");
		String text = sc.next();
		
		if(text.length() >= 2 && text.length() <= 6) {
			System.out.println("This is a valid Short Name");
		} else {
			System.out.println("This is not a valid Short Name:");
			
		}
	}

}
