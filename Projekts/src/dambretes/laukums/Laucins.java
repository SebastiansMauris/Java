package dambretes.laukums;

import java.util.HashMap;
import java.util.Map;

import dambretes.kaulini.Kaulins;

public abstract class Laucins {
      
	  int LaucinaKoordinatas;
	  
	  
	  
	  Laucins(int LaucinaKoordinatas){/* "constructor" metode, kura vçlâk bûs izsaukta apakðklasçs,
	  tajâ glabâsies atbilstoðas lauciòu koordinâtas*/
    	  this.LaucinaKoordinatas = LaucinaKoordinatas;
      
	  
	  }
	  
	  
	  
	  public static Map<Integer, TukssLaucins> TUKSI_LAUCINI = uztaisitVisusIespejamosTuksusLaucinus();/*"Member field" mainîgais,
	   kurð ir pieejams visâm klases metodçm*/
		  
	  public static Map<Integer, TukssLaucins> uztaisitVisusIespejamosTuksusLaucinus() {/*Ðî metode uztaisa visus iespçjamos tukðus lauciòus,
		   kuri var parâdîties spçles laikâ*/
		    	
		    	final Map<Integer, TukssLaucins> tuksuLaucinuKarte = new HashMap<>();
		    	
		    	for(int i = 0; i <LaukumsPielikums.LAUCINU_SKAITS; i++){
		    		tuksuLaucinuKarte.put(i, new TukssLaucins(i));
		    	}    	
		        return tuksuLaucinuKarte;
		  
		  } 	
		    	
	 public static Laucins uztaisitLaucinu(final int laucinaKoordinate, final Kaulins kaulins) {
		 return kaulins != null ? new PilnsLaucins(laucinaKoordinate, kaulins) : TUKSI_LAUCINI.get(laucinaKoordinate);
	 }
	  


	
	

    






	public abstract boolean vaiLaucinsIrAiznemts();/*ðî metode pârbaudîs vai lauciòð ir aiznemts,
     tiek izmantots "abstract", jo ðî metode bûs definçta apakðklasç*/
    
    public abstract Kaulins getKaulins();/*ðî metode noòems kauliòu no dotâ lauciòa*/

    public static final class TukssLaucins extends Laucins{/*apakðklase, kura attçlo tukðu lauciòu */
    	
    	TukssLaucins(final int koordinata){
    		super(koordinata);/*izsauc "constructor" metodi*/
    	}
    	
    	@Override
    	public boolean vaiLaucinsIrAiznemts() {/*"pâròem" metodi "vaiLaucinsIrAiznemts" atgrieþ "false",
    	jo ðî ir "TukssLaucins" klase, tâtad lauciòð ir tukðs*/ 
    		
    		return false;
    	}
    	
    	@Override
    	public String toString() {
    		return "-";
    	}
    	
    	
    	
    	
    	
    	@Override
    	public Kaulins getKaulins() {/*"pâròem" metodi "getKaulins" atgrieþ "null",
    	jo uz tukða lauciòa nav kauliòu*/
    		return null;
    	}//tiek izmantots @Override, jo ðî klase pâròem metodes no klases "Laucins"
    	
    }
    public static final class PilnsLaucins extends Laucins{/*apakðklase, kura attçlo pilnu lauciòu(ar kauliòu uz tâ)*/
    	
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

