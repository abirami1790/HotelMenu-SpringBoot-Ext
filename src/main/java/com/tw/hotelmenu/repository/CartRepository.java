package com.tw.hotelmenu.repository;
import com.tw.hotelmenu.model.Cart;
import com.tw.hotelmenu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByMenuId(Long menuId);

}
