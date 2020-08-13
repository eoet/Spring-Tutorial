package com.ifi.iot.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ifi.iot.connection.HibernateUtils;
import com.ifi.iot.entities.Employee;

public class EmployeeRepository {

	public EmployeeRepository() {
	}

	public List<Employee> fetchAll() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		List<Employee> employees = null;
		try {
			session.getTransaction().begin();
			String sql = "FROM " + Employee.class.getName();
			Query<Employee> query = session.createQuery(sql);
			employees = query.getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

		return employees;
	}

	public Employee create(Employee eIn) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee employee = eIn.clone();
		try {
			session.getTransaction().begin();
			session.persist(employee);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

		return employee;
	}

	public Employee update(Employee eIn) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee employee = null;
		try {
			session.getTransaction().begin();
			employee = session.find(Employee.class, eIn.getId());
			session.flush();
			
			employee.update(eIn);
			session.update(employee);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

		return employee;
	}

	public boolean delete(int eInId) {
		boolean isDeleted = false;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			Employee employee = session.find(Employee.class, eInId);
			session.flush();
			session.remove(employee);
			session.flush();
			isDeleted = true;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

		return isDeleted;
	}
}
