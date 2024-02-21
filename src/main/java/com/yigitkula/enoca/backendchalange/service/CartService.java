package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;

public interface CartService {
    public Cart getCart(Long id);
    public Cart updateCart(Cart cart);
    public void emptyCart(Long id);
    public CartItem addProductToCart(Long cartId, Long productId, int quantity);
    public void removeProductFromCart(Long cartItemId);
}
