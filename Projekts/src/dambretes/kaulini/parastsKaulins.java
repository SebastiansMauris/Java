package dambretes.kaulini;
import static dambretes.laukums.Gajiens.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dambretes.laukums.Gajiens;
import dambretes.laukums.Laucins;
import dambretes.laukums.Laukums;
import dambretes.laukums.LaukumsPielikums;

public class parastsKaulins extends Kaulins {
	
	public final static int[] IESPEJAMIE_GAJIENI = {-18, -14, -9, -7, 7, 9, 14, 18};//member field "iespejamie gajieni" glabâ iespçjâmos gâjienus atkarîbâ no paðreizçjâs pozîcijas
	
	public parastsKaulins(final Krasa kaulinaKrasa, final int kaulinaKoord) {
		super(KaulinaTips.PARASTSKAULINS, kaulinaKoord, kaulinaKrasa);
		
	}
	
	@Override
	public Collection<Gajiens> izrekinatLegalosGajienus(final Laukums laukums){//
		final List<Gajiens> legaliGajieni = new ArrayList<>();
		
		
		for(final int pasreizejaGajienaParvietojums : IESPEJAMIE_GAJIENI) { //for loop aprçíina iespçjamos gâjienus
			
			final int iespejamasGajienaKoordinatas = this.kaulinaKoord + (pasreizejaGajienaParvietojums*this.getKaulinaKrasa().virziens());
			
			if (vaiDerigaLaucinaKoord(iespejamasGajienaKoordinatas)) {
				
				if(pirmasKolonnasIznemums(this.kaulinaKoord, pasreizejaGajienaParvietojums)||
				astotasKolonnasIznemums(this.kaulinaKoord, pasreizejaGajienaParvietojums)) {
					continue;
				}
				
				
				
				final Laucins iespejamaGajienaLaucins = laukums.getLaucins(iespejamasGajienaKoordinatas);
				
				
				if(!iespejamaGajienaLaucins.vaiLaucinsIrAiznemts()) {
					legaliGajieni.add(new ParastsGajiens(laukums, this, iespejamasGajienaKoordinatas));
				} else {
					
					final Kaulins kaulinsUzKoordinatas = iespejamaGajienaLaucins.getKaulins();
					final Krasa kaulinaKrasa = kaulinsUzKoordinatas.getKaulinaKrasa();
					
					if(this.kaulinaKrasa != kaulinaKrasa && pasreizejaGajienaParvietojums == 14 && pasreizejaGajienaParvietojums == -14
							&& pasreizejaGajienaParvietojums == -18 && pasreizejaGajienaParvietojums == 18 ) {
						legaliGajieni.add(new UzbrukumaGajiens(laukums, this, iespejamasGajienaKoordinatas, kaulinsUzKoordinatas));
					}
				}
			}
			
		}
		
		
		return List.copyOf(legaliGajieni);
	}
	
	@Override
	public String toString() {
		return kaulinaTips.PARASTSKAULINS.toString();
	}
	
	private static boolean vaiDerigaLaucinaKoord(int koordinate) {
	    return koordinate >=0 && koordinate < 64;
		
	}
	private static boolean pirmasKolonnasIznemums(final int pasreizejaPozicija, final int pasreizejsParvietojums) {
		return LaukumsPielikums.PIRMA_KOLONNA[pasreizejaPozicija] && ((pasreizejsParvietojums == 7) || (pasreizejsParvietojums == -9));
	}
	private static boolean astotasKolonnasIznemums(final int pasreizejaPozicija, final int pasreizejsParvietojums) {
		return LaukumsPielikums.ASTOTA_KOLONNA[pasreizejaPozicija] && ((pasreizejsParvietojums == -7) || (pasreizejsParvietojums == 9));
	}

	@Override
	public parastsKaulins parvietotKaulinu(Gajiens gajiens) {
		return new parastsKaulins(gajiens.getKaulinaKustiba().getKaulinaKrasa(), gajiens.getGalamerkaKoordinate());
	}




}
