import de.medieninf.ads.ADSTool;

/*
lt(x,y)  =  x < y   lesser than
lte(x,y) =  x <= y  lesser than equal
gt(x,y)  =  x > y   greater than
gte(x,y) =  x >= y  greater than equal
*/

public class aufgabe4 extends ADSTool.Sort {

	public static void main(String[] args) {
		aufgabe4 mergeSort = new aufgabe4();
		int x[] = ADSTool.createRandomIntArray(10);
		String word = "Lara Heibel";
		char[] charArray = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			charArray[i] = word.charAt(i);
		}

		System.out.println("Ausgangslage:");
		ausgabe(x);
		mergeSort.selectionSort(x);
		mergeSort.insertionSort(x);
		mergeSort.bubbleSort(x);
		mergeSort.mergeSort(x);
		mergeSort.quickSort(x);

		System.out.println("---------------");

		System.out.println("Ausgangslage:");
		ausgabeChar(charArray);
		mergeSort.selectionSortChar(charArray);
		mergeSort.insertionSortChar(charArray);
		mergeSort.bubbleSortChar(charArray);
	}

	// Sortieren durch Auswahl (SelectionSort) bei Int
	public int[] selectionSort(int x[]) {
		System.out.println("SelectionSort:");
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (gt(x[i], x[j])) {
					swap(x, i, j);
				}
			}
		}
		ausgabe(x);
		return x;
	}

	// Sortieren durch Auswahl (SelectionSort) bei Char
	public char[] selectionSortChar(char x[]) {
		System.out.println("SelectionSort:");
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (gt(x[i], x[j])) {
					char temp = x[i];
					x[i] = x[j];
					x[j] = temp;

				}
			}
		}
		ausgabeChar(x);
		return x;
	}

	// Sortieren durch Einfügen (InsertionSort) bei Int
	public int[] insertionSort(int x[]) {
		System.out.println("InsertionSort:");
		for (int i = 1; i < x.length; i++) {
			int key = x[i];
			int j = i - 1;
			while (j >= 0 && gte(x[j], key)) {
				x[j + 1] = x[j];
				j--;
			}
			x[j + 1] = key;
		}
		ausgabe(x);
		return x;
	}

	// Sortieren durch Einfügen (InsertionSort) bei Char
	public char[] insertionSortChar(char x[]) {
		System.out.println("InsertionSort:");
		for (int i = 1; i < x.length; i++) {
			char key = x[i];
			int j = i - 1;
			while (j >= 0 && gte(x[j], key)) {
				x[j + 1] = x[j];
				j--;
			}
			x[j + 1] = key;
		}
		ausgabeChar(x);
		return x;
	}

	// Sortieren durch Vertauschen (BubbleSort) bei Int
	public int[] bubbleSort(int x[]) {
		System.out.println("BubbleSort:");
		for (int i = 0; i < x.length; i++) {
			for (int j = 1; j < x.length - 1; j++) {
				if (lt(x[j], x[j - 1])) {
					swap(x, j - 1, j);
				}
			}
		}
		ausgabe(x);
		return x;
	}

	// Sortieren durch Vertauschen (BubbleSort) bei Char
	public char[] bubbleSortChar(char x[]) {
		System.out.println("BubbleSort:");
		for (int i = 0; i < x.length; i++) {
			for (int j = 1; j < x.length - 1; j++) {
				if (lt(x[j], x[j - 1])) {
					char temp = x[j - 1];
					x[j - 1] = x[j];
					x[j] = temp;
				}
			}
		}
		ausgabeChar(x);
		return x;
	}

	// QuickSort
	public static void quickSort(int[] x) {
		System.out.println("QuickSort:");
		_quickSort(0, x.length-1, x);
		ausgabe(x);
	}

	public static void _quickSort(int leftIndex, int rightIndex, int[] a) {
		// Abbruchbedingung
		if (leftIndex >= rightIndex) {
			return;
		}
		int l = leftIndex;
		int r = rightIndex - 1;
		int pivot = a[rightIndex];

		do {
			while (a[l] <= pivot && l < rightIndex) {
				l++;
			}
			while (a[r] >= pivot && r > leftIndex) {
				r++;
			}
			if (l < r) {
				//swap(a, i, k);
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
			}
		} while (l < r);

		if (a[l] > pivot) {
			int temp = a[l];
			a[l] = a[rightIndex];
			a[rightIndex] = temp;
		}
		_quickSort(leftIndex, l - 1, a);
		_quickSort(l + 1, rightIndex, a);
	}
	
	// MergeSort
		public static void mergeSort(int[] a) {
			System.out.println("MergeSort:");
			if (a.length <= 1) {
				return;
			}
			int midpoint = a.length / 2;
			int[] left = new int [midpoint];
			
			
			ausgabe(a);
		}

	// Ausgabe Int
	public static void ausgabe(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	// Ausgabe Char
	public static void ausgabeChar(char[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	@Override
	public void sort(int[] arg0) {
	}

}