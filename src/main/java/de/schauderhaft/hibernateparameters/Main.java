package de.schauderhaft.hibernateparameters;

import static java.util.Arrays.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map properties = new HashMap();
		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test", properties);

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("from MyEntity where id in ?1");

		query.setParameter(1, asList("alpha")); // works

		query.setParameter(new Parameter<List>() { // <--- FAILS with NPE
			public String getName() {
				return null;
			}

			public Integer getPosition() {
				return 1;
			}

			public Class<List> getParameterType() {
				return List.class;
			}
		}, asList("alpha"));
	}
}
