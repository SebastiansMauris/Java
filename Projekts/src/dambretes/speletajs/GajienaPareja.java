package dambretes.speletajs;

import dambretes.laukums.Gajiens;
import dambretes.laukums.Laukums;

public class GajienaPareja {

	final Laukums parejasLaukums;
	final Gajiens gajiens;
	final GajienaStavoklis gajienaStavoklis;
	
	public GajienaPareja(final Laukums parejasLaukums,
			final Gajiens gajiens,
            final GajienaStavoklis gajienaStavoklis) {
		this.parejasLaukums = parejasLaukums;
		this.gajiens = gajiens;
		this.gajienaStavoklis = gajienaStavoklis;
	}
	
	public GajienaStavoklis getGajienaStavoklis() {
		return this.gajienaStavoklis;
	}
	
	public Laukums getParejasLaukums() {
		return this.parejasLaukums;
	}
}
