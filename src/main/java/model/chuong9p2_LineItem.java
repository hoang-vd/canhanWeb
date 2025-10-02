// package model;

// import java.io.Serializable;
// import java.text.NumberFormat;

// public class chuong9p2_LineItem implements Serializable {

//     private chuong9p2_Product product;
//     private int quantity;

//     public chuong9p2_LineItem() {}

//     public void setProduct(chuong9p2_Product p) {
//         product = p;
//     }

//     public chuong9p2_Product getProduct() {
//         return product;
//     }

//     public void setQuantity(int quantity) {
//         this.quantity = quantity;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public double getTotal() {
//         double total = product.getPrice() * quantity;
//         return total;
//     }

//     public String getTotalCurrencyFormat() {
//         NumberFormat currency = NumberFormat.getCurrencyInstance();
//         return currency.format(this.getTotal());
//     }
// }