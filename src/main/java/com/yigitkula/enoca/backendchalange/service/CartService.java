package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Cart;

public interface CartService {
    public Cart getCart(Long id);
    public Cart updateCart(Cart cart);
    public void emptyCart(Long id);
}
