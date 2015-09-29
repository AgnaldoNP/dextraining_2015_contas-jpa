package br.com.dextra.finances.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Employee extends BaseEntity {

	private String name;


	@ManyToOne
	private Department departments;

}
