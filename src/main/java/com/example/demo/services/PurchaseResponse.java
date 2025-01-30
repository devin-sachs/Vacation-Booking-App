package com.example.demo.services;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
@Data
@Getter
@Setter

public class PurchaseResponse {

    @NonNull
    private String orderTrackingNumber;
}
