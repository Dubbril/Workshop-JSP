package model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Integer, Item> cart;

    public ShoppingCart() {
        cart = new LinkedHashMap<Integer, Item>();
    }

    public void add(Item item) {
        cart.put(item.getId(), item);
    }

    public void update(int id, int amount) {
        cart.get(id).setAmount(amount);
    }

    public void remove(int id) {
        cart.remove(id);
    }

    public Collection<Item> getItems() {
        return cart.values();
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Item item : cart.values()) {
            sum += item.getPrice() * item.getAmount();
        }
        return sum;
    }
}
