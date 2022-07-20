package bg.softUni.events.service;

import bg.softUni.events.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);

    //the @Order(3) annotation define a sequence of execution
    @Order(3)
    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(OrderCreatedEvent evt){
        LOGGER.info("Decreased inventory for order {}",evt.getOrderId());
    }
}
