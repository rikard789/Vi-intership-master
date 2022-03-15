package com.virtuslab.internship.discount;


import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;

import java.math.BigDecimal;

public class FifteenPercentDiscount {
    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {

        int tempCount = 0;
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");

        for(int i = 0; i < receipt.entries().size(); i++){

            if(receipt.entries().get(i).product().type() == bread.type()){
                tempCount = tempCount + receipt.entries().get(i).quantity();
            }
            System.out.println(receipt.entries().get(i));
        }

        if (tempCount >= 3) {
            return true;
        }
        else{
            return false;
        }
    }
}
