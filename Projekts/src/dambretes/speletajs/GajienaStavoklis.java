package dambretes.speletajs;

public enum GajienaStavoklis {
   IZPILDITS{
	   @Override
	public
	   boolean irIzpildits() {
		   return true;
	   }
   }, 
   NELEGALS_GAJIENS {
	@Override
	public
	boolean irIzpildits() {
		return false;
	}
};
	public abstract boolean irIzpildits();
}
