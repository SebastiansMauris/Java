package dambretes.laukums;

import java.util.HashMap;
import java.util.Map;

import dambretes.kaulini.Kaulins;

public abstract class Laucins {
      
	  int LaucinaKoordinatas;
	  
	  
	  
	  Laucins(int LaucinaKoordinatas){/* "constructor" metode, kura v�l�k b�s izsaukta apak�klas�s,
	  taj� glab�sies atbilsto�as lauci�u koordin�tas*/
    	  this.LaucinaKoordinatas = LaucinaKoordinatas;
      
	  
	  }
	  
	  
	  
	  public static Map<Integer, TukssLaucins> TUKSI_LAUCINI = uztaisitVisusIespejamosTuksusLaucinus();/*"Member field" main�gais,
	   kur� ir pieejams vis�m klases metod�m*/
		  
	  public static Map<Integer, TukssLaucins> uztaisitVisusIespejamosTuksusLaucinus() {/*�� metode uztaisa visus iesp�jamos tuk�us lauci�us,
		   kuri var par�d�ties sp�les laik�*/
		    	
		    	final Map<Integer, TukssLaucins> tuksuLaucinuKarte = new HashMap<>();
		    	
		    	for(int i = 0; i <LaukumsPielikums.LAUCINU_SKAITS; i++){
		    		tuksuLaucinuKarte.put(i, new TukssLaucins(i));
		    	}    	
		        return tuksuLaucinuKarte;
		  
		  } 	
		    	
	 public static Laucins uztaisitLaucinu(final int laucinaKoordinate, final Kaulins kaulins) {
		 return kaulins != null ? new PilnsLaucins(laucinaKoordinate, kaulins) : TUKSI_LAUCINI.get(laucinaKoordinate);
	 }
	  


	
	

    






	public abstract boolean vaiLaucinsIrAiznemts();/*�� metode p�rbaud�s vai lauci�� ir aiznemts,
     tiek izmantots "abstract", jo �� metode b�s defin�ta apak�klas�*/
    
    public abstract Kaulins getKaulins();/*�� metode no�ems kauli�u no dot� lauci�a*/

    public static final class TukssLaucins extends Laucins{/*apak�klase, kura att�lo tuk�u lauci�u */
    	
    	TukssLaucins(final int koordinata){
    		super(koordinata);/*izsauc "constructor" metodi*/
    	}
    	
    	@Override
    	public boolean vaiLaucinsIrAiznemts() {/*"p�r�em" metodi "vaiLaucinsIrAiznemts" atgrie� "false",
    	jo �� ir "TukssLaucins" klase, t�tad lauci�� ir tuk�s*/ 
    		
    		return false;
    	}
    	
    	@Override
    	public String toString() {
    		return "-";
    	}
    	
    	
    	
    	
    	
    	@Override
    	public Kaulins getKaulins() {/*"p�r�em" metodi "getKaulins" atgrie� "null",
    	jo uz tuk�a lauci�a nav kauli�u*/
    		return null;
    	}//tiek izmantots @Override, jo �� klase p�r�em metodes no klases "Laucins"
    	
    }
    public static final class PilnsLaucins extends Laucins{/*apak�klase, kura att�lo pilnu lauci�u(ar kauli�u uz t�)*/
    	
    	Kaulins kaulinsUzLaucina;
    	
    	PilnsLaucins(int LaucinaKoordinatas, Kaulins kaulinsUzLaucina){
    		super(LaucinaKoordinatas);
    		this.kaulinsUzLaucina = kaulinsUzLaucina;
    	}
    	
    	
    	
    	
    	
    	@Override
    	public boolean vaiLaucinsIrAiznemts() {
    		return true;
    	}
        @Override
    	public Kaulins getKaulins() {
    		return this.kaulinsUzLaucina;

        
        }
        
        @Override
    	public String toString() {
    		return getKaulins().getKaulinaKrasa().irMelns() ? getKaulins().toString().toLowerCase() :
    			   getKaulins().toString();
				
    	}
    
    
    
    }
	public int getLaucinaKoordinate() {
		
		return this.LaucinaKoordinatas;
	}
	

}

