package com.erez.thymeleaf.crmthymeleaf.controller;

import com.erez.thymeleaf.crmthymeleaf.entity.PaypalPayment;
import com.erez.thymeleaf.crmthymeleaf.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paypal")
public class PaypalController {

    private PaypalService paypalService;

    public static final String SUCCESS_url ="paypalPay/success";
    public static final String CANCEL_url ="paypalPay/cancel";
    public static final String BASE_url ="http://localhost:8080/";

    @Autowired
    public PaypalController(PaypalService thePaypalService){
        paypalService= thePaypalService;

    }




    @PostMapping("/pay")
    String payWithPayPal(@ModelAttribute ("orderPay") PaypalPayment orderPay)  {

        try {
               Payment payment =
                       paypalService.createPayment(orderPay.getPrice(),
                                        orderPay.getCurrency(),
                                        orderPay.getMethod(),
                                        orderPay.getIntent(),
                                        orderPay.getDescription(),
                                    BASE_url+CANCEL_url,
                                   BASE_url+SUCCESS_url);
               for(Links link: payment.getLinks()){

                   if(link.getRel().equals("approval_url")){
                       return "redirect:" + link.getHref();
                   }
               }

           } catch (PayPalRESTException e) {
                e.printStackTrace();
        }

        return "paypal-form";
    }



}
