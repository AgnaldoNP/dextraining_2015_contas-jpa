package br.com.dextra.finances.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Person extends BaseEntity {

	public static final String NAME = "name";
	public static final String GROSSSALARY = "grossSalary";
	public static final String ADDRESS = "address";

	@Column(name = NAME)
	private String name;

	@Column(name = GROSSSALARY)
	private BigDecimal grossSalary;

	@OneToOne(optional = true, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	private Address address;

	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	@JoinColumn(name = "person_Id")
	private List<Phone> phones;

	@Embedded
	@ElementCollection
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	private List<Investiment> investments;

	@Embedded
	@ElementCollection
	@OneToMany(mappedBy = "persons", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	private List<ServicePackage> servicePackages;

	public Person() {
		super();
	}

	public Person(final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(final BigDecimal grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(final List<Phone> phones) {
		this.phones = phones;
	}

	public List<Investiment> getInvestments() {
		return investments;
	}

	public void setInvestments(final List<Investiment> investments) {
		this.investments = investments;
	}

	public List<ServicePackage> getServicePackages() {
		return servicePackages;
	}

	public void setServicePackages(final List<ServicePackage> servicePackages) {
		this.servicePackages = servicePackages;
	}


}
