package repository;

import interfaces.OrderInterface;
import model.Order;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements OrderInterface {

    private List<Order> orders = new ArrayList<>();

    @Override
    public void create(Order order){
        orders.add(order);
    }

    @Override
    public Order searchById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order searchByRecipientCPF(String recipientCPF) {
        for (Order order : orders) {
            String recipient = order.getRecipient();
            if (recipient != null) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public void delete(Long id) {
        Order order = searchById(id);
        if (order != null) {
            orders.remove(order);
        }
    }
}
