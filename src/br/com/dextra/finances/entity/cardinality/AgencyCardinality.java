package br.com.dextra.finances.entity.cardinality;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.dextra.finances.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class AgencyCardinality extends BaseEntity {

	public final static String NAME = "name";
	public final static String ADDRESS = "adress";
	public final static String PHONES = "phones";

	@Column(name = NAME)
	private String name;

	@OneToOne(optional = false, cascade = CascadeType.MERGE)
	private AddressCardinality address;

	@OneToMany(cascade = CascadeType.ALL)
	private List<PhoneCardinality> phones;

	public AgencyCardinality() {
		super();
	}

	public AgencyCardinality(final String name,
			final AddressCardinality address, final List<PhoneCardinality> phones) {
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

	public AddressCardinality getAddress() {
		return address;
	}

	public void setAddress(final AddressCardinality address) {
		this.address = address;
	}

}
