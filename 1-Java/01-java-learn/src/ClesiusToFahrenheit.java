import java.util.Scanner;
public class ClesiusToFahrenheit {

	public static void main(String[] args) {
		System.out.println("Fahrenheit : "+ toFahrenheit(12));
		
	}
public static float toFahrenheit(float celsius){
	float fahrenheit = celsius*(9/5.0f)+32;
	return fahrenheit;
	}
}		
		
