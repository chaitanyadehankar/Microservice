package com.chaitanya.microservice.currencycalculationservice.model;

import java.math.BigDecimal;

public class ConvertedAmount {

	private Long id;
	private String from;
	private String to;
	private BigDecimal exchangeRate;
	private BigDecimal quantity;
	private BigDecimal totalValue;
	private int port;

	public ConvertedAmount() {

	}

	public ConvertedAmount(Long id, String from, String to, BigDecimal exchangeRate, BigDecimal quantity,
			BigDecimal totalValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.quantity = quantity;
		this.totalValue = totalValue;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "ConvertedAmount [id=" + id + ", from=" + from + ", to=" + to + ", exchangeRate=" + exchangeRate
				+ ", quantity=" + quantity + ", totalValue=" + totalValue + ", port=" + port + "]";
	}

}
