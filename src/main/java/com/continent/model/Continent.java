package com.continent.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "continent", "countries" })
public class Continent {

	@JsonProperty("continent")
	private String continent;
	@JsonProperty("countries")
	private List<Country> countries = null;

	@JsonProperty("continent")
	public String getContinent() {
		return continent;
	}

	@JsonProperty("continent")
	public void setContinent(String continent) {
		this.continent = continent;
	}

	@JsonProperty("countries")
	public List<Country> getCountries() {
		return countries;
	}

	@JsonProperty("countries")
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
}