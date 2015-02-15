package com.supermarket.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupermarketImpl implements Supermarket {

    public static void main(String[] args) {
        new SupermarketImpl();
    }

    private final List<Price> prices;

    /**
     * Main Constructor
     */
    public SupermarketImpl() {
        // Products: A, B, C
        prices = new ArrayList<Price>();
        prices.add(new RegularPrice('A', new Float(20)));
        prices.add(new BundlePrice('B', new Float(50), 5, new Float(150)));
        prices.add(new RegularPrice('C', new Float(30)));
        // Calculation - Test
        //final String items = "ABBACBBAB";
        //System.out.println(checkout(items));
    }

    /**
     * Check out calculation
     */
    public int checkout(final String items) {
        if (items == null || items.trim().isEmpty()) {
            System.err
            .println("There are not items to calculate. Check the input and try again.");
        }
        final Map<Character, Integer> counts = countCharacters(items);
        int cost = 0;
        for (final Price p : prices) {
            cost += p.price(counts);
        }
        return cost;
    }

    /**
     * Return the number of repeated characters of a sequence
     *
     * @param items
     *            - String containing all characters to check
     * @return
     */
    private Map<Character, Integer> countCharacters(final String items) {
        final HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (final char ch : items.toCharArray()) {
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
            }
        }
        return count;
    }

}
