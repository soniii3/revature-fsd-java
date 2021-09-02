import java.util.Scanner;

public class TimeUsingSubString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter time in hh:mm:ss format:");
		String time = sc.nextLine();

		sc.close();

		System.out.println("Mintues : " + time.substring(3, 5));

	}

}
