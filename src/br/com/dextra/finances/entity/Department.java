package br.com.dextra.finances.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Department extends BaseEntity{

	private String name;

	@OneToMany(mappedBy = "departments")
	private List<Employee> employees;

}
