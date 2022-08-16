package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    public void validate(OrderDTO orderDTO) throws Exception {
        if (orderDTO.getUserId() == null) {
            throw new Exception("User ID is invalid");
        }

        if (orderDTO.getDeliveryAddress() == null) {
            throw new Exception("Delivery address is invalid");
        }

        if (orderDTO.getInvoiceAddress() == null) {
            throw new Exception("Invoice address is invalid");
        }

        if (orderDTO.getTotalPrice() < 0) {
            throw new Exception("Total price is invalid");
        }

        if (orderDTO.getOrderDate() == null) {
            throw new Exception("Order date is invalid");
        }

        if (orderDTO.getCartId() == null) {
            throw new Exception("Cart ID is invalid");
        }
    }
}
