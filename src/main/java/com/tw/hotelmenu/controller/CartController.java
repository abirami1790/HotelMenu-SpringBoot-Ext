package com.tw.hotelmenu.controller;
import com.tw.hotelmenu.model.Cart;
import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    //Show available cart
    @GetMapping("/all")
    public List<Cart> getAllCart(){
        return cartService.getAllCart();
    }

    @PostMapping("/add")
    public String addCart(@RequestBody Cart cart){
        cartService.addCart(cart);
        return "Added menu Successfully";
    }

    @DeleteMapping (value = "/delete/{id}")
    public String deleteCart(@PathVariable long id){
        cartService.deleteCart(id);
        return "Deleted cart Successfully";
    }

}
