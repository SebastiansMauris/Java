package dambretes.speletajs;

import java.util.Collection;

import dambretes.kaulini.Kaulins;
import dambretes.kaulini.Krasa;
import dambretes.laukums.Gajiens;
import dambretes.laukums.Laukums;

public class mSpeletajs extends speletajs{

	public mSpeletajs(Laukums laukums,
			Collection<Gajiens> legaliGajieniBaltiem,	
			Collection<Gajiens> legaliGajieniMelniem) {
		super(laukums, legaliGajieniMelniem, legaliGajieniBaltiem);	
	}

	@Override
	public Collection<Kaulins> getAktivieKaulini() {
		return this.laukums.getMelnieKaulini();
	}

	@Override
	public Krasa getKrasa() {
		return Krasa.MELNS;
	}

	@Override
	public speletajs getPretinieks() {
		return this.laukums.bSpeletajs();
	}
	

}
