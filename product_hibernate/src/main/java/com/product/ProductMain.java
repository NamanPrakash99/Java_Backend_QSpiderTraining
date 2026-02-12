package com.product;

public class ProductMain {
	public static void main(String[] args) {
		ProductDao dao=new ProductDao();
		
		Product p=new Product();
		p.setId(3);
		p.setName("Red-Magic");
		p.setPrice(150000);
		p.setQuantity(11);
		
		dao.insertProduct(p);
//		
//		 p.setPrice(55000);
//	     p.setQuantity(10);
//	     dao.update(p);
//	     
//	      dao.deleteById(1);

		
	}
}
