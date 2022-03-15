package com.virtuslab.internship.springBoot;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/giveReceipt", method = RequestMethod.POST)
    public Receipt giveReceipt(@RequestBody Basket basket) {


        var receiptGenerator = new ReceiptGenerator();

//        if (basket.getProducts().isEmpty()){
//            System.out.println("\n\nbasketIsEmpty\n");
//        }
//        for( Product prod : basket.getProducts()){
//            System.out.println(prod.price());
//
        return receiptGenerator.generate(basket);
    }


//    @RequestMapping(value = "/giveReceipt", method = RequestMethod.POST) // napisac test
//    public String giveReceipt() {
//        return "hakunaMattata";
//    }
}
