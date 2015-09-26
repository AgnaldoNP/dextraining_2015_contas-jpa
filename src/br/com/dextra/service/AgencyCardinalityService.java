package br.com.dextra.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextra.common.service.EntityManagerUtil;
import br.com.dextra.finances.entity.Agency;

public class AgencyCardinalityService {

	@SuppressWarnings("unchecked")
	public static List<Agency> getByPhone(
			final String ddd, final String phone) {
		try {
			String jpql =
					String.format("SELECT a FROM %s a ",
							Agency.class.getSimpleName());
			jpql += "INNER JOIN a.phones phone ";
			jpql += "WHERE phone.countryCode = :countryCode ";
			jpql += "AND phone.number = :number ";

			final EntityManager entityManager = EntityManagerUtil.getEM();
			final Query query = entityManager.createQuery(jpql);
			query.setParameter("countryCode", phone);
			query.setParameter("number", phone);

			return query.getResultList();

		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
