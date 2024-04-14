package user_order_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import user_order_app.dto.User;
import user_order_app.dto.foodOrder;

public class userDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("devlopment");
	EntityManager manager=factory.createEntityManager();
	
	public User saveUser(User user) {
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(user);
		transaction.begin();
        transaction.commit();
        return user;
	}
	public User updateUser(User user) {
		User dbUser=manager.find(User.class, user.getId());
		EntityTransaction transaction=manager.getTransaction();
		if(dbUser!=null) {
			dbUser.setEmail(user.getEmail());
			dbUser.setGender(user.getGender());
			dbUser.setName(user.getName());
			dbUser.setPhone(user.getPhone());
			dbUser.setPassword(user.getPassword());
			transaction.begin();
	        transaction.commit();
	        return dbUser;
		}
        return null;
	}
	public User verifyUser(String email,String password) {
		Query q=manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1,email);
		q.setParameter(2,password);
		try {
			return (User) q.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	public User verifyUser(int id,String password) {
		Query q=manager.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1,id);
		q.setParameter(2,password);
		try {
			return (User) q.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	public User verifyUser(long phone,String password) {
		Query q=manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1,phone);
		q.setParameter(2,password);
		try {
			return (User) q.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	public foodOrder addFoodOrder(foodOrder order,int user_id) {
		User user=manager.find(User.class,user_id);
		EntityTransaction transaction=manager.getTransaction();
		if(user!=null) {
			order.setUser(user);
			user.getOrders().add(order);
			manager.persist(order);
			transaction.begin();
			transaction.commit();
            return order;
		}
		return null;
	}
	public foodOrder updateFoodOrder(foodOrder order) {
		foodOrder dbOrder=manager.find(foodOrder.class, order.getId());
		EntityTransaction transaction=manager.getTransaction();
		if(dbOrder!=null) {
			dbOrder.setAddress(order.getAddress());
			dbOrder.setItem_name(order.getItem_name());
			dbOrder.setPrice(order.getPrice());
			transaction.begin();
			transaction.commit();
            return order;
		}
		return null;
	}
	public List<foodOrder> findOrder(int user_id){
		Query q=manager.createQuery("select u.orders from User u where u.id=?1");
		q.setParameter(1,user_id);
		List<foodOrder> orders=q.getResultList();
		if(orders.size()>0) {
			return orders;
		}
		return null;
	}
	public List<foodOrder> findOrder(String email ,String password){
		Query q=manager.createQuery("select u.orders from User u where u.email=?1 and u.password=?2");
		q.setParameter(1,email);
		q.setParameter(2,password);
		List<foodOrder> orders=q.getResultList();
		if(orders.size()>0) {
			return orders;
		}
		return null;
	}
	public boolean deleteFoodOrder(int id) {
		EntityTransaction transaction=manager.getTransaction();
		foodOrder order=manager.find(foodOrder.class, id);
		if(order!=null) {
			manager.remove(order);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

	
	

}
