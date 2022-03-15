package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        for(Item i : items) {
            if(i.getProduct().getId().equals(item.getProduct().getId())) {
                if(i.getQuantity()+item.getQuantity()<=0) {
                    items.remove(i);
                    return false;
                }
                i.setQuantity(i.getQuantity()+item.getQuantity());
                return true;
            }
        }

        return items.add(item);
    }

    public Item getItem(String id) {
        for(Item i : items) {
            if(i.getProduct().getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public boolean emptyList() {
        items.clear();
        return true;
    };

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
