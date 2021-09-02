
public class DocumentListing {

	public static void main(String[] args) {
		String items[] = {"Driving License", "Passport", "Last 3 months Bank Statement", "Salary Slips of last 3 months", "2 Passport Size Photographs"};
		int i = 0;
		while(i < items.length) {
			System.out.println(i+1 + ") " +items[i]);
			i ++;
		}
	}
}
