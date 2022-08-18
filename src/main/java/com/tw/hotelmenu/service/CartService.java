package com.tw.hotelmenu.service;

import com.tw.hotelmenu.model.Cart;
import com.tw.hotelmenu.model.Menu;
import com.tw.hotelmenu.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    //Show available cart
    public List<Cart> getAllCart() {
        return (List<Cart>) cartRepository.findAll();
    }

    public String addCart(Cart cart) {
        Cart existingCart = cartRepository.findByMenuId(cart.getId());
        if (existingCart != null) {

            int qty = existingCart.getQuantity();
            existingCart.setQuantity(qty + 1);
            cartRepository.save(existingCart);
        } else {
            cart.setMenuId(cart.getId());
            cartRepository.save(cart);
        }
        cartRepository.flush();
        return "Cart Created Successfully";
    }



    public String deleteCart(long id) {
       Cart existingCart = cartRepository.findByMenuId(id);
        if (existingCart != null && existingCart.getQuantity() >1) {

            int qty = existingCart.getQuantity();
            existingCart.setQuantity(qty - 1);
            cartRepository.save(existingCart);
        } else if(existingCart != null && existingCart.getQuantity() == 1){
            cartRepository.delete(existingCart);
        }
        cartRepository.flush();
        return "Deleted menu Successfully";
    }
}
