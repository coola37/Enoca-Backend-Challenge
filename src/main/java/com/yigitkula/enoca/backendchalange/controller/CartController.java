package com.yigitkula.enoca.backendchalange.controller;

import com.yigitkula.enoca.backendchalange.entity.Cart;
import com.yigitkula.enoca.backendchalange.entity.CartItem;
import com.yigitkula.enoca.backendchalange.entity.Product;
import com.yigitkula.enoca.backendchalange.response.ResultResponse;
import com.yigitkula.enoca.backendchalange.service.CartService;
import com.yigitkula.enoca.backendchalange.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;

    @GetMapping("/get/{customerId}")
    ResultResponse<Cart> getCart(@PathVariable Long customerId){
        Cart cart = cartService.getCart(customerId);
        Double totalPrice = 0.0;
        List<CartItem> list = cart.getCartItems();
        for(CartItem item : list){
            Double itemPrice = item.getProduct().getPrice() * item.getQuantity();
            totalPrice = totalPrice + itemPrice;
        }
        return ResultResponse.<Cart>builder()
                .payload(cart)
                .totalPrice(totalPrice)
                .build();
    }

    @PutMapping("/update/{customerId}")
    Cart updateCart(@PathVariable Long customerId, @RequestBody Cart cart){
        return cartService.updateCart(customerId, cart);
    }

    @PutMapping("/empty-cart/{customerId}")
    String emptyTheCart(@PathVariable Long customerId){
        cartService.emptyCart(customerId);
        return "Card emptied";
    }

    @PutMapping("/add-product-tocart/{productId}/{customerId}/{quantity}")
    String addProductToCart(@PathVariable Long productId, @PathVariable Long customerId, @PathVariable int quantity){
        Product product = productService.getProduct(productId);
        return cartService.addProductToCart(customerId, product, quantity);
    }

    @PutMapping("/remove-product-from-cart/{customerId}/{cartItemId}")
    String removeProductFromCart(@PathVariable Long customerId, @PathVariable Long cartItemId){
        cartService.removeProductFromCart(customerId, cartItemId);
        return "Product removed from cart";
    }

    @PutMapping("/change-item-quantity/{customerId}/{cartListIndex}/{changeQuantity}")
    String changeItemQuantity(@PathVariable Long customerId, @PathVariable int cartListIndex,
                              @PathVariable int changeQuantity){
        cartService.cartItemChangeQuantity(customerId, cartListIndex, changeQuantity);
        return "Changed item quantity";
    }
}
