package com.supermarket.example;

import java.util.Map;

public class RegularPrice implements Price {

    private char product;
    private Float cost;

    public RegularPrice(final char product, final Float cost) {
        this.product = product;
        this.cost = cost;
    }

    /**
     * @return the cost
     */
    public Float getCost() {
        return cost;
    }

    /**
     * @return the product
     */
    public char getProduct() {
        return product;
    }

    /**
     * Price Calculation
     */
    public float price(Map<Character, Integer> productPrice) {
        return (!productPrice.containsKey(product) ? new Float(0) : cost
                * productPrice.get(product));
    }

    /**
     * @param cost
     *            the cost to set
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(char product) {
        this.product = product;
    }

}
