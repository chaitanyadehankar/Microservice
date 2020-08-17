package com.chaitanya.microservice.currencycalculationservice.controler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chaitanya.microservice.currencycalculationservice.feign.CurrencyCalculationFeignProxy;
import com.chaitanya.microservice.currencycalculationservice.model.ConvertedAmount;

@RestController
public class CurrencyCalculator {

	@Autowired
	CurrencyCalculationFeignProxy proxy;

	private RestTemplate restTemplate;

	@GetMapping("/currency-calculator/from/{from}/to/{to}/quantity/{quantity}")
	public ConvertedAmount getConvertedAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		restTemplate = new RestTemplate();

		Map<String, String> map = new HashMap<String, String>();
		map.put("from", from);
		map.put("to", to);

		ResponseEntity<ConvertedAmount> responseEntity = restTemplate
				.getForEntity("http://localhost:8001/Exchange-service/from/{from}/to/{to}", ConvertedAmount.class, map);

		ConvertedAmount responseAmount = responseEntity.getBody();

		return new ConvertedAmount(responseAmount.getId(), from, to, responseAmount.getExchangeRate(), quantity,
				quantity.multiply(responseAmount.getExchangeRate()), responseAmount.getPort());

	}

	@GetMapping("/currency-calculator-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConvertedAmount getConvertedAmountFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		ConvertedAmount responseAmount = proxy.getExchangeValue(from, to);

		return new ConvertedAmount(responseAmount.getId(), from, to, responseAmount.getExchangeRate(), quantity,
				quantity.multiply(responseAmount.getExchangeRate()), responseAmount.getPort());

	}
}
