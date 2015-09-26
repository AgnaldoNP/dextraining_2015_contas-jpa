package br.com.dextra.finances.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "", sequenceName = "")
public class ServicePackage extends BaseEntity {

	public static final String NAME = "name";
	public static final String AMOUT = "amout";

	@Column(name = NAME)
	private String name;

	@Column(name = AMOUT, precision = 2, scale = 2)
	private Double amount;

	@ManyToMany
	private List<Person> persons;

	public ServicePackage() {
		super();
	}

	public ServicePackage(final String name, final Double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(final List<Person> persons) {
		this.persons = persons;
	}

}
