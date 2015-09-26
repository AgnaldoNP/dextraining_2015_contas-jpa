package br.com.dextra.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextra.common.service.EntityManagerUtil;
import br.com.dextra.finances.entity.Person;

public class PersonCardinalityService {

	@SuppressWarnings("unchecked")
	public static List<Person> getByAddressStae(final String state) {
		try {
			final String jpql =
					String.format("SELECT p FROM %s p WHERE p.address.state = :state",
							Person.class.getSimpleName());

			final EntityManager entityManager = EntityManagerUtil.getEM();
			final Query query = entityManager.createQuery(jpql);
			query.setParameter("state", state);

			return query.getResultList();

		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
