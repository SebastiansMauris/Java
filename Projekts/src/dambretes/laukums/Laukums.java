package dambretes.laukums;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import dambretes.kaulini.Kaulins;
import dambretes.kaulini.Krasa;
import dambretes.kaulini.parastsKaulins;
import dambretes.speletajs.bSpeletajs;
import dambretes.speletajs.mSpeletajs;
import dambretes.speletajs.speletajs;

public class Laukums {
	
	final List<Laucins> spelesLaukums;
	final Collection<Kaulins> baltieKaulini;
	final Collection<Kaulins> melnieKaulini;
	
	
	final mSpeletajs mSpeletajs;
	final bSpeletajs bSpeletajs;
	public speletajs pasreizejaisSpeletajs;

	
	
	
	

	public Laukums(final Builder builder) {
		this.spelesLaukums = uztaisitSpelesLaukumu(builder);
		this.baltieKaulini = izrekinatAktivosKaulinus(this.spelesLaukums, Krasa.BALTS);
		this.melnieKaulini = izrekinatAktivosKaulinus(this.spelesLaukums, Krasa.MELNS);
		
		
		Collection<Gajiens> legaliGajieniBaltiem = izrekinatLegalosGajienus(this.baltieKaulini);
		Collection<Gajiens> legaliGajieniMelniem = izrekinatLegalosGajienus(this.melnieKaulini);
		
		this.mSpeletajs = new mSpeletajs(this, legaliGajieniBaltiem, legaliGajieniMelniem);
		this.bSpeletajs = new bSpeletajs(this, legaliGajieniBaltiem, legaliGajieniMelniem);
		
		this.pasreizejaisSpeletajs = builder.kamIrNakamaisGajiens.izveletiesSpeletaju(this.bSpeletajs, this.mSpeletajs);
		
	} 
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i< LaukumsPielikums.LAUCINU_SKAITS; i++) {
			String laucinuTeksts = this.spelesLaukums.get(i).toString();
			builder.append(String.format(laucinuTeksts));
			if((i + 1) % LaukumsPielikums.LAUCINU_SKAITS_RINDA == 0) {
				builder.append("\n");
			}
			
		}
		return builder.toString();
	}
	
	public speletajs bSpeletajs() {
		return this.bSpeletajs;
	}
	public speletajs mSpeletajs() {
		return this.mSpeletajs;
	}
	public speletajs pasreizejaisSpeletajs() {
		return this.pasreizejaisSpeletajs;
	}
	
	public Collection<Kaulins> getBaltieKaulini(){
		return this.baltieKaulini;
	}
	
	public Collection<Kaulins> getMelnieKaulini(){
		return this.melnieKaulini;
	}
	
	
	
	
	private String print(Laucins laucins) {
		
		return laucins.toString();
	}

	private Collection<Gajiens> izrekinatLegalosGajienus(Collection<Kaulins> kaulini) {
		
		List<Gajiens> legalieGajieni = new ArrayList<>();
		
		for(Kaulins kaulins : kaulini ) {
			
			legalieGajieni.addAll(kaulins.izrekinatLegalosGajienus(this));
			}
		return List.copyOf(legalieGajieni);
		}



	private Collection<Kaulins> izrekinatAktivosKaulinus(List<Laucins> spelesLaukums2, Krasa krasa) {
		final List<Kaulins> aktivieKaulini = new ArrayList<>();
		
		for(Laucins laucins : spelesLaukums) 
		{
			if(laucins.vaiLaucinsIrAiznemts()) {
				Kaulins kaulins = laucins.getKaulins();
				if(kaulins.getKaulinaKrasa() == krasa ) {
					aktivieKaulini.add(kaulins);
				}
			}
			
		}
		
		return List.copyOf(aktivieKaulini);
	}



	public Laucins getLaucins(final int LaucinaKoord) {
		return spelesLaukums.get(LaucinaKoord);
	}
	
	public static List<Laucins> uztaisitSpelesLaukumu(final Builder builder) {
		final Laucins [] laucini = new Laucins[LaukumsPielikums.LAUCINU_SKAITS];
		for(int i = 0; i<LaukumsPielikums.LAUCINU_SKAITS; i++) {
			laucini[i] = Laucins.uztaisitLaucinu(i, builder.laukumaIzkartojums.get(i));
		}
		return Collections.unmodifiableList(Arrays.asList(laucini));
	}
	
	public static Laukums uztaisitParastuSpelesLaukumu() {
		
		final Builder builder = new Builder();
		//melno kauliòu izkârtojums
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 1));
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 3));
		
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 5));
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 7));
		
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 8));
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 10));
		
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 12));
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 14));
		
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 17));
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 19));
		
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 21));
		builder.setKaulins(new parastsKaulins(Krasa.MELNS, 23));
		
		//balto kauliòu izkârtojums
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 62));
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 60));
		
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 58));
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 56));
		
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 55));
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 53));
		
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 51));
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 49));
		
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 46));
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 44));
		
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 42));
		builder.setKaulins(new parastsKaulins(Krasa.BALTS, 40));
		
		builder.setKamIrGajiens(Krasa.BALTS);
		
		return builder.build();
		
	}
	public Iterable<Gajiens> getVisiLegalieGajieni() {
        List<Gajiens> visiLegaliGajieni = new ArrayList<>();
        visiLegaliGajieni.addAll(this.bSpeletajs.getLegaliGajieni());
        visiLegaliGajieni.addAll(this.mSpeletajs.getLegaliGajieni());
        return Collections.unmodifiableList(visiLegaliGajieni);
    }
	
	public static class Builder {
		
		Map<Integer, Kaulins> laukumaIzkartojums;
		Krasa kamIrNakamaisGajiens;
		
		public Builder() {
			this.laukumaIzkartojums = new HashMap<>(32, 1.0f);
		}
		
		public Builder setKaulins(final Kaulins kaulins) {
			this.laukumaIzkartojums.put(kaulins.getKaulinaPozicija(), kaulins);
			return this;
			}
		
		public Builder setKamIrGajiens(final Krasa kamIrNakamaisGajiens) {
			this.kamIrNakamaisGajiens = kamIrNakamaisGajiens;
			return this;
			}
		
		
		
		
		
		public final Laukums build() {
			return new Laukums(this); 
		}
		
		
		
	}
	
	
}
