package com.shopping.cart.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.shopping.cart.model.ShoppingCart;
import com.shopping.cart.repository.ShoppingCartRepository;
@Service
public class ShoppingCartDAO {
@Autowired
ShoppingCartRepository shoppingcartRepository;

/* SAVE AN EMPLOYEE */
@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
public ShoppingCart  save(ShoppingCart  itm) {
return shoppingcartRepository.save(itm);
}

/* SEARCH ALL items */
public List<ShoppingCart > findAll(){
return shoppingcartRepository.findAll();
}

/* GET AN items */
public ShoppingCart  findOne(Long itmId) {
Optional<ShoppingCart > op = shoppingcartRepository.findById(itmId);
if(op.isPresent()) {
return op.get();
}
else {
return null;
}
}

/* DELETE AN items by id */
@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
public void delete(ShoppingCart  itm) {
	shoppingcartRepository.delete(itm);
}
}