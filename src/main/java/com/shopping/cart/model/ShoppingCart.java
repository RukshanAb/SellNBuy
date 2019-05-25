package com.shopping.cart.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="ShoppingCart")
@EntityListeners(AuditingEntityListener.class)
public class ShoppingCart implements Serializable{
private static final long serialVersionUID = 1143993377101043360L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String itemname;
private String qty;
private String price;




public String getItemname() {
	return itemname;
}

public void setItemname(String itemname) {
	this.itemname = itemname;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getQty() {
	return qty;
}

public void setQty(String qty) {
	this.qty = qty;
}



}