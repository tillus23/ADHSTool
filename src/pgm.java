import de.medieninf.ads.ADSTool;

public class pgm {
	
	public static int getColorValue(int[] pic, int pos) {
		int ret = 0;
		
		if(pos > pic.length || pos <= 2)
			return ret;
		
		return pic[pos];
	}
	
	public static int getSingleWeighting(int[] pic, int pos, int weighting) {
		if(pos > pic.length -1 || pos <= 2) {
			return 0;
		}else {
			return pic[pos] * weighting;
		}
	}
	
	public static boolean isPixel(int[] pic, int pos) {
		return (pos > pic.length || pos <= 2);
	}
	
	public static int weighting(int[] pic, int pos) {
		int width = pic[0];
		int ret = 0;
						
		//Ga
		int gaValNW = getSingleWeighting(pic, pos - width - 1,  1);
		int gaValW =  getSingleWeighting(pic, pos - 1,          2);
		int gaValSW = getSingleWeighting(pic, pos + width - 1,  1);
		int gaValSE = getSingleWeighting(pic, pos + width + 1, -1);
		int gaValE =  getSingleWeighting(pic, pos + 1,         -2);
		int gaValNE = getSingleWeighting(pic, pos - width + 1, -1);
		
		int ga = gaValNW + gaValW + gaValSW + gaValSE + gaValE + gaValNE;

		//Gb
		int gbValN = getSingleWeighting(pic, pos - width,       2);
		int gbValNW = getSingleWeighting(pic, pos - width - 1,  1);
		int gbValSW = getSingleWeighting(pic, pos + width - 1, -1);
		int gbValS = getSingleWeighting(pic, pos + width,      -2);
		int gbValSE = getSingleWeighting(pic, pos + width + 1, -1);
		int gbValNE = getSingleWeighting(pic, pos - width + 1,  1);
		
		
		int gb = gbValN + gbValNW + gbValSW + gbValS + gbValSE + gbValNE;
		
		ret = ga + gb;
		
		if( ga < 0) {
			ga *= -1;
		}
		
		if( gb < 0) {
			gb *= -1;
		}		
		
		return ga + gb;
	}
	
	public static void main(String[] args) {
		int[] pic = ADSTool.readPGM("/Users/till/eclipse-workspace/ADS4_Aufgabe1/src/lena.pgm");
		int[] picNew = new int[pic.length];
		int fuMax = 0;
		int fu = 0;
		
		for(int i = 3; i < pic.length; i++) {
			fu = weighting(pic, i);
			picNew[i] = fu;
			System.out.println(i +" -> "+ fu);
			
			if(fu > fuMax)
				fuMax = fu;
		}
		
		
		picNew[0] = pic[0];
		picNew[1] = pic[1];
		picNew[2] = fuMax;

		ADSTool.savePGM("/Users/till/eclipse-workspace/ADS4_Aufgabe1/src/stalin.pgm", picNew);
	}

}
