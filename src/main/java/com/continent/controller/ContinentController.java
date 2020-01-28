package com.continent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.continent.model.Country;
import com.continent.service.ContinentService;

@Controller
public class ContinentController {

	@Autowired
	ContinentService service;

	@RequestMapping(value = "/fetchFlags", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Country>> getFlagsByContinentAndCountry(@RequestParam String continent,
			@RequestParam(required = false) String country)
			throws IOException {
		ResponseEntity<List<Country>> resEntity = null;
		List<Country> countryList = service.getFlags(continent, country);
		if (!CollectionUtils.isEmpty(countryList)) {
			resEntity = new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
		} else {
			resEntity = new ResponseEntity<List<Country>>(new ArrayList<Country>(), HttpStatus.NO_CONTENT);
		}
		return resEntity;
	}
}
