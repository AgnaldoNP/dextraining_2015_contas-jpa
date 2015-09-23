package br.com.dextra.finances.entity.cardinality;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.dextra.finances.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class AddressCardinality extends BaseEntity {

	public final static String STREET = "street";
	public final static String NUMBER = "number";
	public final static String STATE = "state";
	public final static String CITY = "city";

	@Column(name = STREET)
	private String street;

	@Column(name = NUMBER)
	private int number;

	@Column(name = STATE)
	private String state;

	@Column(name = CITY)
	private String city;

	public AddressCardinality(final String street, final int number,
			final String state, final String city) {
		super();
		this.street = street;
		this.number = number;
		this.state = state;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(final int number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

}
