package br.com.dextra.finances.entity.cardinality;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dextra.finances.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class PersonCardinality extends BaseEntity {

	public static final String NAME = "name";
	public static final String BIRTHDATE = "birthDate";
	public static final String GROSSSALARY = "grossSalary";
	public static final String ADDRESS = "address";

	@Column(name = NAME)
	private String name;

	@Column(name = BIRTHDATE)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name = GROSSSALARY)
	private BigDecimal grossSalary;

	@OneToOne(optional = true)
	private AddressCardinality address;

	public PersonCardinality() {
		super();
	}

	public PersonCardinality(final String name, final Date birstDate) {
		super();
		this.name = name;
		this.birthDate = birstDate;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirtDate(final Date birstDate) {
		this.birthDate = birstDate;
	}

	public BigDecimal getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(final BigDecimal grossSalary) {
		this.grossSalary = grossSalary;
	}

	public AddressCardinality getAddress() {
		return address;
	}

	public void setAddress(final AddressCardinality address) {
		this.address = address;
	}

}
