package model;

import java.io.Serializable;
import java.text.NumberFormat;

public class chuong7p1_LineItem implements Serializable {

    private chuong7p1_Product product;
    private int quantity;

    public chuong7p1_LineItem() {
    }

    public void setProduct(chuong7p1_Product p) {
        product = p;
    }

    public chuong7p1_Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}