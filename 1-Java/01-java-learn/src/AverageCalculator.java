
public class AverageCalculator {

	public static void main(String[] args) {
		float scores[] = { 48, 55,  92, 78, 64 };
		
		float total = 0.0f;
		for (int i = 0; i < scores.length; i ++) {
			total+=scores[i];
		}
		
		System.out.println("Average = "+(total / scores.length));
		
		//System.out.println("Average = ",+average);

	}

}
