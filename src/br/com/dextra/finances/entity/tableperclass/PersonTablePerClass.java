package br.com.dextra.finances.entity.tableperclass;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dextra.finances.entity.BaseEntity;

@SuppressWarnings("serial")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonTablePerClass extends BaseEntity{

	public static final String NAME = "name";
	public static final String BIRTHDATE = "birthDate";
	public static final String TYPEPERSON = "typeperson";

	@Column(name = NAME)
	private String name;

	@Column(name = BIRTHDATE)
	@Temporal(TemporalType.DATE)
	private Date birthDate;


	public PersonTablePerClass() {
		super();
	}

	public PersonTablePerClass(final String name, final Date birstDate) {
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
