package com.chaitanya.microservice.currencycalculationservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chaitanya.microservice.currencycalculationservice.model.ConvertedAmount;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyCalculationFeignProxy {

	@GetMapping("/Exchange-service/from/{from}/to/{to}")
	public ConvertedAmount getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
