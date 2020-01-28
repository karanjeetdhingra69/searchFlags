package com.continent.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "flag" })
public class Country {

	@JsonProperty("name")
	private String name;
	@JsonProperty("flag")
	private String flag;
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("flag")
	public String getFlag() {
		return flag;
	}

	@JsonProperty("flag")
	public void setFlag(String flag) {
		this.flag = flag;
	}
}