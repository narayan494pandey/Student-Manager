package com.java.JPA.Practices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.java.JPA.domain.Student;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("StudentDetails");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		String jpql1 = "select s from Student s where s.age between 22 and 29 ";
		String jpql2 = "update Student SET age=49 where id=4";
		String jpql3 = "select s from Student s where s.age IN(22,25,29)";
		String jpql4 = "select s from Student s where s.name like'R%'";
		String jpql5 = "select count(s) from Student s ";
		String jpql6 = "select MAX(s.age) from Student s ";
		String jpql7 = "select MIN(s.age) from Student s ";
		String jpql8 = "select s from Student s order by s.age desc";
		Query query1 = entityManager.createQuery(jpql4);
		// Query query2 = entityManager.createQuery(jpql2);
		// query2.executeUpdate();
		@SuppressWarnings("unchecked")
		List<Student> list = query1.getResultList();
		System.out.print("ID");
		System.out.print("\tName");
		System.out.println("\tAge");
		for (Student s : list) {
			System.out.print(s.getId());
			System.out.print("\t" + s.getName());
			System.out.print("\t" + s.getAge());
			System.out.println();
		}
		
		Query q4 = entityManager.createQuery(jpql8);
		@SuppressWarnings("unchecked")
		List<Student> list1 = q4.getResultList();
		System.out.print("ID");
		System.out.print("\tName");
		System.out.println("\tAge");
		for(Student s1 :list1) {
			System.out.print(s1.getId());
			System.out.print("\t" + s1.getName());
			System.out.print("\t" + s1.getAge());
			System.out.println();
		}
		
		
		Query q1 = entityManager.createQuery(jpql5);
		System.out.println("Total No Of Student : " +q1.getSingleResult());
		Query q2 = entityManager.createQuery(jpql6);
		System.out.println("Oldest Student : " +q2.getSingleResult());
		Query q3 = entityManager.createQuery(jpql7);
		System.out.println("Youngest Student : " +q3.getSingleResult());
		

		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();

	}
	// find(entityManager);

	/*
	 * FOR DELETE WRITE entityManager.remove(student);
	 */
	/*
	 * private static void find(EntityManager entityManager) { Student student4 =
	 * entityManager.find(Student.class, 3L); student4.setName("Rani");
	 * student4.setAge(25L); Student student = entityManager.find(Student.class,
	 * 4L); student.setName("Shyam"); student.setAge(31L); Student student1 =
	 * entityManager.find(Student.class, 5L); student1.setName("Ram");
	 * student1.setAge(24L); Student student2 = entityManager.find(Student.class,
	 * 6L); student2.setName("Rohan"); student2.setAge(23L);
	 * 
	 * }
	 */
}
