package controller;

import entities.browsequotes.BrowseQuotesRequest;
import entities.browsequotes.BrowseQuotesResponse;
import entities.listplaces.ListPlacesRequest;
import entities.listplaces.ListPlacesResponse;
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

    @Autowired
    public FlightService flightService;

    //Vai listar todos os lugares para viagem
    @PostMapping("/listPlaces")
    public ListPlacesResponse listPlaces(@RequestBody ListPlacesRequest payload) {
        try {
            ListPlacesResponse listPlacesResponse = flightService.listPlaces(payload);
            return listPlacesResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ListPlacesResponse();
    }

    //Lista viagens disponiveis dps de passar destino e partida
    @PostMapping("/browseQuotes")
    public BrowseQuotesResponse browseQuotes(@RequestBody BrowseQuotesRequest payload) {
        try {
            return flightService.browseQuotes(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BrowseQuotesResponse();
    }

    //Vai realizar postagem pro consumer fazer o processamento do pagamento
    @PostMapping("/checkoutFlight")
    public String checkoutFlight(@RequestBody ListPlacesRequest payload) {
        try {
          //  FlightService.listPlaces(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rabbitMQService.sendMessageToRabbit(payload.getQueryParameter(), payload.getCurrency(), payload.getLocale());
        return "user " + payload.getQueryParameter() + " created in database!!";
    }


}
