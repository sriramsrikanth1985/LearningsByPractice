package enumExample;

public class EnumExamples {
	 public enum Currency {
	        PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	        private int value;

	        private Currency(int value) {
	                this.value = value;
	        }
	        
	        @Override
	        public String toString() {
	             switch (this) {
	               case PENNY:
	                    System.out.println("Penny: " + value);
	                    break;
	               case NICKLE:
	                    System.out.println("Nickle: " + value);
	                    break;
	               case DIME:
	                    System.out.println("Dime: " + value);
	                    break;
	               case QUARTER:
	                    System.out.println("Quarter: " + value);
	              }
	        return super.toString();
	       }

	};
	
	 public enum CurrencyName {
	        PENNY("INR"), NICKLE("DLR"), DIME("SDLR"), QUARTER("PAISE");
	        private String value;

	        private CurrencyName(String value) {
	                this.value = value;
	        }
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*System.out.println(Currency.PENNY.value);
System.out.println(CurrencyName.PENNY.value);*/
		
/*		for(Currency curr:Currency.values()){
			System.out.println(curr.value);
		}*/
		
		/*
		for(CurrencyName curr:CurrencyName.values()){
			System.out.println(curr.value);
		}*/
/*		Currency usCoin = Currency.DIME;
		System.out.println(usCoin);*/
		
		System.out.println(Currency.valueOf("abc"));



	}

}
