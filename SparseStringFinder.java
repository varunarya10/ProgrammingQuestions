// Find a string in an array of Strings which is sorted lexicographically
// but has items sparsed out by ""
// e.g. find("ball", {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""})
// should return 4

public class SparseStringFinder {
	
	public static int find(String[] a, String item, int beg, int end) {
		if(beg > end) {
			return -1;
		}
		
		int mid = (beg + end)/2;
		
		while(a[mid].compareTo("") == 0 && mid >= beg) {
			mid--;
		}
		
		if(mid == beg -1) {
			return find(a, item, (beg+end)/2 +1, end);
		}
		
		if(a[mid].compareTo(item) == 0) return mid;
		else if(item.compareTo(a[mid]) >0) return find(a, item, mid+1, end);
		else return find(a, item, beg, mid-1);
		
	}

	public static void main(String[] args) {
		String[] a = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(find(a, "dad", 0, a.length-1));

	}

}
