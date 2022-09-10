package com.code.nityam.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @GetMapping("/customerServiceFallBackMethod")
    public String customerServiceFallBackMethod(){
        return "customer service is taking longer than expected. Try again later.";
    }
    @GetMapping("/sellerServiceFallBackMethod")
    public String sellerServiceFallBackMethod(){
        return "Seller service is taking longer than expected. Try again later.";
    }
    @GetMapping("/bidServiceFallBackMethod")
    public String bidServiceFallBackMethod(){
        return "Bid service is taking longer than expected. Try again later.";
    }
    @GetMapping("/productServiceFallBackMethod")
    public String productServiceFallBackMethod(){
        return "Product service is taking longer than expected. Try again later.";
    }
}
