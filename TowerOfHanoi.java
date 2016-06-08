
// Recursive version 
public class TowerOfHanoi {

	public static void TOH(String src, String aux, String dst, int n) {
		if(n == 1) {
			System.out.println("Moving disk 1 from tower "+ src + " to " + dst);
			return;
		}
		// if(n == 0) return;
		
		TOH(src, dst, aux, n-1);
		System.out.println("Moving disk "+ n +" from tower "+ src + " to " + dst);
		TOH(aux, src, dst, n-1);
	}
	public static void main(String[] args) {
		TowerOfHanoi.TOH("SRC", "AUX", "DST", 3);
		

	}

}
