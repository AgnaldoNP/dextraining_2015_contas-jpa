package br.com.dextra.finances.entity.cardinality;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.dextra.finances.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class PhoneCardinality extends BaseEntity {

	public final static String NUMEBER = "number";
	public final static String COUNTRYCODE = "countryCode";

	@Column(name = NUMEBER)
	private String number;

	@Column(name = COUNTRYCODE)
	private int countryCode;

	public PhoneCardinality(final String number, final int countryCode) {
		super();
		this.number = number;
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final int countryCode) {
		this.countryCode = countryCode;
	}

}
