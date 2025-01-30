package com.example.demo.services;


import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.demo.entities.StatusType;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CartItemRepository cartItemRepository;
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository,
                                CartItemRepository cartItemRepository)
    {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // generate confirmation number
        // populate cart with cartItems
        //populate cart with cart items
        //retrieve customer info and cart info
        //populate customer with details

        //instantiating cart, customer and cartItem objects
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        cart.setCustomers(customer);
        Set<CartItem> cartItems = purchase.getCartItems();

        //update order status
        cart.setCartItems(purchase.getCartItems());
        cart.setStatus(StatusType.ordered);

        //generate and setting order tracking number for cart
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
            }
        );

        if(customer == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("Vacation could not be ordered! Please ensure there are items in the cart or your information is input properly!");
        }

        // save to the database
        cartRepository.save(cart);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID (UUID version-4)
        return UUID.randomUUID().toString();
    }

}
