package com.everis.bcn.test;

import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

public class Test {
	

	public static void main(String[] args) {

		HibernateManagerDB hm = new HibernateManagerDB("persistence");
		
		hm.beginTransaction();
		
		Turn t = new Turn();
		t.setDescription("nit");
		
		hm.persistObj(t);
		hm.commitTransaction();
		hm.closeTransaction();

	}

}
