package com.shopping.cart.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.cart.dao.ShoppingCartDAO;
import com.shopping.cart.model.ShoppingCart ;
@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {
@Autowired
ShoppingCartDAO shoppingcartDAO;

/* SAVE AN items */
@PostMapping("/cart")
public ShoppingCart  createShoppingCart(@Valid @RequestBody ShoppingCart  itm) {
return shoppingcartDAO.save(itm);
}

/* GET ALL items*/
@GetMapping("/cart")
public List<ShoppingCart > getAllShoppingCart(){
return shoppingcartDAO.findAll();
}
/* GET items BY ID */
@GetMapping("/cart/{id}")
public ResponseEntity<ShoppingCart > getShoppingCartById(@PathVariable(value="id") Long
itmId){
	ShoppingCart  itm = shoppingcartDAO.findOne(itmId);
if(itm==null) {
return ResponseEntity.notFound().build();
}
return ResponseEntity.ok().body(itm);
}
/* UPDATE AN items BY ID */
@PutMapping("/cart/{id}")
public ResponseEntity<ShoppingCart > updateShoppingCart(@PathVariable(value="id") Long itmId,
@Valid @RequestBody ShoppingCart  itmDetails){
	ShoppingCart  itm=shoppingcartDAO.findOne(itmId);
if(itm==null) {
return ResponseEntity.notFound().build();
}
itm.setItemname(itmDetails.getItemname());
itm.setQty(itmDetails.getQty());
itm.setPrice(itmDetails.getPrice());

ShoppingCart  updaShoppingCart=shoppingcartDAO.save(itm);
return ResponseEntity.ok().body(updaShoppingCart);
}
/*DELETE AN items*/
@DeleteMapping("/cart/{id}")
public ResponseEntity<ShoppingCart > deleteShoppingCart(@PathVariable(value="id") Long itmId){
	ShoppingCart  itm = shoppingcartDAO.findOne(itmId);
if(itm==null) {
return ResponseEntity.notFound().build();
}
shoppingcartDAO.delete(itm);
return ResponseEntity.ok().build();
}
}