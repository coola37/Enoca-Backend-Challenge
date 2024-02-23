package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Product;

public interface CartService {
    public Cart createCart(Cart cart);
    public Cart getCart(Long customerId);
    public Cart updateCart(Long customerId, Cart cart);
    public void emptyCart(Long customerId);
    public String addProductToCart(Long customerId, Product product, int quantity);
    public void removeProductFromCart(Long customerId, Long cartItemId);
    public CartItem cartItemChangeQuantity(Long customerId,int cartListIndex, int changeQuantity);
}
