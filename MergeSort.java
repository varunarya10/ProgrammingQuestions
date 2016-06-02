// Must change filename to Sorter.java else it will not work
// Program to sort an array using merge sort

public class Sorter {
	
	private int[] a;
	
	public Sorter(int[] a) {
		this.a = a;
	}
	
	// No need to pass the array as its accessible by all methods
	// in this class
	public void MergeSort(int beg, int end) {
		if(beg < end) {
			int mid = (beg+end)/2;
			MergeSort(beg, mid);
			MergeSort(mid+1, end);
			Merge(beg, mid, end);
		}
	}
	
	private void Merge(int beg, int mid, int end) {
		int s1 = mid - beg + 1;
		int s2 = end - mid;
		int[] L1 = new int[s1];
		int[] L2 = new int[s2];
		int i, j, k;
		
		for(i = 0; i < s1; i++) {
			L1[i] = a[beg+i];
		}
		
		for(j = 0; j < s2; j++) {
			L2[j] = a[mid+1+j];
		}
		
		for(i=0,j=0,k=beg; i<s1 && j<s2 && k < end;) {
			if(L1[i] < L2[j]) {
				a[k++] = L1[i++];
			} else {
				a[k++] = L2[j++];
			}
		}
		
		while(i < s1) {
			a[k++] = L1[i++];
		}
		
		while(j < s2) {
			a[k++] = L2[j++];
		}
	}
	
	public void printArr() {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] a = {5,4,2,3,1};
		Sorter s = new Sorter(a);
		s.printArr();
		s.MergeSort(0, a.length - 1);
		s.printArr();
		

	}

}
