package controller;

import entities.ListPlacesRequest;
import entities.UserVO;
import infrastructure.flightapi.FlightService;
import infrastructure.rabbitmq.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"infrastructure.rabbitmq"})
public class SpringController {

    @Autowired
    public RabbitMQService rabbitMQService;

    @PostMapping("/user")
    public String saveUser(@RequestBody ListPlacesRequest payload) {
        try {
            FlightService.listPlaces(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rabbitMQService.sendMessageToRabbit(payload.getQueryParameter(), payload.getCurrency(), payload.getLocale());
        return "user " + payload.getQueryParameter() + " created in database!!";
    }
}
