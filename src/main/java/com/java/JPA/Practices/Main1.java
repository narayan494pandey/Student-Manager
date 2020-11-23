package com.java.JPA.Practices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.JPA.domain.Library;
import com.java.JPA.domain.Student;

public class Main1 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentDetails");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Student s1 = new Student();
		s1.setName("Rahul");
		s1.setAge(29L);

		Student s2 = new Student();
		s2.setName("Rani");
		s2.setAge(26L);

		Student s3 = new Student();
		s3.setName("Raja");
		s3.setAge(22L);
		
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		
	
		
		Library lib1 = new Library();
		lib1.setId(101L);
		lib1.setName("C programming");
		lib1.setStudent(s1);
		
		Library lib2 = new Library();
		lib2.setId(102L);
		lib2.setName("C++ programming");
		lib2.setStudent(s2);
		
		Library lib3 = new Library();
		lib3.setId(103L);
		lib3.setName("Java programming");
		lib3.setStudent(s3);
		
		entityManager.persist(lib1);
		entityManager.persist(lib2);
		entityManager.persist(lib3);
		
		
		

		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
