
// Logic is given here
// http://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
public class TinyURL {
	
	public static String map1 = "abcdefghijklmnopqrstuvwxyzABCDEFG"
								+ "HIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static char[] map = map1.toCharArray();
	
	public static char[] encode(int a) {
		char[] result = new char[6];
		int i = 0;
		while(a > 0) {
			result[i++] = map[a%62];
			a = a/62;
		}
		
		int j,k;
		for(j = 0, k = i-1; j <= k; j++, k--) {
			char temp = result[j];
			result[j] = result[k];
			result[k] = temp;
		}
		
		return result;
	} 
	
	public static double decode(char[] a) {
		if(a.length == 0) return 0;
		double result = 0;
		for(int i = 0; i < a.length; i++) {
			
			int exponent = a.length - i - 1;
			int value1 = Character.getNumericValue(a[i]);
			int value2 = Character.getNumericValue('a');
			int value3 = Character.getNumericValue('A');
			int value4 = Character.getNumericValue('0');
			
			if(a[i] >= 'a' && a[i] <= 'z') {
				result += Math.pow(62, exponent) * (value1 - value2);
			} else if (a[i] >= 'A' && a[i] <= 'Z') {
				result += Math.pow(62, exponent) * (value1 - value3 + 26);
			} else {
				result += Math.pow(62, exponent) * (value1 - value4 + 52);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(TinyURL.encode(1234567890));
		System.out.println(TinyURL.decode("bvIhFu".toCharArray()));

	}

}
