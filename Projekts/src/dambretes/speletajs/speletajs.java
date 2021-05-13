package dambretes.speletajs;

import java.util.Collection;

import dambretes.kaulini.Kaulins;
import dambretes.kaulini.Krasa;
import dambretes.laukums.Gajiens;
import dambretes.laukums.Laukums;

public abstract class speletajs {
	
	final Laukums laukums;
	final Collection<Gajiens> legaliGajieni;

	
	
	speletajs(Laukums laukums, 
			Collection<Gajiens> legaliGajieni,
			Collection<Gajiens> pretiniekaGajieni){
		this.laukums = laukums;
		this.legaliGajieni = legaliGajieni;
		
		
	}
	
	public boolean vaiGajiensLegals(final Gajiens gajiens) {
		return this.legaliGajieni.contains(gajiens);
	}
	
	public Collection<Gajiens> getLegaliGajieni() {
		return this.legaliGajieni;
	}
	
	public boolean navLegaluGajienu() {
		return !this.irIzbegsanasGajieni()	;
	}
    boolean irIzbegsanasGajieni() {
    	
    	for(final Gajiens gajiens : this.legaliGajieni) {
    		final GajienaPareja pareja = izpilditGajienu(gajiens);
    		if(pareja.getGajienaStavoklis().irIzpildits()) {
    			return true;
    		}
    				
    	}
    	return false;
    }	
	
	
	public GajienaPareja izpilditGajienu(final Gajiens gajiens) {
		
		if(!vaiGajiensLegals(gajiens)) {
			return new GajienaPareja(this.laukums, gajiens, GajienaStavoklis.NELEGALS_GAJIENS);
		}
		final Laukums parejasLaukums = gajiens.izpildit();
		
		
		return new GajienaPareja(parejasLaukums, gajiens, GajienaStavoklis.IZPILDITS);
	}
	
	
	
	
	
	
	public abstract Collection<Kaulins> getAktivieKaulini();
    public abstract Krasa getKrasa();
    public abstract speletajs getPretinieks();
    
}
