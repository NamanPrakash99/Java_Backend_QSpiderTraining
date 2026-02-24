package com.cachePraticse;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "productcache")
@Cacheable                                             // to mark object as Cacheabe type
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)      // which object u want to make as cache
public class Product {
	
	@Id
	int id;
	String  name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
