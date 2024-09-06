package com.ecommerce.paymentservice.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorpayPaymentService implements PaymentService {

    private final RazorpayClient razorpay;

    public RazorpayPaymentService(RazorpayClient razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void doPayment(String email, String phoneNumber, Double amount, Long orderId) throws Exception {
        // Add your Razorpay payment logic here

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",50000);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        orderRequest.put("notes",notes);

        Order order = razorpay.orders.create(orderRequest);

    }
}
