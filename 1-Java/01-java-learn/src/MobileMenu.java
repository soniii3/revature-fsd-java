import java.util.Scanner;
public class MobileMenu {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int option= sc.nextInt();
		
		while (option > 0) {
		System.out.println("Menu");
		System.out.println("====");
		System.out.println("1. Balance Enquiry");
		System.out.println("2. Recharge");
		System.out.println("3.Change Caller Tune");
		System.out.println("4. Exit");
		
		System.out.println("Choose any option:");
		if(option == 1) {
			System.out.println("Balance Enquiry");
			continue;
		} else if (option == 2) {
			System.out.println("Recharge");
			continue;
		} else if (option == 3) {
			System.out.println("Change Caller Tune");
			continue;
		} else if (option == 4){
			System.out.println("Exit");
			break;
		}else {
			System.out.println("Enter correct option");
		}
		}
		
		}
	
	}
