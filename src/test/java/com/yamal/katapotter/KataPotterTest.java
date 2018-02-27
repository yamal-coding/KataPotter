package com.yamal.katapotter;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yamal on 27/02/2018
 */

@RunWith(JUnit4.class)
public class KataPotterTest {


    @Test
    public void test_2one_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.FIRST);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(16, price, 0);
    }

    @Test
    public void test_1one_1two_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.SECOND);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(15.2, price, 0);
    }

    @Test
    public void test_1one_1two_1three_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.THIRD);
            add(KataPotter.Book.SECOND);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(21.6, price, 0);
    }

    @Test
    public void test_1one_1two_1three_1four_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.FOUR);
            add(KataPotter.Book.SECOND);
            add(KataPotter.Book.THIRD);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(25.6, price, 0);
    }

    @Test
    public void test_1one_1two_1three_1four_1five_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.FOUR);
            add(KataPotter.Book.FIVE);
            add(KataPotter.Book.SECOND);
            add(KataPotter.Book.THIRD);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(30.0, price, 0);
    }

    @Test
    public void test_1five_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIVE);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(8.0, price, 0);
    }

    @Test
    public void test_3different_1five_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.FOUR);
            add(KataPotter.Book.FIVE);
            add(KataPotter.Book.FIVE);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(21.6 + 8.0, price, 0);
    }

    @Test
    public void test_2one_2two_2three_1four_1five_copies() {
        List<KataPotter.Book> books = new ArrayList<KataPotter.Book>(){{
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.SECOND);
            add(KataPotter.Book.THIRD);
            add(KataPotter.Book.FIRST);
            add(KataPotter.Book.THIRD);
            add(KataPotter.Book.FIVE);
            add(KataPotter.Book.FOUR);
            add(KataPotter.Book.SECOND);
        }};

        double price = KataPotter.calculatePrice(books);

        Assert.assertEquals(51.6, price, 0);
    }
}

