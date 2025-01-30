package com.example.demo.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
//@Data
@Nonnull
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="cart_id")
    private Long cartId;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name ="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item) {

        if(item != null){
            if(cartItems == null) {
                cartItems = new HashSet<>();
            }
        }
        cartItems.add(item);
        item.setCart(this);
    }
}