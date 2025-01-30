package com.example.demo.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@Nonnull
@Setter
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="customer_id", nullable = false)
    private Long id;

    @Column(name ="address" , nullable = false)
    private String address;

    @Column(name ="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name ="customer_first_name" ,nullable = false)
    private String firstName;

    @Column(name ="customer_last_name",nullable = false)
    private String lastName;

    @Column(name ="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name ="phone",nullable = false)
    private String phone;

    @Column(name ="postal_code",nullable = false)
    private String postal_code;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id" ,nullable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<Cart> cart;
}
