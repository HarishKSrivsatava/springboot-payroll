
public class Test {

	public static void main(String[] args) {
		
		String charge = "10.9";
		Double chargeItem = Double.valueOf(charge);
		//int chargeTest = (int)((double)chargeItem);
		System.out.println(chargeItem.intValue());
	}
}
