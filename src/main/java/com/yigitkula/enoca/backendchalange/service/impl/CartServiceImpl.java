package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Customer;
import com.yigitkula.enoca.backendchalange.entity.Product;
import com.yigitkula.enoca.backendchalange.repository.CartItemRepository;
import com.yigitkula.enoca.backendchalange.repository.CartRepository;
import com.yigitkula.enoca.backendchalange.repository.CustomerRepository;
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
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return customer.getCart();
    }

    @Override
    public Cart updateCart(Long customerId, Cart cart) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Cart oldCart = customer.getCart();
        oldCart.setCartItems(cart.getCartItems());
        return cartRepository.save(oldCart);
    }

    @Override
    public void emptyCart(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Cart cart = customer.getCart();
        cart.setCartItems(null);
        cartRepository.save(cart);
    }

    @Override
    public String addProductToCart(Long customerId, Product product, int quantity) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Cart cart = customer.getCart();

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
    public CartItem cartItemChangeQuantity(Long customerId, int cartListIndex, int changeQuantity) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Cart cart = customer.getCart();
        List<CartItem> items = cart.getCartItems();
        CartItem item = items.get(cartListIndex);
        item.setQuantity(item.getQuantity() + changeQuantity);
        items.set(cartListIndex, item);
        cart.setCartItems(items);
        cartRepository.save(cart);
        return item;
    }

    @Override
    public void removeProductFromCart(Long customerId, Long cartItemId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Cart cart = customer.getCart();
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