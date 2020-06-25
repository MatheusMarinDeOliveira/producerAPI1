package infrastructure.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CheckoutVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RabbitMQService {

    private final String EXCHANGE_NAME = "EXCHANGE_NAME";
    private final String ROUTING_KEY = "foo.bar.#";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageToRabbit(CheckoutVO checkoutVO) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String message = objectMapper.writeValueAsString(checkoutVO);
            byte[] bytes = message.getBytes();
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, bytes);
        } catch (JsonProcessingException e) {
            System.out.println("Cannot send to rabbit");
        }
    }
}
