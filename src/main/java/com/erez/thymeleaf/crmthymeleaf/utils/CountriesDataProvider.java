package com.erez.thymeleaf.crmthymeleaf.utils;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Scope("singleton")
public class CountriesDataProvider {

	List<Country> countries = null;




	public CountriesDataProvider() {

	}


	public List<Country> getCountries() {
		return countries;
	}

	@PostConstruct
	private void loadCountriesData() {

		try {
			ObjectMapper mapper = new ObjectMapper();
			
			
			countries = Arrays.asList(mapper.readValue(Paths.get("data/countries.json").toFile(), Country[].class));
		

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printAllCuntris();

	}
	private void printAllCuntris(){

		List<State> theStates = new ArrayList<State>();
		
			
		for( int index = 0; index < countries.size() ; index++) {
			
			countries.get(index).setIndex(index);
			System.out.println(countries.get(index).getName() + "   "+countries.get(index).getIndex());
			
			if(countries.get(index).getStates() != null ) {
				theStates =  countries.get(index).getStates();
				for(State state : theStates ) {
					System.out.println("     "  + state.getName());

				}
			}

		}  



	}			



}