package dambretes.kaulini;

import dambretes.speletajs.bSpeletajs;
import dambretes.speletajs.mSpeletajs;
import dambretes.speletajs.speletajs;

public enum Krasa {// tiek izmantots "enum", lai glabat konstantas vertibas
      
	 BALTS{
  	     @Override
		public int virziens() {  /*atkariba no kaulinu krasas tieks atgriezta vertiba 1 vai -1 lai noteikt kura virziena kustesies kaulini */
  		   return -1;
  	   }
  	     
  	     @Override
  	     public boolean irMelns() {
  	    	 return false;
  	     }
  	   @Override
	     public boolean irBalts() {
	    	 return true;
	     }

	@Override
	public speletajs izveletiesSpeletaju(bSpeletajs bSpeletajs, mSpeletajs mSpeletajs) {
		return bSpeletajs;
	}
  	     
     },
     MELNS{
  	     @Override
    	 public int virziens() {
  		   return 1;
  	   }
  	   @Override
	     public boolean irMelns() {
	    	 return true;
	     }
  	 @Override
	     public boolean irBalts() {
	    	 return false;
	     }
	@Override
	public speletajs izveletiesSpeletaju(bSpeletajs bSpeletajs, mSpeletajs mSpeletajs) {
		return mSpeletajs;
	}
  	     
     };
  	   
     
     
     

     
     
     public abstract int virziens();

	public abstract boolean irMelns();
	public abstract boolean irBalts();

	public abstract speletajs izveletiesSpeletaju(bSpeletajs bSpeletajs, mSpeletajs mSpeletajs);	
		
	
	
	
}	
