package com.shopping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.cart.model.ShoppingCart;
import org.springframework.stereotype.Repository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>
{
}
