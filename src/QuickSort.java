import de.medieninf.ads.ADSTool;
import de.medieninf.ads.ADSTool.Sort;

public class QuickSort extends ADSTool.Sort {
	
	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	/**
	 * Quick mit unterer (l) und oberer (r) Grenze
	 * 
	 * @param a Array mit zu sortierenden Zahlen
	 * @param l Index untere Grenze (inklusive)
	 * @param r Index obere Grenze (inklusive)
	 */
	public void quickSort(int[] a, int l, int r) {
		if (l < r) { //mindenstens zweielementig
			// sicheres Berechnen des mittleren Wertes
			int p = a[l+((r-l)/2)]; // Pivot-Element ist das Mittlere
			int i = l;
			int j = r;
			while (i <= j) {
				while ((i < r) && (lt (a[i], p))) {
					i++;
				}
				while ((l < j) && (gt (a[j], p))) {
					j--;
				}
				if (i <= j) {
					swap(a, i, j);
					i++;
					j--;
				}
			}
			quickSort(a, l, j);
			quickSort(a, i, r);
		}
	}

	public static void main(String[] args) {
		Sort sort = new QuickSort();
		System.out.println("QuickSort:");
		sort.runSmall();
		sort.runLarge();
	}

}
