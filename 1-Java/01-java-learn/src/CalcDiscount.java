import java.util.Scanner;
public class CalcDiscount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Bill Amount: ");
		int billAmount = sc.nextInt();
		
		System.out.print("Enter Discount Precentage: " );
		int discountPercent = sc.nextInt();
		
		float discount = (billAmount*18)/100.00f;
		
		System.out.println("Discounted Amount = "+discount);

	}

}
