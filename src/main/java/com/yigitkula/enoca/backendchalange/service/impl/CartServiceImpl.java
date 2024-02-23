package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Product;
import com.yigitkula.enoca.backendchalange.repository.CartItemRepository;
import com.yigitkula.enoca.backendchalange.repository.CartRepository;
import com.yigitkula.enoca.backendchalange.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    @Override
    public Cart updateCart(Long cartId, Cart cart) {
        Cart oldCart = cartRepository.findById(cartId).orElseThrow();
        oldCart.setCartItems(cart.getCartItems());
        return cartRepository.save(oldCart);
    }

    @Override
    public void emptyCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.setCartItems(null);
        cartRepository.save(cart);
    }

    @Override
    public String addProductToCart(Long cartId, Product product, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();

        CartItem cartItem = new CartItem();
        if(product.getInStock() > 0 && quantity <= product.getInStock()){
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);

            List<CartItem> newCartItems = cart.getCartItems();
            newCartItems.add(cartItem);
            cart.setCartItems(newCartItems);
            cartRepository.save(cart);
            return "Product added to cart";
        }else{
            return "There is not enough product stock";
        }
    }
    @Override
    public CartItem cartItemChangeQuantity(Long cartId,int cartListIndex, int changeQuantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        List<CartItem> items = cart.getCartItems();
        CartItem item = items.get(cartListIndex);
        item.setQuantity(item.getQuantity() + changeQuantity);
        items.set(cartListIndex, item);
        cart.setCartItems(items);
        cartRepository.save(cart);
        return item;
    }

    @Override
    public void removeProductFromCart(Long cartId, Long cartItemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        List<CartItem> itemList = cart.getCartItems();
        CartItem item = cartItemRepository.findById(cartItemId).orElseThrow();
        itemList.remove(item);
        cart.setCartItems(itemList);
        cartRepository.save(cart);
        cartItemRepository.delete(item);
        System.out.println(cart.getCartItems());
        System.err.println(item);
    }
}