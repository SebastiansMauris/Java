package dambretes.kaulini;

import java.util.Collection;

import dambretes.laukums.Gajiens;
import dambretes.laukums.Laukums;




public abstract class Kaulins {
    
	final KaulinaTips kaulinaTips;
	final int glabatsHashCode;
	
	
	public final int kaulinaKoord;
    public final Krasa kaulinaKrasa;
    
    Kaulins(final KaulinaTips kaulinaTips,
    		final int kaulinaKoord, final Krasa kaulinaKrasa){/*"constructor" metode kura noteiks noteikta kauliòa
    koordinâtas un krâsu*/
    	this.kaulinaKoord=kaulinaKoord;
    	this.kaulinaKrasa=kaulinaKrasa;
    	this.kaulinaTips = kaulinaTips;
    	this.glabatsHashCode = izrekinatHashCode();
    }
    
    
  private int izrekinatHashCode() {
	  int result = kaulinaTips.hashCode();
  	result = 31 * result * kaulinaKrasa.hashCode();
  	result = 31 * result + kaulinaKoord;
  	return result;
	}


public KaulinaTips getKaulinaTips() {
	  return this.kaulinaTips; 
  }
    
    @Override 
    public boolean equals(Object cits) {
    	if (this==cits) {
    		return true;
    	}
    	if(!(cits instanceof Kaulins)) {
    		return false; 
    	}
    	Kaulins otherKaulins = (Kaulins) cits;
    	return kaulinaKoord == otherKaulins.getKaulinaPozicija() &&
    			kaulinaKrasa == otherKaulins.getKaulinaKrasa();
    	
    	}
    
    public int hashCode() {
    	return glabatsHashCode;
    }
    
    
    
    public int getKaulinaPozicija() {
       return this.kaulinaKoord;
    	
    }
    
    
    public Krasa getKaulinaKrasa() {
    	return this.kaulinaKrasa;
    }
    
    public abstract  Collection<Gajiens> izrekinatLegalosGajienus(final Laukums laukums);//ðî metode aprçíinâs visus legâlos gâjienus
    
    public abstract Kaulins parvietotKaulinu(Gajiens gajiens);
    
    
    
    
    public enum KaulinaTips{
    	 
    	PARASTSKAULINS("P"),
    	DAMA("D");
    	
    	private String kaulinaNosaukums;
    	
    	KaulinaTips(String kaulinaNosaukums){
    		
    		this.kaulinaNosaukums = kaulinaNosaukums;
    	}
    	
    	@Override
    	public String toString() {
    		return this.kaulinaNosaukums;
    	}
    }
}

   