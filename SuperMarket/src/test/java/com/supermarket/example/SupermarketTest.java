package com.supermarket.example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SupermarketTest {

    private SupermarketImpl superMarket;

    @Before
    public void setUp() {
        superMarket = new SupermarketImpl();
    }

    @Test
    public void testPrimary() {
        final String items = "ABBACBBAB";

        assertEquals(240, superMarket.checkout(items));
    }

    @Test
    public void testNoInput() {
        final String items = "";

        assertEquals(0, superMarket.checkout(items));
    }

    @Test
    public void testNoBundles1() {
        final String items = "AAAA";

        assertEquals(80, superMarket.checkout(items));
    }

    @Test
    public void testNoBundles2() {
        final String items = "CCCCC";

        assertEquals(150, superMarket.checkout(items));
    }

    @Test
    public void testNoBundles3() {
        final String items = "ACCACCCA";

        assertEquals(210, superMarket.checkout(items));
    }

    @Test
    public void testBundle1() {
        final String items = "BBBBBBBBBB";

        assertEquals(300, superMarket.checkout(items));
    }

    @Test
    public void testBundle2() {
        final String items = "BBB BBBB BBB";
        assertEquals(300, superMarket.checkout(items));
    }

    @Test
    public void testBundle3() {
        final String items = "BBBBB BB";
        assertEquals(250, superMarket.checkout(items));
    }


}
