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

    @GetMapping("/get/{cartId}")
    ResultResponse<Cart> getCart(@PathVariable Long cartId){
        Cart cart = cartService.getCart(cartId);
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

    @PutMapping("/update/{cartId}")
    Cart updateCart(@PathVariable Long cartId, @RequestBody Cart cart){
        return cartService.updateCart(cartId, cart);
    }

    @PutMapping("/empty-cart/{cartId}")
    String emptyTheCart(@PathVariable Long cartId){
        cartService.emptyCart(cartId);
        return "Card emptied";
    }

    @PutMapping("/add-product-tocart/{productId}/{cartId}/{quantity}")
    CartItem addProductToCart(@PathVariable Long productId, @PathVariable Long cartId, @PathVariable int quantity){
        Product product = productService.getProduct(productId);
        return cartService.addProductToCart(cartId, product, quantity);
    }

    @PutMapping("/remove-product-from-cart/{cartId}/{cartItemId}")
    String removeProductFromCart(@PathVariable Long cartId, @PathVariable Long cartItemId){
        cartService.removeProductFromCart(cartId, cartItemId);
        return "Product removed from cart";
    }
//Long cartId,int cartListIndex, int changeQuantity)
    @PutMapping("/change-item-quantity/{cartId}/{cartListIndex}/{changeQuantity}")
    String changeItemQuantity(@PathVariable Long cartId, @PathVariable int cartListIndex, @PathVariable int changeQuantity){
        cartService.cartItemChangeQuantity(cartId, cartListIndex, changeQuantity);
        return "Changed item quantity";
    }
}
