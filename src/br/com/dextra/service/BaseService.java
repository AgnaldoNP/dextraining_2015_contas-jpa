package br.com.dextra.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;

import br.com.dextra.common.service.EntityManagerUtil;
import br.com.dextra.finances.entity.BaseEntity;

public class BaseService {

	public static <T> BaseEntity[] saveEntitys(final BaseEntity... baseEntitys) {
		if ((baseEntitys != null) && (baseEntitys.length > 0)) {
			final EntityTransaction tran =
					EntityManagerUtil.getEM().getTransaction();
			tran.begin();
			try {
				for (final BaseEntity baseEntity : baseEntitys) {
					if (baseEntity.getId() == null) {
						EntityManagerUtil.getEM().persist(baseEntity);
					} else {
						EntityManagerUtil.getEM().merge(baseEntity);
					}
					tran.commit();
				}
			} catch (final Exception e) {
				e.printStackTrace();
				try {
					tran.rollback();
				} catch (final Exception e1) {
					e1.printStackTrace();
					throw e;
				}
			}
		}
		return baseEntitys;
	}

	public static <T> BaseEntity saveEntity(final BaseEntity baseEntity) {
		if (baseEntity != null) {
			final EntityTransaction tran =
					EntityManagerUtil.getEM().getTransaction();
			tran.begin();
			try {
				baseEntity.setVersion(baseEntity.getVersion() + 1);
				baseEntity.setLastUpdate(new Date(System.currentTimeMillis()));
				if (baseEntity.getId() == null) {
					EntityManagerUtil.getEM().persist(baseEntity);
				} else {
					EntityManagerUtil.getEM().merge(baseEntity);
				}
				tran.commit();
			} catch (final Exception e) {
				e.printStackTrace();
				try {
					tran.rollback();
				} catch (final Exception e1) {
					e1.printStackTrace();
					throw e1;
				}
			}
		}
		return baseEntity;
	}

	public static <T> T saveEntity2(final T entity) {
		if (entity != null) {
			final EntityTransaction tran =
					EntityManagerUtil.getEM().getTransaction();
			tran.begin();
			try {
				EntityManagerUtil.getEM().persist(entity);
				tran.commit();
			} catch (final Exception e) {
				e.printStackTrace();
				try {
					tran.rollback();
				} catch (final Exception e1) {
					e1.printStackTrace();
					throw e1;
				}
			}
		}
		return entity;
	}

	public static <T> T deleteEntity(final T entity) {
		if (entity != null) {
			final EntityTransaction tran =
					EntityManagerUtil.getEM().getTransaction();
			tran.begin();
			try {
				EntityManagerUtil.getEM().persist(entity);
				tran.commit();
			} catch (final Exception e) {
				e.printStackTrace();
				try {
					tran.rollback();
				} catch (final Exception e1) {
					e1.printStackTrace();
					throw e1;
				}
			}
		}
		return entity;
	}

	public static void delete(final BaseEntity baseEntity) {
		final EntityTransaction tran =
				EntityManagerUtil.getEM().getTransaction();
		tran.begin();
		try {
			EntityManagerUtil.getEM().remove(baseEntity);
		} catch (final Exception e) {
			e.printStackTrace();
			try {
				tran.rollback();
			} catch (final Exception e2) {
				e.printStackTrace();
				throw e2;
			}
		}
		tran.commit();
	}

	public static <T> T getById(final Class<T> baseClass, final Long id) {
		try {
			if (id == null) {
				return null;
			}
			return EntityManagerUtil.getEM().find(baseClass, id);
		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static <T> List<T> getAll(final Class<T> baseClass) {
		try {
			final String jpql =
					String.format("SELECT c FROM %s c",
							baseClass.getSimpleName());

			return EntityManagerUtil.getEM().createQuery(jpql, baseClass)
					.getResultList();

		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
