package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.OrderDTO;
import dd.projects.ddshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable Integer id, @RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.updateOrder(id, orderDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
