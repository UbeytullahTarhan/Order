package service;

import model.Order;
import repository.OrderRepository;

import java.util.List;

public class OrderService implements  BaseService<Order> {
    private final OrderRepository orderRepository ;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public Order add(Order entity) {
        return orderRepository.add(entity);
    }
}
