import java.util.Scanner;
public class MobileMenu {

	public static void main(String[] args) {
			while (true) {
				System.out.println("Menu");
				System.out.println("====");
				System.out.println("1. Balance Enquiry");
				System.out.println("2. Recharge");
				System.out.println("3.Change Caller Tune");
				System.out.println("4. Exit");
				
				Scanner sc= new Scanner(System.in);
				System.out.println("Choose any option:");
				int option= sc.nextInt();
				
				if(option == 1) {
					System.out.println("Balance Enquiry");
					break;
			
				} else if (option == 2) {
					System.out.println("Recharge");
					break;
			
				} else if (option == 3) {
					System.out.println("Change Caller Tune");
					break;
			
				} else if (option == 4){
					System.out.println("Exit");
					System.exit(0);
			
					//break;
				}else {
					System.out.println("Enter correct option");
					break;
				}
			}
	}
}
				
		
	
