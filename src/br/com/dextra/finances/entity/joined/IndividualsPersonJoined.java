package br.com.dextra.finances.entity.joined;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue(value = IndividualsPersonJoined.DISCRIMINATORVALUE)
public class IndividualsPersonJoined extends PersonJoined {

	public static final String DISCRIMINATORVALUE = "CPF";

	@Column
	private String CPF;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(final String cPF) {
		CPF = cPF;
	}

}
