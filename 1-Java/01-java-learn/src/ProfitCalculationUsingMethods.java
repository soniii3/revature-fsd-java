
public class ProfitCalculationUsingMethods {

	public static void main(String[] args) {
		System.out.println("Profit : " + profitCalculation(50,75));

	}
	public static int profitCalculation(int buyingPrice, int sellingPrice) {
		int profit = sellingPrice - buyingPrice;
		return profit;
	}

}
