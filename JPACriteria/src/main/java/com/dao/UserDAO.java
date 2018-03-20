package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.query.internal.QueryImpl;

import com.entity.User;

//reference
/*https://www.concretepage.com/hibernate-4/hibernate-4-criteria-query-tutorials-with-examples-using-jpa-2*/
/*https://www.thoughts-on-java.org/criteria-updatedelete-easy-way-to/*/
public class UserDAO extends AbstractDAO {

	public void create(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	public void update(User oldUser, User newUser) {
		entityManager.getTransaction().begin();
		CriteriaUpdate<User> updater = builder.createCriteriaUpdate(User.class);
		Root<User> root = updater.from(User.class);

		updater.set("userName", newUser.getUserName());
		updater.set("email", newUser.getEmail());
		updater.set("password", newUser.getPassword());
		updater.where(builder.equal(root.get("id"), oldUser.getId()));
		entityManager.createQuery(updater).executeUpdate();
		entityManager.getTransaction().commit();
		// convert to sql String
		System.out.println(entityManager.createQuery(updater).unwrap(QueryImpl.class).getQueryString());
	}

	public User findById(int userId) {
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.where(builder.equal(root.get("id"), userId));

		// convert to sql String
		System.out.println("findById: " + entityManager.createQuery(query).unwrap(QueryImpl.class).getQueryString());
		return entityManager.createQuery(query).getSingleResult();
	}

	public List<User> listAll() {
		CriteriaQuery<User> listQuery = builder.createQuery(User.class);
		listQuery.from(User.class);
		return entityManager.createQuery(listQuery).getResultList();
	}

	public List<User> listAndOrder(String order) {
		CriteriaQuery<User> listQuery = builder.createQuery(User.class);
		Root<User> root = listQuery.from(User.class);
		if (order.equalsIgnoreCase("asc")) {
			listQuery.orderBy(builder.asc(root.get("id")));
		} else {
			listQuery.orderBy(builder.desc(root.get("id")));
		}
		return entityManager.createQuery(listQuery).getResultList();
	}

	/*
	 * https://www.thoughts-on-java.org/hibernate-tips-difference-join-left-join
	 * -fetch-join/
	 * https://www.thoughts-on-java.org/5-ways-to-initialize-lazy-relations-and-
	 * when-to-use-them/
	 */ public User getAndJoin(int userId) {
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		Fetch<Object, Object> fetch = root.fetch("department", JoinType.INNER);
		query.where(builder.equal(root.get("id"), userId));
		/* root.join() */
		
		// convert to sql String
		System.out.println(
				"Inner Join String: " + entityManager.createQuery(query).unwrap(QueryImpl.class).getQueryString());
		return entityManager.createQuery(query).getSingleResult();
	}

	public void delete(int userId) {
		entityManager.getTransaction().begin();
		CriteriaDelete<User> deleter = builder.createCriteriaDelete(User.class);
		Root<User> root = deleter.from(User.class);
		deleter.where(builder.equal(root.get("id"), userId));
		System.out.println(deleter.toString());
		entityManager.createQuery(deleter).executeUpdate();
		entityManager.getTransaction().commit();
	}
}
