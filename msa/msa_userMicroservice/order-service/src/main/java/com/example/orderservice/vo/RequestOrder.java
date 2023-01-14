package com.example.orderservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestOrder {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    private String productId;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two chracters")
    private Integer qty;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equal or grater than 8 characters")
    private Integer unitPrice;
}