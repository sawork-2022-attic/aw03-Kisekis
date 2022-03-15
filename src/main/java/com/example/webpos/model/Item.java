package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    public void setQuantity(int quantity) {
        if(quantity<0) return;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return product.toString() +"\t" + quantity;
    }
}
