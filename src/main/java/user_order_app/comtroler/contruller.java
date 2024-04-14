package user_order_app.comtroler;

import java.util.List;
import java.util.Scanner;

import user_order_app.dao.userDao;
import user_order_app.dto.User;
import user_order_app.dto.foodOrder;

public class contruller {
public static void main(String[] args) {
     userDao dao=new userDao();
     boolean flag=true;
     Scanner sc=new Scanner(System.in);
     while(flag) {
    	 System.out.println("1.save user\n2.update user\n3.save foodOrder\n4.update order\n5.verify user by email and password\n6.verify user by phone and password\n7.find food by user id\n8.find foodlist by email and password\n9.verify user by id and password\n10.delete foodOrder\n11.exit");
    	 switch(sc.nextInt()) {
    	 case 1:{
    		 User user=new User();
    		 System.out.println("please enter name,gender,email,phone,password");
    		 user.setName(sc.next());
    		 user.setGender(sc.next());
    		 user.setEmail(sc.next());
    		 user.setPhone(sc.nextLong());
    		 user.setPassword(sc.next());
    		 user=dao.saveUser(user);
    		 System.out.println("user saved with id "+user.getId());
    		break; 
    	 }
    	 case 2:{
    		 User user=new User();
    		 System.out.println("please enter id, name,gender,email,phone,password");
    		 user.setId(sc.nextInt());
    		 user.setName(sc.next());
    		 user.setGender(sc.next());
    		 user.setEmail(sc.next());
    		 user.setPhone(sc.nextLong());
    		 user.setPassword(sc.next());
    		 user=dao.updateUser(user);
    		if(user!=null) {
    			 System.out.println("user updated with id "+user.getId());
    		}else {
				System.out.println("unable to update");
			}
     		break; 
     	 }
    	 case 3:{
    		 foodOrder order=new foodOrder();
    		 System.out.println("enter the user id");
    		 int user_id=sc.nextInt();
    		 System.out.println("enter the price,address,item_name,");
    		 order.setPrice(sc.nextDouble());;
    		 order.setAddress(sc.next());
    		 order.setItem_name(sc.next());
    		 order=dao.addFoodOrder(order, user_id);
    		 if(order!=null) {
    			 System.out.println("food order added with id "+order.getId());
    		 }else {
				System.err.println("unable to add because user id is invalid");
			}
     		break; 
     	 }
    	 case 4:{
    		 foodOrder order=new foodOrder();
    		 System.out.println("enter the id, price,address,item_name,");
    		 order.setId(sc.nextInt());
    		 order.setPrice(sc.nextDouble());;
    		 order.setAddress(sc.next());
    		 order.setItem_name(sc.next());
    		 order=dao.updateFoodOrder(order);
    		 if(order!=null) {
    			 System.out.println("Food Order is updated");
    		 }else {
				System.err.println("unable to update");
			}   		 
     		break; 
     	 }
    	 case 5:{
    		 System.out.println("enter the email and password of user");
    		 String email=sc.next();
    		 String password=sc.next();
    		 User user=dao.verifyUser(email, password);
    		 if(user!=null) {
    			 System.out.println(user);
    		 }else {
				System.out.println("not find any user");
			}
    		 
     		break; 
     	 }
    	 case 6:{
    		 System.out.println("enter the phone and password of user");
    		 long phone=sc.nextLong();
    		 String password=sc.next();
    		 User user=dao.verifyUser(phone, password);
    		 if(user!=null) {
    			 System.out.println(user);
    		 }else {
				System.out.println("not find any user");
			}
     		break; 
     	 }
    	 case 7:{
    		 System.out.println("Enter the user id for from order list");
    		 int uId=sc.nextInt();
    		 List<foodOrder> order=dao.findOrder(uId);
    		 if(order.size()>0) {
    			 for(foodOrder O:order) {
    				 System.out.println(O);
    			 }
    		 }else {
				System.err.println("foodOrder is empty");
			}
     		break; 
     	 }
    	 case 8:{
    		 System.out.println("Enter the user email and password for from order list");
    		 String email=sc.next();
    		 String password=sc.next();
    		 List<foodOrder> order=dao.findOrder(email, password);
    		 if(order.size()>0) {
    			 for(foodOrder O:order) {
    				 System.out.println(O);
    			 }
    		 }else {
				System.err.println("foodOrder is empty");
			}
     		break; 
     	 }
    	 case 9:{
    		 System.out.println("enter the id and password of user");
    		 int id=sc.nextInt();
    		 String password=sc.next();
    		 User user=dao.verifyUser(id, password);
    		 if(user!=null) {
    			 System.out.println(user);
    		 }else {
				System.out.println("not find any user");
			}
     		break; 
     	 }
    	 case 10:{
    		 System.out.println("enter the order id to delete");
    		 int id=sc.nextInt();
    		 if(dao.deleteFoodOrder(id)) {
    			 System.out.println("food order deleted successfully");
    		 }else {
				System.out.println("unable to delete");
			}
     		break; 
     	 }
    	 case 11:{
    		 flag=false;
    		 System.exit(0);
     		break; 
     	 }
    	 default: {
    		 System.out.println("please chose a valid potion");
    	 }
    	 }
     }
}
}
