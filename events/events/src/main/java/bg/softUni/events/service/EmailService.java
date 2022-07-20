package bg.softUni.events.service;

import bg.softUni.events.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    //the @Order(2) annotation define a sequence of execution
    @Order(2)
    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(OrderCreatedEvent evt){
        LOGGER.info("Sending email to user for order {}",evt.getOrderId());
    }
}
