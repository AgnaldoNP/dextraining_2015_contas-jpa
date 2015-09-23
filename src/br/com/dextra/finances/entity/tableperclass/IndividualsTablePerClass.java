package br.com.dextra.finances.entity.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class IndividualsTablePerClass extends PersonTablePerClass {

	@Column
	private String CPF;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(final String cPF) {
		CPF = cPF;
	}

}
