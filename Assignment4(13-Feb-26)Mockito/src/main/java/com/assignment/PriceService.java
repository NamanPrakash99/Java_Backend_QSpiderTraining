package com.assignment;

public class PriceService {

    private DiscountRepo dao;

    public PriceService(DiscountRepo dao) {
        this.dao = dao;
    }

    public double calculateFinalPrice(double price, String productCode) {

        double discount = dao.getDiscountPercentage(productCode);

        double finalPrice = price - (price * discount / 100);

        return finalPrice;
    }
}

