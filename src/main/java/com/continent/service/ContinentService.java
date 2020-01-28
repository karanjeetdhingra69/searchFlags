package com.continent.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.continent.model.Continent;
import com.continent.model.Country;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ContinentService {

	ObjectMapper mapper = new ObjectMapper();

	public List<Country> getFlags(String continentReq, String countryReq) throws IOException {
		List<Continent> continents = null;
		List<Country> countryList = new ArrayList<Country>();
		String jsonString = null;
		File resource = new ClassPathResource("continents.json").getFile();
		jsonString = new String(Files.readAllBytes(resource.toPath()));
		if (jsonString != null) {
			continents = mapper.readValue(jsonString,
					mapper.getTypeFactory().constructParametricType(List.class, Continent.class));
		}
		if (continentReq != null && !CollectionUtils.isEmpty(continents)) {
			for (Continent continent : continents) {
				if (continent.getContinent().equalsIgnoreCase(continentReq)) {
					countryList = continent.getCountries();
					break;
				}
			}
		}
		if(countryReq != null && !CollectionUtils.isEmpty(countryList)) {
			countryList = new ArrayList<Country>(); 
			for (Country country : countryList) {
				if (country.getName().equalsIgnoreCase(countryReq)) {					
					countryList.add(country);
					break;
				}
			}
		}

		return countryList;
	}
}
