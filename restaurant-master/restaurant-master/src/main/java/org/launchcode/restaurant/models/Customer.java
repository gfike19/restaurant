package org.launchcode.restaurant.models;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	
	
	//all posts by a given user
	private List<OrderHistory> orderHistories;
	private List<CartItem> cartItems;
	
	//
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String email, String phoneNumber) {
		
		super();
		
		if (!isValidPhoneNumber(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (!isValidEmail(email)) {
			throw new IllegalArgumentException("Invalid email");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	
	@NotNull
    @Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}
	
	@SuppressWarnings("unused")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@NotNull
    @Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	
	@SuppressWarnings("unused")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@NotNull
    @Column(name = "phoneNumber", unique = true)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@SuppressWarnings("unused")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
    @Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	@SuppressWarnings("unused")
	public void setEmail(String email) {
		this.email = email;
	}
	
			
	public static boolean isValidPhoneNumber (String phoneNumber) {
		Pattern validPhoneNumberPattern = Pattern.compile("[0-9]{10,10}");
		Matcher matcher = validPhoneNumberPattern.matcher(phoneNumber);
		return matcher.matches();
	}
	
	public static boolean isValidEmail (String email) {
		Pattern validEmailPattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
		Matcher matcher = validEmailPattern.matcher(email);
		return matcher.matches();
	}
	
	
	@OneToMany
    @JoinColumn(name = "order_history_uid")
    public List<OrderHistory> getOrderHistories() {
        return orderHistories;
    }
	
	public void setOrderHistories(List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}
	public void addOrderHistory(OrderHistory orderHistory) {
		orderHistories.add(orderHistory);
	}
	@OneToMany
    @JoinColumn(name = "cart_item_uid")
    public List<CartItem> getCartItems() {
        return cartItems;
    }
	
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}
}

