package br.com.dextra.finances.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Person extends BaseEntity{

	public static final String NAME = "name";
	public static final String BIRTHDATE = "birthDate";
	public static final String GROSSSALARY = "grossSalary";

	@Column(name = NAME)
	private String name;

	@Column(name = BIRTHDATE)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name = GROSSSALARY)
	private BigDecimal grossSalary;

	public Person() {
		super();
	}

	public Person(final String name, final Date birstDate) {
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

	public int getAge() {
		if (birthDate != null) {
			final long now = System.currentTimeMillis();
			final long birth = birthDate.getTime();

			final long dif = now - birth;

			return (int) (dif / (24 * 60 * 60 * 1000 * 365));
		}

		return 0;
	}

}
