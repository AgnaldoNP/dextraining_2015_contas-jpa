package br.com.dextra.finances.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Investiment extends BaseEntity{

	public static final String DESCRIPTION = "description";
	public static final String AMOUNT = "amount";
	public static final String MONTHLYINCOME = "monthlyIncome";

	@Column(name = DESCRIPTION)
	private String description;

	@Column(name = AMOUNT, precision = 10, scale = 4)
	private BigDecimal amount;

	@Column(name = MONTHLYINCOME)
	private BigDecimal monthlyIncome;

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(final BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

}
