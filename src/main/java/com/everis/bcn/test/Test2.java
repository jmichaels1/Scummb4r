package com.everis.bcn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.everis.bcn.entity.Turn;

public class Test2 {
	
	private Connection conn;
	
	  public void BasicJDBCDemo()
	  {
	    try
	    {
	    
	    	System.out.println("start() !!");
	    	
	    	
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String url = "jdbc:mysql://localhost:3307/scummb4rdb?useUnicode=true&serverTimezone=UTC";
	      
	      System.out.println("antes de lanzar la url !!");
	      
	      conn = DriverManager.getConnection(url, "jmicahel", "jm123");
	      
	      
	      System.out.println(conn != null? "conectado !!" : "no se conecta, coño !!");
	      
//	      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistence");
//			EntityManager entityManager = emFactory.createEntityManager();
//			
//			entityManager.getTransaction().begin();
////			
//			Turn t = new Turn(1, "mañana");
//			entityManager.persist(t);
//			
//			entityManager.getTransaction().commit();
//			entityManager.close();
//			
//			System.out.println("Tudoo Bemmm !!!");
			
			
//			emFactory.close();
	      
	      conn.close();
	    }
	    catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
	    catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
	    catch (InstantiationException ex) {System.err.println(ex.getMessage());}
	    catch (SQLException ex)           {System.err.println(ex.getMessage());}
	  }
	  
	  public static void main(String[] args) {
		
		  new Test2().BasicJDBCDemo();
		  
	}

}
