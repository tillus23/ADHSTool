import de.medieninf.ads.ADSTool;
import de.medieninf.ads.ADSTool.Sort;

public class MergeSort extends ADSTool.Sort {

	private int[] b; // Hilfsspeicher für MergeSort
	
	public void sort(int[] a) {
		b = new int[a.length]; // Hilfsspeicher initialisieren
		mergeSort(a, 0, a.length - 1);
	}

	/**
	 * MergeSort mit unterer (l) und oberer (r) Grenze
	 * 
	 * @param a Array mit zu sortierenden Zahlen
	 * @param l Index linker Rand (inklusive)
	 * @param r Index rechter Rand (inklusive)
	 */
	public void mergeSort(int[] a, int l, int r) {
		if (l >= r) { // einelementig
			return;
		}
		int m = (l + r) / 2;
		mergeSort(a, l, m);
		mergeSort(a, m + 1, r);
		// merging
		int i = l;
		int j = m + 1;
		int k = l;
		while (k <= r) {
			if (i > m) { // links leer kopiere rechts
				swap(b, k++, a, j++);
			} else if (j > r) { // rechts leer kopiere links
				swap(b, k++, a, i++);
			} else if (lt(a[i], a[j])) { // aus dem linken
				swap(b, k++, a, i++);
			} else { // aus dem rechten
				swap(b, k++, a, j++);
			}
		}
		// kopiere gemergte Liste auf das Original
		for (k = l; k <= r; k++) {
			swap(a, k, b, k);
		}
	}

	public static void main(String[] args) {
		Sort sort = new MergeSort();
		System.out.println("MergeSort:");
		sort.runSmall();
		sort.runLarge();
	}

}
