package net.countryWebService;

import net.webservicex.Country;
import net.webservicex.CountrySoap;

public class FirstWebServiceForCountryCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 1){
			System.out.println("Invalid Inputs");
		} else {
			String currencyCode = args[0];
			
			Country country = new Country();
			CountrySoap countrySoap = country.getCountrySoap();
			
			String countryName = countrySoap.getCountryByCurrencyCode(currencyCode);
			System.out.println("Country: "+countryName);
		}

	}

}
