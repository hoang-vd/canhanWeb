// package model;

// import java.io.Serializable;
// import java.util.ArrayList;

// public class chuong9p2_Cart implements Serializable {

//     private ArrayList<chuong9p2_LineItem> items;

//     public chuong9p2_Cart() {
//         items = new ArrayList<chuong9p2_LineItem>();
//     }

//     public ArrayList<chuong9p2_LineItem> getItems() {
//         return items;
//     }

//     public int getCount() {
//         return items.size();
//     }

//     public void addItem(chuong9p2_LineItem item) {
//         String code = item.getProduct().getCode();
//         int quantity = item.getQuantity();
//         for (int i = 0; i < items.size(); i++) {
//             chuong9p2_LineItem lineItem = items.get(i);
//             if (lineItem.getProduct().getCode().equals(code)) {
//                 lineItem.setQuantity(quantity);
//                 return;
//             }
//         }
//         items.add(item);
//     }

//     public void removeItem(chuong9p2_LineItem item) {
//         String code = item.getProduct().getCode();
//         for (int i = 0; i < items.size(); i++) {
//             chuong9p2_LineItem lineItem = items.get(i);
//             if (lineItem.getProduct().getCode().equals(code)) {
//                 items.remove(i);
//                 return;
//             }
//         }
//     }
// }
