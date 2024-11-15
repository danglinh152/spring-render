//package com.phom.thuchanhtonghop;
//
//
//import static spark.Spark.post;
//import static spark.Spark.port;
//import static spark.Spark.staticFiles;
//
//import java.nio.file.Paths;
//
//import vn.payos.PayOS;
//import vn.payos.type.CheckoutResponseData;
//import vn.payos.type.ItemData;
//import vn.payos.type.PaymentData;
//
//public class Server {
//    public static void main(String[] args) {
//
//
//        port(3030);
//        String clientId = "816198b8-add5-45c5-9534-d87cda43b99a";
//        String apiKey = "ee08cde4-03b8-48ce-bc13-7a7e425a893f";
//        String checksumKey = "3335fcb5d71b559594881129bedfadd05091c07fe80f792d5f72653bd8f44916";
//
//        final PayOS payOS = new PayOS(clientId, apiKey, checksumKey);
//
//        staticFiles.externalLocation(
//                Paths.get("public").toAbsolutePath().toString());
//
//        post("/create-payment-link", (request, response) -> {
//            String domain = "http://localhost:3000";
//            Long orderCode = System.currentTimeMillis() / 1000;
//            ItemData itemData = ItemData
//                    .builder()
//                    .name("Mỳ tôm Hảo Hảo ly")
//                    .quantity(1)
//                    .price(2000)
//                    .build();
//
//            PaymentData paymentData = PaymentData
//                    .builder()
//                    .orderCode(orderCode)
//                    .amount(2000)
//                    .description("Thanh toán đơn hàng")
//                    .returnUrl(domain + "/success.html")
//                    .cancelUrl(domain + "/cancel.html")
//                    .item(itemData)
//                    .build();
//
//            CheckoutResponseData result = payOS.createPaymentLink(paymentData);
//            response.redirect(result.getCheckoutUrl(), 303);
//            return "";
//        });
//    }
//}
