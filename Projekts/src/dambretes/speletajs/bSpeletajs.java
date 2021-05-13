package dambretes.speletajs;

import java.util.Collection;

import dambretes.kaulini.Kaulins;
import dambretes.kaulini.Krasa;
import dambretes.laukums.Gajiens;
import dambretes.laukums.Laukums;

public class bSpeletajs extends speletajs{

	public bSpeletajs(Laukums laukums,
			Collection<Gajiens> legaliGajieniBaltiem,
			Collection<Gajiens> legaliGajieniMelniem) {
	super(laukums, legaliGajieniBaltiem, legaliGajieniMelniem);	
	}

	@Override
	public Collection<Kaulins> getAktivieKaulini() {
		
		return this.laukums.getBaltieKaulini();
	}

	@Override
	public Krasa getKrasa() {
		return Krasa.BALTS;
	}

	@Override
	public speletajs getPretinieks() {
		return this.laukums.mSpeletajs();
	}
	

}
