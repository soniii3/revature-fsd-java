import java.util.Scanner;
public class ClesiusToFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter Celsius Value :");
		int celsius = sc.nextInt();
				
		float fahrenheit = celsius*(9/5.0f)+32;
				
		System.out.println("Fahrenheit Value : "+ fahrenheit);
			}

		}

