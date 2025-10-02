package model;

import java.io.Serializable;
import java.util.ArrayList;

public class chuong7p1_Cart implements Serializable {

    private ArrayList<chuong7p1_LineItem> items;

    public chuong7p1_Cart() {
        items = new ArrayList<chuong7p1_LineItem>();
    }

    public ArrayList<chuong7p1_LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(chuong7p1_LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (chuong7p1_LineItem cartItem : items) {
            if (cartItem.getProduct().getCode().equals(code)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(chuong7p1_LineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            chuong7p1_LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

    public void removeItemByCode(String code) {
        if (code == null) return;
        for (int i = 0; i < items.size(); i++) {
            chuong7p1_LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

}