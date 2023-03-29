package org.example.models;

public class ShoppingListItem {
    private String name;
    private Double price;
    private int pieces;

    public ShoppingListItem(String name, Double price, int pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public int getPieces() {
        return pieces;
    }
}
