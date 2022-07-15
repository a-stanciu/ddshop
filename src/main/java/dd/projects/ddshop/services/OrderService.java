package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.OrderDTO;
import dd.projects.ddshop.entities.Order;
import dd.projects.ddshop.mappers.OrderMapper;
import dd.projects.ddshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public Order createOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.destinationToSource(orderDTO));
    }

    public Order updateOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.destinationToSource(orderDTO));
    }

    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    public List<OrderDTO> getOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(orderMapper::sourceToDestination)
                .toList();
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }
}
