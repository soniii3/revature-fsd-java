import java.util.Scanner;
public class MobileMenu {

	public static void main(String[] args) {
		System.out.println("Menu");
		System.out.println("====");
		System.out.println("1. Balance Enquiry");
		System.out.println("2. Recharge");
		System.out.println("3.Change Caller Tune");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Choose any option:");
		int option=sc.nextInt();
		
		/*if(option == 1) {
			System.out.println("Balance Enquiry");
		} else if (option == 2) {
			System.out.println("Recharge");
		} else if (option == 3) {
			System.out.println("Change Caller Tune");
		} else {
			System.out.println("Enter correct option");
		}*/
		switch (option) {
		case 1:
			System.out.println("Balance Enquiry");
			break;
		case 2:
			System.out.println("Recharge");
			break;
		case 3:
			System.out.println("Change Caller Tune");
			break;
		}
	}

}
