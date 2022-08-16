package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.OrderDTO;
import dd.projects.ddshop.entities.Order;
import dd.projects.ddshop.mappers.OrderMapper;
import dd.projects.ddshop.repositories.OrderRepository;
import dd.projects.ddshop.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderValidator orderValidator;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderValidator = orderValidator;
    }

    public Order createOrder(OrderDTO orderDTO) throws Exception {
        orderValidator.validate(orderDTO);
        return orderRepository.save(orderMapper.destinationToSource(orderDTO));
    }

    public Order updateOrder(int id, OrderDTO orderDTO) throws Exception {
        orderDTO.setId(id);
        orderValidator.validate(orderDTO);
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
}
