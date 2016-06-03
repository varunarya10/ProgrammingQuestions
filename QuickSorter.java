// Program to sort an array of integers using Quick Sort

public class QuickSorter {
	
	private int[] a;
	public QuickSorter(int[]a) {
		this.a = a;
	}
	
	public void QuickSort() {
		int beg = 0;
		int end = a.length - 1; // want to have end inclusive
		
		doQuickSort(beg, end);
	}
	
	private void doQuickSort(int beg, int end) {
		if(beg < end) {
			int pivotIndex = quickSelect(beg, end);
			doQuickSort(beg, pivotIndex-1);
			doQuickSort(pivotIndex+1, end);
		}
	}
	
	private int quickSelect(int beg, int end) {
		int x = a[end];
		int i = beg-1;
		int j, temp;
		
		for(j=beg; j<end; j++) { 
			// j should not scan the last element
			if(a[j] <= x) {
				i = i+1;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		i = i+1;
		temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
	
	public void printArr() {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = {2,3,1,4,5,8};
		QuickSorter q = new QuickSorter(a);
		q.printArr();
		q.QuickSort();
		q.printArr();

	}

}
