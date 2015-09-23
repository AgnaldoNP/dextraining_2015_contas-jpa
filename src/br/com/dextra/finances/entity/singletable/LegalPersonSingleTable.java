package br.com.dextra.finances.entity.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue(value = LegalPersonSingleTable.DISCRIMINATORVALUE)
public class LegalPersonSingleTable extends PersonSingleTable {

	public static final String DISCRIMINATORVALUE = "CNPJ";

	@Column
	private String CNPJ;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(final String cNPJ) {
		CNPJ = cNPJ;
	}

}
