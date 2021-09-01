import java.util.Scanner;
public class StudentPerformace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your score:");
		int marks = sc.nextInt();
		
		if(marks >=60 && marks<=70) {
			System.out.println("Average student");
		} else {
			System.out.println("Not Average student");
		}
		

	}

}
