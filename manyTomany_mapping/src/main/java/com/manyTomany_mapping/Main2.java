package com.manyTomany_mapping;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;  

public class Main2 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql1 = "delete from student_details_subject where subjects_id=?1";
		String sql2 = "delete from subject where id=?1";
		
		Query query1 = em.createNativeQuery(sql1);
		query1.setParameter(1, 101);
		Query query2 = em.createNativeQuery(sql2);
		query2.setParameter(1, 101);
		
		et.begin();
		query1.executeUpdate();
		query2.executeUpdate();
		et.commit();
		
		
	}
}
