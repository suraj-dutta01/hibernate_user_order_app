package user_order_app.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class foodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@UpdateTimestamp
	private LocalDateTime del_time;
	@CreationTimestamp
	private LocalDateTime order_time;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String item_name;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDel_time() {
		return del_time;
	}
	public void setDel_time(LocalDateTime del_time) {
		this.del_time = del_time;
	}
	public LocalDateTime getOrder_time() {
		return order_time;
	}
	public void setOrder_time(LocalDateTime order_time) {
		this.order_time = order_time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	@Override
	public String toString() {
		return "foodOrder [id=" + id + ", del_time=" + del_time + ", order_time=" + order_time + ", price=" + price
				+ ", address=" + address + ", item_name=" + item_name + "]";
	}
	
	

}
