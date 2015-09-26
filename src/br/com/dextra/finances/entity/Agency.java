package br.com.dextra.finances.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Agency extends BaseEntity {

	public final static String NAME = "name";
	public final static String ADDRESS = "adress";
	public final static String PHONES = "phones";

	@Column(name = NAME)
	private String name;

	@OneToOne(optional = false, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	private Address address;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH })
	@JoinTable(name = "agency_phone")
	private List<Phone> phones;

	public Agency() {
		super();
	}

	public Agency(final String name, final Address address,
			final List<Phone> phones) {
		super();
		this.name = name;
		this.address = address;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

}
