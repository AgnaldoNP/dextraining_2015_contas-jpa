package br.com.dextra.finances.entity.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class LegalPersonTablePerClass extends PersonTablePerClass {

	@Column
	private String CNPJ;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(final String cNPJ) {
		CNPJ = cNPJ;
	}

}
