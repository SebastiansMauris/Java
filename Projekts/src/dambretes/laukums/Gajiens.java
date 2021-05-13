package dambretes.laukums;
import dambretes.laukums.Laukums;
import dambretes.laukums.Laukums.Builder;
import dambretes.kaulini.Kaulins;

public abstract class Gajiens {
 final Laukums laukums;
 final Kaulins kaulinaKustiba;
 final int galamerkaKoordinate;

 public static final Gajiens NAV_GAJIENA = new NavGajiena();	

 
 Gajiens(final Laukums laukums,
		 final Kaulins kaulinaKustiba,
		 final int galamerkaKoordinate) {
	 this.laukums = laukums;
	 this.kaulinaKustiba = kaulinaKustiba;
	 this.galamerkaKoordinate = galamerkaKoordinate;
 }
 
@Override
public int hashCode() {
	int result = 1;
	
	result = 31 * result + this.galamerkaKoordinate;
	result = 31 * result + this.kaulinaKustiba.hashCode();
	return result;
}
 
 @Override
 public boolean equals(final Object cits) {
	 if(this == cits) {
		 return true;
	 }
if(!(cits instanceof Gajiens)) {
	return false;
}
 final Gajiens citsGajiens = (Gajiens) cits;
 return getGalamerkaKoordinate() == citsGajiens.getGalamerkaKoordinate() &&
        getKaulinaKustiba().equals(citsGajiens.getKaulinaKustiba());   
 }
 
 
 
 public int getPasreizejasKoordinatas() {
	return this.getKaulinaKustiba().getKaulinaPozicija();
 }
 
 public Kaulins getKaulinaKustiba() {
	 return this.kaulinaKustiba;
 }
 public int getGalamerkaKoordinate() {
	 return this.galamerkaKoordinate;
 }
 public boolean irUzbrukums() {
	 return false;
 }
 public Kaulins getKaulinsKuramUzbruk(){
	 return null;
 }
 

public Laukums izpildit() {
		
		final Laukums.Builder builder = new Builder();
		
		for(Kaulins kaulins : this.laukums.pasreizejaisSpeletajs().getAktivieKaulini()) {
			if(!this.kaulinaKustiba.equals(kaulins)) {
				builder.setKaulins(kaulins);
			}
		}
		for(Kaulins kaulins : this.laukums.pasreizejaisSpeletajs().getPretinieks().getAktivieKaulini()) {
			builder.setKaulins(kaulins);
		}
		//
		builder.setKaulins(this.kaulinaKustiba.parvietotKaulinu(this));
		builder.setKamIrGajiens(this.laukums.pasreizejaisSpeletajs().getPretinieks().getKrasa());
		return builder.build();
	}
 
public static final class ParastsGajiens extends Gajiens{
	 
	public ParastsGajiens(Laukums laukums, Kaulins kaulinaKustiba, int galamerkaKoordinate)
	{ super(laukums, kaulinaKustiba, galamerkaKoordinate); }

	
 }
 
public static final class UzbrukumaGajiens extends Gajiens{
	 
	 final Kaulins kaulinsKuramUzbruk;
	 
	 public UzbrukumaGajiens(Laukums laukums, Kaulins kaulinaKustiba, int galamerkaKoordinate, Kaulins kaulinsKuramUzbruk)
	 {super(laukums, kaulinaKustiba, galamerkaKoordinate);
	 this.kaulinsKuramUzbruk = kaulinsKuramUzbruk;
	 }
     @Override
     public int hashCode() {
    	 return this.kaulinsKuramUzbruk.hashCode() + super.hashCode();
     }
	 @Override
	 public boolean equals(final Object cits) {
		 if(this == cits) {
			 return true;
		 }
		 if(!(cits instanceof UzbrukumaGajiens)) {
			 return false;
		 }
	 final UzbrukumaGajiens citsUzbrukumaGajiens = (UzbrukumaGajiens) cits;
	 return super.equals(citsUzbrukumaGajiens) && getKaulinsKuramUzbruk().equals(citsUzbrukumaGajiens.getKaulinsKuramUzbruk());
	 }
	 
	 
	 @Override
public boolean irUzbrukums() {
	return true;
} 

	 @Override
public Kaulins getKaulinsKuramUzbruk() {
	return this.kaulinsKuramUzbruk;
}
	}

public static final class NavGajiena extends Gajiens {
	public NavGajiena() {
		super(null, null , -1);}
	}
	
	


public static class gajienuGeneracija {
	public static Gajiens uztaisitGajienu(final Laukums laukums,
			final int pasreizejasKoordinatas,
			final int galamerkaKoordinate) {
		
		for(final Gajiens gajiens : laukums.getVisiLegalieGajieni()) {
			if(gajiens.getPasreizejasKoordinatas() == pasreizejasKoordinatas &&
					gajiens.getGalamerkaKoordinate() == galamerkaKoordinate) {
				return gajiens;
			}
			
		}
		return NAV_GAJIENA;
		
	}
	
}
}


	
	 
 


 
 


 

