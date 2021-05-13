package dambretes.laukums;

public class LaukumsPielikums {
	
	public static final boolean[] PIRMA_KOLONNA = initKolonna(0);
	public static final boolean[] ASTOTA_KOLONNA = initKolonna(7);
	
	public static final boolean[] PIRMA_RINDA = initRinda(0);
	public static final boolean[] OTRA_RINDA = initRinda(8);
	public static final boolean[] TRESA_RINDA = initRinda(16);
	public static final boolean[] CETURTA_RINDA = initRinda(24);
	public static final boolean[] PIEKTA_RINDA = initRinda(32);
	public static final boolean[] SESTA_RINDA = initRinda(40);
	public static final boolean[] SEPTITA_RINDA = initRinda(48);
	public static final boolean[] ASTOTA_RINDA = initRinda(56);

	
	
	public static final int LAUCINU_SKAITS = 64;
	public static final int LAUCINU_SKAITS_RINDA = 8;
	
	
	public static boolean[]initKolonna(int kolonnasNumurs){
		
		final boolean[] kolonna = new boolean[LAUCINU_SKAITS];
		
		while(kolonnasNumurs<LAUCINU_SKAITS) {
			kolonna[kolonnasNumurs] = true;
			kolonnasNumurs +=LAUCINU_SKAITS_RINDA;
		}
	return kolonna;
	
	
	}
	
	


private static boolean[] initRinda(int rindasNumurs) {
		final boolean[] rinda = new boolean[LAUCINU_SKAITS];
		while(rindasNumurs % LAUCINU_SKAITS_RINDA != 0);{
			rinda[rindasNumurs] = true;
			rindasNumurs++;
			}
		return rinda;
	}




public static boolean vaiDerigaLaucinaKoord(int koordinate) {
	return koordinate >=0 && koordinate < LAUCINU_SKAITS;
}

}