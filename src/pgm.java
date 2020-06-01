import de.medieninf.ads.ADSTool;

public class pgm {
	public static int getSingleWeighting(int[] pic, int pos, int weighting) {
		if(pos > pic.length -1 || pos <= 2)
			return 0;
		else
			return pic[pos] * weighting;
	}
	
	public static int weighting(int[] pic, int pos) {
		int width = pic[0];
		int ga = 0;
		int gb = 0;
						
		//Ga
		ga += getSingleWeighting(pic, pos - width - 1,  1);
		ga += getSingleWeighting(pic, pos - 1,          2);
		ga += getSingleWeighting(pic, pos + width - 1,  1);
		ga += getSingleWeighting(pic, pos + width + 1, -1);
		ga += getSingleWeighting(pic, pos + 1,         -2);
		ga += getSingleWeighting(pic, pos - width + 1, -1);

		//Gb
		gb += getSingleWeighting(pic, pos - width,      2);
		gb += getSingleWeighting(pic, pos - width - 1,  1);
	    gb += getSingleWeighting(pic, pos + width - 1, -1);
		gb += getSingleWeighting(pic, pos + width,     -2);
		gb += getSingleWeighting(pic, pos + width + 1, -1);
		gb += getSingleWeighting(pic, pos - width + 1,  1);
			
		if( ga < 0) ga *= -1;		
		if( gb < 0) gb *= -1;		
	
		return ga + gb;
	}
	
	public static void main(String[] args) {
		kante("/Users/till/eclipse-workspace/ADS4_Aufgabe1/src/files/a.pgm"
			, "/Users/till/eclipse-workspace/ADS4_Aufgabe1/src/lena_kante.pgm");
	}
	
	public static void kante(String fileIn, String fileOut) {
		int[] pic = ADSTool.readPGM(fileIn);
		int[] picNew = new int[pic.length];
		int greyMax = 0;
		int greyCur = 0;
		
		for(int i = 3; i < pic.length; i++) {
			greyCur = weighting(pic, i);
			picNew[i] = greyCur;
			
			if(greyCur > greyMax)
				greyMax = greyCur;
		}
		
		picNew[0] = pic[0];
		picNew[1] = pic[1];
		picNew[2] = greyMax;

		ADSTool.savePGM(fileOut, picNew);
	}

}
