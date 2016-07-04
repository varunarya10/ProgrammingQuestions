// Find an element in sorted array that is rotated arbitirary number of times

public class RotatedSortedFinder {
	
	// returns the index of the found element. -1 otherwise.
	public static int findSortedRotated(int beg, int end, int item, int[] a) {
		if(beg > end) {
			return -1;
		}
		
		int mid = (beg + end)/2;
		
		if(a[mid] == item) {
			return mid;
		} else if(a[beg] <= a[mid]) {
			// left side sorted in increasing order
			if(item >= a[beg] && item < a[mid]) {
				return findSortedRotated(beg, mid, item, a);
			} else {
				return findSortedRotated(mid+1, end, item, a);
			}
		} else {
			if(item > a[mid] && item <= a[end]) {
				return findSortedRotated(mid+1, end, item, a);
			} else {
				return findSortedRotated(beg, mid, item, a);
			}
		}
		
	}

	public static void main(String[] args) {
		int[] a = {15, 16, 19,20, 25, 1, 3, 4, 5, 7, 10, 14};
		for(int i=0;i<a.length;i++) {
			System.out.println("Index of " + a[i] + " is " +
		findSortedRotated(0,a.length-1,a[i],a));
		}
		
		System.out.println("Index of 100 is " +
				findSortedRotated(0,a.length-1,100,a));
		
		System.out.println("Index of -1 is " +
				findSortedRotated(0,a.length-1,-1,a));
		

	}

}


/*
Output:
Index of 15 is 0
Index of 16 is 1
Index of 19 is 2
Index of 20 is 3
Index of 25 is 4
Index of 1 is 5
Index of 3 is 6
Index of 4 is 7
Index of 5 is 8
Index of 7 is 9
Index of 10 is 10
Index of 14 is 11
Index of 100 is -1
Index of -1 is -1

*/
