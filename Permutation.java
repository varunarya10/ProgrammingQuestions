// Find permutation of a string with unique characters

public class Permutation {


	public static void findPermutation(char[] input) {
		if(input.length <= 0) {
			System.out.println("ERROR: Array must be non zero length");
			return;
		}
		
		if(input.length == 1) {
			System.out.println("Only one permutation");
			System.out.println(input);
			return;
		}
		
		boolean[] used = new boolean[input.length];
		char[] output = new char[input.length];
		int index = 0, length = input.length;
		doFindPermutation(input, output, used, index, length);
	}
	
	public static void doFindPermutation(char[] input, char[] 
			output, boolean[] used, int index, int length) {
		if(index == length) {
			// print string and return
			System.out.println(output);
		}
		
		for(int j = 0; j<input.length; j++) {
			if(used[j] == false) {
				used[j] = true;
				output[index] = input[j];
				doFindPermutation(input, output, used, index+1, length);
				used[j] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation.findPermutation("ABCD".toCharArray());
	}

}
