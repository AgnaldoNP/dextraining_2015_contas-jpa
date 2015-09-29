package br.com.dextra.finances.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public  class ContaCorrente extends BaseEntity{

	@Embedded
	private NumberCheckingAccount numberCheckingAccount;

}
