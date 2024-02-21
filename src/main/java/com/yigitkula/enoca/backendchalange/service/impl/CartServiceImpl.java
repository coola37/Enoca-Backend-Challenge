package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public Cart getCart(Long id) {
        return null;
    }

    @Override
    public Cart updateCart(Cart cart) {
        return null;
    }

    @Override
    public void emptyCart(Long id) {

    }

    @Override
    public CartItem addProductToCart(Long cartId, Long productId, int quantity) {
        return null;
    }

    @Override
    public void removeProductFromCart(Long cartItemId) {

    }
}
