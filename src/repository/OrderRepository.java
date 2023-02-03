package repository;

import model.Order;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

public class OrderRepository implements BaseRepository<Order> {

    private static final List<Order> orders = new ArrayList<>();
    @Override
    public List<Order> getAll() {
        return orders.stream().toList();
    }

    @Override
    public Order getById(Long id) {
        return orders.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order add(Order entity) {
        return orders.add(entity) ? entity : null;
    }
}
