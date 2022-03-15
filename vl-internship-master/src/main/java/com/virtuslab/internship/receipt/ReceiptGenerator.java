package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        return getReceipt(basket);
    }

    private Receipt getReceipt(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        HashMap<String, Integer> productMap = new HashMap<>();

        for( Product prod : basket.getProducts()) {
            Integer value = productMap.get(prod.name());
            if (value == null) {
                productMap.put(prod.name(), 1);
            } else {
                productMap.put(prod.name(), productMap.get(prod.name())+1);
            }
        }

        for( Product prod : basket.getProducts())
        {
            if(!receiptEntries.contains(new ReceiptEntry(prod, productMap.get(prod.name())))){
                receiptEntries.add(new ReceiptEntry(prod, productMap.get(prod.name())));
            }
        }

        return new Receipt(receiptEntries);
    }
}
