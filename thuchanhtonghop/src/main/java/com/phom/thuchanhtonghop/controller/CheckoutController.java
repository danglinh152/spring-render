package com.phom.thuchanhtonghop.controller;

import com.phom.thuchanhtonghop.entity.ProductData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.payos.PayOS;
import vn.payos.type.CheckoutResponseData;
import vn.payos.type.ItemData;
import vn.payos.type.PaymentData;

import java.util.Date;

@Controller
public class CheckoutController {
    private final PayOS payOS;

    public CheckoutController(PayOS payOS) {
        super();
        this.payOS = payOS;
    }

    @RequestMapping(value = "/")
    public String Index() {
        return "index";
    }

    @RequestMapping(value = "/success")
    public String Success() {
        return "success";
    }

    @RequestMapping(value = "/cancel")
    public String Cancel() {
        return "cancel";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-payment-link")
//    @RequestMapping(method = RequestMethod.POST, value = "/create-payment-link", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> checkout(@RequestBody ProductData product) {
        try {
//            final String productName = "Mì tôm hảo hảo ly"; //product name
//            final String description = "Thanh toan don hang"; //product desc
//            final String returnUrl = "http://localhost:3030/success";
//            final String cancelUrl = "http://localhost:3030//cancel";
//            final int price = 2000;
            // Gen order code
            String currentTimeString = String.valueOf(new Date().getTime());
            long orderCode = Long.parseLong(currentTimeString.substring(currentTimeString.length() - 6));
            ItemData item = ItemData.builder().name("product.getProductName()").quantity(1).price(product.getPrice()).build();
            PaymentData paymentData = PaymentData.builder().orderCode(orderCode).amount(product.getPrice()).description(product.getDescription())
                    .returnUrl(product.getReturnUrl()).cancelUrl(product.getCancelUrl()).item(item).build();
            CheckoutResponseData data = payOS.createPaymentLink(paymentData);

            String checkoutUrl = data.getCheckoutUrl();

            return ResponseEntity.ok(checkoutUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    private String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();

        String url = scheme + "://" + serverName;
        if ((scheme.equals("http") && serverPort != 80) || (scheme.equals("https") && serverPort != 443)) {
            url += ":" + serverPort;
        }
        url += contextPath;
        return url;
    }
}