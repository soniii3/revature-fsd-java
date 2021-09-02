
public class LinePrinter {

	public static void main(String[] args) {
		printLine();
		printLine(5);
		printLine(10);
		printLine(15);
		printLine(20);
		printLine(30,'$');


	}
	public static void printLine() {
		System.out.println("----------------------");
	}
	public static void printLine(int numOfCharacters) {
		for (int i = 0;i < numOfCharacters; i ++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	
	
	public static void printLine(int numOfCharacters, char character) {
		for (int i = 0;i < numOfCharacters; i ++) {
			System.out.print(character);
		}
		System.out.println();
	}
	
}
