package repository;

import interfaces.OrderInterface;
import model.Order;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements OrderInterface {

    private static List<Order> ordersList = new ArrayList<>();

    @Override
    public void create(Order order){
        ordersList.add(order);
    }

    @Override
    public Order searchById(Long id) {
        Order searchedOrder = null;

        for (Order order : ordersList) {
            if (order.getId().equals(id)) {
                searchedOrder = order;
                return searchedOrder;
            }
        }
        return null;
    }

    @Override
    public Order searchByRecipientCPF(String recipientCPF) {
        Order searchedOrder = null;

        for (Order order : ordersList) {
            if (order.getRecipient().equals(recipientCPF)) {
                searchedOrder = order;
                return searchedOrder;
            }
        }
        return null;
    }

    @Override
    public List<Order> listAllOrders() {
        return ordersList;
    }

    @Override
    public void delete(Long id) {

        int position = -1;

        Order orderToDelete = searchById(id);


        if (orderToDelete != null) {
            position = ordersList.indexOf(orderToDelete);
        }

        if (position != -1) {
            ordersList.remove(position);
        }

    }
}
