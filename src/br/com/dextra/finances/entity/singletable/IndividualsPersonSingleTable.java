package br.com.dextra.finances.entity.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue(value = IndividualsPersonSingleTable.DISCRIMINATORVALUE)
public class IndividualsPersonSingleTable extends PersonSingleTable {

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
