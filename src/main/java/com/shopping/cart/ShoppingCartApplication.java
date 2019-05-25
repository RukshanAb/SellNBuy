package com.shopping.cart;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.shopping.cart.controller.ShoppingCartController;
import com.shopping.cart.dao.ShoppingCartDAO;
import com.shopping.cart.model.ShoppingCart ;
@SpringBootApplication
@EnableJpaAuditing

public class ShoppingCartApplication {
public static void main(String args[]) {
SpringApplication.run(ShoppingCartApplication.class, args);
}
}