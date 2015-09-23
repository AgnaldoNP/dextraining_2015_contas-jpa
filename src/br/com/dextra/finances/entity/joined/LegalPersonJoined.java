package br.com.dextra.finances.entity.joined;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue(value = LegalPersonJoined.DISCRIMINATORVALUE)
public class LegalPersonJoined extends PersonJoined {

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
