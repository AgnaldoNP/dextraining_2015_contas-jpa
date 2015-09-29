package br.com.dextra.finances.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class NumberCheckingAccount implements Serializable {

	private String number;

	private String verifyingDigit;

	public boolean numeroEhValido() {
		return true;
	}

	public NumberCheckingAccount() {
		super();

	}

	public NumberCheckingAccount(final String number, final String verifyingDigit) {
		super();
		this.number = number;
		this.verifyingDigit = verifyingDigit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getVerifyingDigit() {
		return verifyingDigit;
	}

	public void setVerifyingDigit(final String verifyingDigit) {
		this.verifyingDigit = verifyingDigit;
	}

}
