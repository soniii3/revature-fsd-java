
public class AverageCalculator {

	public static void main(String[] args) {
		//int scores[] = { 48, 55,  92, 78, 64 };
		int[] scores=new int[5];
		scores[0]=45;
		scores[1]=65;
		scores[2]=86;
		scores[3]=46;
		scores[4]=79;
		float average=(scores[0]+scores[1]+scores[2]+scores[3]+scores[4])/5.0f;
		System.out.println(average);

	}

}
