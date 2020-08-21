package com.jjpa.hibernate.Driver;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jjpa.hibernate.dto.Address;
import com.jjpa.hibernate.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args){
		UserDetails user = new UserDetails();
//		user.setUserId(1);
		user.setUsername("rishi1");
		Address addr = new Address();
		addr.setCity("ridgewood");
		addr.setPincode("07451");
		addr.setState("NJ");
		addr.setStreet("main");
		
		Address addr1 = new Address();
		addr1.setCity("Chicago");
		addr1.setPincode("07677");
		addr1.setState("OH");
		addr1.setStreet("main");
		
		user.setHomeAddress(addr);
		user.setJoinedDate(new Date());
		user.setTime(new Date());
		user.setDescription("Ooo. Harry Winks dinks a little pass"
				+ " into the path of Dele Alli and it bounces awkwardly in the area - the Spurs"
				+ " man jabs a toe at it, and then tumbles, but Seagulls stopper Mat Ryan quickly"
				+ " scoops up to get rid of the danger.");
		
		UserDetails user1 = new UserDetails();
//		user1.setUserId(2);
		user1.setUsername("muffi1");
		user1.setJoinedDate(new Date());
		user1.setTime(new Date());
		user1.setJoinedDate(new Date());
		user1.setTime(new Date());
		user.setHomeAddress(addr);
		user1.setDescription("Ooo. Harry Winks dinks a little pass"
				+ " into the path of Dele Alli and it bounces awkwardly in the area - the Spurs"
				+ " man jabs a toe at it, and then tumbles, but Seagulls stopper Mat Ryan quickly"
				+ " scoops up to get rid of the danger.");
		
		
		UserDetails user2 = new UserDetails();
//		user2.setUserId(3);
		user2.setUsername("sagar1");
		user2.setJoinedDate(new Date());
		user2.setTime(new Date());
		user2.setJoinedDate(new Date());
		user2.setTime(new Date());
		user.setHomeAddress(addr);
		user2.setDescription("Ooo. Harry Winks dinks a little pass"
				+ " into the path of Dele Alli and it bounces awkwardly in the area - the Spurs"
				+ " man jabs a toe at it, and then tumbles, but Seagulls stopper Mat Ryan quickly"
				+ " scoops up to get rid of the danger.");
		
		Set<Address> listOfAddresses = new HashSet<Address>();
		listOfAddresses.add(addr);
		listOfAddresses.add(addr1);
		
		user.setListOfAddresses(listOfAddresses);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction(); //single unit of work
		session.save(user);			//create object in DB
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		UserDetails userRet = (UserDetails) session.get(UserDetails.class, 2);
//		System.out.println("User Deatils "+ userRet.getUsername());
//		session.close();
//		
		
		
	}

}
