// Program to implement greedy algo for activity selection
/*
You are given n activities with their start and finish times. 
Select the maximum number of activities that can be performed 
by a single person, assuming that a person can only work on a 
single activity at a time.

http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
*/


import java.util.Arrays;

public class ActivitySelection {
	
	private int[] activity;
	private int[] start;
	private int[] end;
	
	public ActivitySelection(int[] activity, int[] start, int[] end) {
		this.activity = activity;
		this.start = start;
		this.end = end;
		
		sort();

	}
	
	private void sort() {
		int temp1, temp2, temp3;
		for(int i=0;i<end.length;i++) {
			for(int j=i+1;j<end.length;j++) {
				if(end[i] > end[j]) {
					temp1 = end[i];
					end[i] = end[j];
					end[j] = temp1;
					
					temp2 = start[i];
					start[i] = start[j];
					start[j] = temp2;
					
					temp3 = activity[i];
					activity[i] = activity[j];
					activity[j] = temp3;
				}
			}
		}
		
		System.out.println(Arrays.toString(end));
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(activity));
		
	}
	
	public void select() {
		int lastend = -1;
		for(int i = 0; i < end.length; i++) {
			if(start[i] > lastend) {
				lastend = end[i];
				System.out.print(activity[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[] activity = {0,1,2,3,4,5};
		int[] start = {3, 0, 5, 8, 5, 1};
		int[] end = {4, 6, 7, 9, 9, 2};
		
		ActivitySelection a = new ActivitySelection(activity, start, end);
		a.select();
		

	}

}

/*
Output: 5 0 2 3
*/
