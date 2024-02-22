package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Product;

public interface CartService {
    public Cart createCart(Cart cart);
    public Cart getCart(Long id);
    public Cart updateCart(Long cartId, Cart cart);
    public void emptyCart(Long id);
    public String addProductToCart(Long cartId, Product product, int quantity);
    public void removeProductFromCart(Long cartId, Long cartItemId);
    public CartItem cartItemChangeQuantity(Long cartId,int cartListIndex, int changeQuantity);
}
