package com.supermarket.example;

import java.util.Map;

public class BundlePrice implements Price {

    private final char productId;
    private final Float productCost;
    private final int bundleQuantity;
    private final Float bundleCost;

    public BundlePrice(final char productId, final Float productCost,
            final int bundleQuantity, final Float bundleCost) {
        this.productId = productId;
        this.productCost = productCost;
        this.bundleQuantity = bundleQuantity;
        this.bundleCost = bundleCost;
    }

    /**
     * @return the bundleCost
     */
    public Float getBundleCost() {
        return bundleCost;
    }

    /**
     * @return the bundleQuantity
     */
    public int getBundleQuantity() {
        return bundleQuantity;
    }

    /**
     * @return the productCost
     */
    public Float getProductCost() {
        return productCost;
    }

    /**
     * @return the productId
     */
    public char getProductId() {
        return productId;
    }

    /**
     * Price Calculation
     */
    public float price(Map<Character, Integer> productPrice) {
        if (!productPrice.containsKey(productId)) {
            return 0;
        }
        final Integer productCount = productPrice.get(productId);
        if (productCount == null || productCount.equals(0)) {
            return 0;
        }
        final int bundles = productCount / bundleQuantity;
        final int remanent = productCount % bundleQuantity;

        return (bundles * bundleCost) + (remanent * productCost);

    }

}
