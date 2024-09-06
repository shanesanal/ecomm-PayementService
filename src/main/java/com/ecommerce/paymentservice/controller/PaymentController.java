package com.ecommerce.paymentservice.controller;

import com.ecommerce.paymentservice.dtos.InitiatePaymentRequestDto;
import com.ecommerce.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    PaymentService paymentService;

    public PaymentController(@Qualifier("razorpay") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/inititate")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws Exception {
         paymentService.doPayment(
                initiatePaymentRequestDto.getEmail(),
                initiatePaymentRequestDto.getPhoneNumber(),
                initiatePaymentRequestDto.getAmount(),
                initiatePaymentRequestDto.getOrderId());

        return "Payment initiated successfully";
    }


}
