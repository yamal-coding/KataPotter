package com.yamal.katapotter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yamal on 27/02/2018
 */


public class KataPotter {

    public enum Book {
        FIRST, SECOND, THIRD, FOUR, FIVE
    }

    public static double calculatePrice(List<Book> books) {
        double price = 0;

        List<DiscountPack> discountPackCounter = new ArrayList<>();

        for (Book book : books) {
            int pos = discountPackPosition(book, discountPackCounter);
            if (pos < discountPackCounter.size()) {
                discountPackCounter.get(pos).add(book);
            }
            else {
                DiscountPack discountPack = new DiscountPack();
                discountPack.add(book);
                discountPackCounter.add(discountPack);
            }
        }

        for (DiscountPack pack : discountPackCounter) {
            price += pack.getPrice();
        }

        return price;
    }

    private static int discountPackPosition(Book book, @NonNull List<DiscountPack> discountPackCounter) {
        int i = 0;
        boolean found = false;
        while (i < discountPackCounter.size() && !found) {
            if (!discountPackCounter.get(i).contains(book) && discountPackCounter.size() < 5)
                found = true;
            else
                i++;
        }

        return i;
    }

    private static class DiscountPack extends HashSet<Book> {
        private double price;
        private int count;

        DiscountPack() {
            super();
            price = 0;
            count = 0;
        }

        @Override
        public boolean add(Book book) {
            if (!contains(book)) {

                switch (++count) {
                    case 2:
                        price = 15.2;
                        break;
                    case 3:
                        price = 21.6;
                        break;
                    case 4:
                        price = 25.6;
                        break;
                    case 5:
                        price = 30.0;
                        break;
                    case 1:
                        price = 8.0;
                        break;
                }
            }
            return super.add(book);
        }

        double getPrice() {
            return price;
        }
    }
}
