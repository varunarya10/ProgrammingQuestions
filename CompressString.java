
public class Compressor {

	private int findCompressedLength(char[] a) {
		int i, j, countUnique=0;
		for(i = 0; i<a.length;){
			j = i+1;
			countUnique++;
			while(j<a.length && a[i] == a[j]) {
				j++;
			}
			i = j;
		}
		
		return countUnique * 2;
	}
	
	public char[] CompressString(char[] a) {
		if (findCompressedLength(a) > a.length) {
			System.out.println("Compressed string is greater than original string");
			return a;
		}
		
		char[] output = new char[a.length];
		int k = 0, i, j, repeated=0;
		
		for(i = 0; i<a.length;){
			j = i+1;
			repeated = 1;
			while(j<a.length && a[i] == a[j]) {
				j++;
				repeated++;
			}
			output[k++] = a[i];
			char[] freq = Integer.toString(repeated).toCharArray();
			
			for(int g = 0; g < freq.length; g++) {
				output[k++] = freq[g];
			}
			
			i = j;
		}
		// System.out.print(output);
		return output;
	}
	
	public static void main(String[] args) {
		//String s = "aabcccccaaa";
		//String s = "aaaaaa";
		String s = "abbb";
		Compressor c = new Compressor();
		System.out.println(c.CompressString(s.toCharArray()));
		

	}

}

// abbb output: a1b3
// aabcccccaaa output: a2b1c3a3
// abcd output: abcd
