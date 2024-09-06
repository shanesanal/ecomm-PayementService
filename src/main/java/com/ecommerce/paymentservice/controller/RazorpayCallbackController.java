package com.ecommerce.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("razorpay-callback")
public class RazorpayCallbackController {

    @GetMapping("/receive")
    public void receiveRazorpayCallback() {
        // Add your code here
        System.out.println("Razorpay callback received");
    }
}
