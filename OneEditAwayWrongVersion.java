// Program to return true if two strings S1 and S2 are one edit away (add/delete/replace one character in S2 to get S1)
// This is the wrong version as it does not take care of the order of characters in the string

public class OneEditAway {
	
	public static boolean isOneEditAway(String s1, String s2) {
		
		if(s1 == null || s2 == null) {
			return false;
		}
		
		int[] hash = new int[256];
		int sum=0, extraChar=0, i;
		char c;
		
		for(i=0; i<s1.length(); i++) {
			c = s1.charAt(i);
			hash[(int)c]++;
			sum++;
		}
		
		for(i=0; i<s2.length();i++) {
			c = s2.charAt(i);
			if(hash[(int)c] == 0) {
				extraChar++;
			} else {
				hash[(int)c]--;
				sum--;
			}
		}
		
		boolean result = false;
		if(extraChar == 1 && sum == 1) {
			// System.out.println("Strings are one replace apart");
			result = true;
		} else if(extraChar == 1 && sum == 0) {
			// System.out.println("Strings are one add apart");
			result = true;
		} else if(extraChar == 0 && sum == 1) {
			// System.out.println("Strings are one remove apart");
			result = true;
		} else if(extraChar == 0 && sum == 0) {
		  // System.out.println("Strings are identical");
			result = true;
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(OneEditAway.isOneEditAway("pale", "ple")); // true -> a needs to be added to S2 to get S1
		System.out.println(OneEditAway.isOneEditAway("pales", "pale")); // true -> s needs to be added to S2 to get S1
		System.out.println(OneEditAway.isOneEditAway("pale", "bale")); // true
		System.out.println(OneEditAway.isOneEditAway("pale", "bake"));  // true
		System.out.println(OneEditAway.isOneEditAway("abc", "cba"));  // true -> this is wrong

	}

}
