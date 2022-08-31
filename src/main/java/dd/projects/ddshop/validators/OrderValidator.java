package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.OrderDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    public void validate(OrderDTO orderDTO) throws IllegalInputException {
        if (orderDTO.getUserId() == null) {
            throw new IllegalInputException("User ID is invalid");
        }

        if (orderDTO.getDeliveryAddress() == null) {
            throw new IllegalInputException("Delivery address is invalid");
        }

        if (orderDTO.getInvoiceAddress() == null) {
            throw new IllegalInputException("Invoice address is invalid");
        }

        if (orderDTO.getTotalPrice() < 0) {
            throw new IllegalInputException("Total price is invalid");
        }

        if (orderDTO.getOrderDate() == null) {
            throw new IllegalInputException("Order date is invalid");
        }

        if (orderDTO.getCartId() == null) {
            throw new IllegalInputException("Cart ID is invalid");
        }
    }
}
