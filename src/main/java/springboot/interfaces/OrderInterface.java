package springboot.interfaces;

import springboot.model.Order;

import java.util.List;

public interface OrderInterface {

    void create(Order order);

    void delete(Long id);

    Order searchById(Long id);

    Order searchByRecipientCPF(String recipientCPF);

    List<Order> listAllOrders();

}
