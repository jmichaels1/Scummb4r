package com.everis.bcn.test;

import com.everis.bcn.daoImp.MesaDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

public class TestNew {

	public static void main(String[] args) {
		
		MesaDAOImp dao_mesa = new MesaDAOImp();
		
		Restaurant r = new Restaurant();
		r.setId(1);
		
		Mesa m = new Mesa();
		m.setRestaurant(r);
		
		dao_mesa.save(m);
		
	}

}
