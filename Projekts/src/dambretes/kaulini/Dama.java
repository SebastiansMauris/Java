package dambretes.kaulini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dambretes.kaulini.Kaulins.KaulinaTips;

import dambretes.laukums.Gajiens;
import dambretes.laukums.Laucins;
import dambretes.laukums.Laukums;
import dambretes.laukums.LaukumsPielikums;
import dambretes.laukums.Gajiens.ParastsGajiens;
import dambretes.laukums.Gajiens.UzbrukumaGajiens;

public class Dama extends Kaulins{

	private final static int[] IESPEJAMIE_GAJIENI = {-9, -7, 7, 9};
	
	
	
	
	public Dama(Krasa kaulinaKrasa ,int kaulinaKoord) {
		super(KaulinaTips.DAMA, kaulinaKoord, kaulinaKrasa);
		
	}

	@Override
	public Collection<Gajiens> izrekinatLegalosGajienus(Laukums laukums) {
		
		
		final List<Gajiens> legaliGajieni = new ArrayList<>();
		
		for(final int pasreizejaGajienaParvietojums : IESPEJAMIE_GAJIENI) {
			
			int iespejamasGajienaKoordinatas = this.kaulinaKoord;
			
			while(LaukumsPielikums.vaiDerigaLaucinaKoord(iespejamasGajienaKoordinatas)) {
				iespejamasGajienaKoordinatas += pasreizejaGajienaParvietojums;
				
				if(pirmasKolonnasIznemums(iespejamasGajienaKoordinatas, pasreizejaGajienaParvietojums) || 
						astotasKolonnasIznemums(iespejamasGajienaKoordinatas, pasreizejaGajienaParvietojums))
						{
					break;
						}
				
				
				
				
				if(LaukumsPielikums.vaiDerigaLaucinaKoord(iespejamasGajienaKoordinatas)) {
					final Laucins iespejamaGajienaLaucins = laukums.getLaucins(iespejamasGajienaKoordinatas);
					
					
					if(!iespejamaGajienaLaucins.vaiLaucinsIrAiznemts()) {
						legaliGajieni.add(new ParastsGajiens(laukums, this, iespejamasGajienaKoordinatas));
					} 
					
					else {
						
						final Kaulins kaulinsUzKoordinatas = iespejamaGajienaLaucins.getKaulins();
						final Krasa kaulinaKrasa = kaulinsUzKoordinatas.getKaulinaKrasa();
						
						if(this.kaulinaKrasa != kaulinaKrasa) {
							legaliGajieni.add(new UzbrukumaGajiens(laukums, this, iespejamasGajienaKoordinatas, kaulinsUzKoordinatas));
						}
						break;
					}
				}
			}
	    }
		return List.copyOf(legaliGajieni);
		
		
    }
	@Override
	public String toString() {
		return kaulinaTips.DAMA.toString();
	}
     private static boolean pirmasKolonnasIznemums(final int pasreizejaPozicija, final int pasreizejsParvietojums) {
    	 return LaukumsPielikums.PIRMA_KOLONNA[pasreizejaPozicija] && (pasreizejsParvietojums == -9 || pasreizejsParvietojums == 7);
    	  }
     
     private static boolean astotasKolonnasIznemums(final int pasreizejaPozicija, final int pasreizejsParvietojums) {
    	 return LaukumsPielikums.ASTOTA_KOLONNA[pasreizejaPozicija] && (pasreizejsParvietojums == 9 || pasreizejsParvietojums == -7);
    	  }


 	@Override
 	public Dama parvietotKaulinu(Gajiens gajiens) {
 		return new Dama(gajiens.getKaulinaKustiba().getKaulinaKrasa(), gajiens.getGalamerkaKoordinate());
 	}
}
