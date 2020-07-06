package controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.browsequotes.BrowseQuotesRequest;
import entities.browsequotes.BrowseQuotesResponse;
import entities.browsequotes.BrowseRoutesResponse;
import entities.checkout.CheckoutVO;
import entities.country.Country;
import entities.country.MoreInformationCountryVO;
import entities.listplaces.ListPlacesRequest;
import entities.listplaces.ListPlacesResponse;
import infrastructure.flightapi.FlightService;
import infrastructure.rabbitmq.RabbitMQService;
import infrastructure.soapService.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@ComponentScan(basePackages = {"infrastructure.rabbitmq"})
public class SpringController {

    @Autowired
    public RabbitMQService rabbitMQService;

    @Autowired
    public FlightService flightService;

    @Autowired
    public SoapService soapService;

    //Vai listar todos os lugares para viagem
    @CrossOrigin
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
    @CrossOrigin
    @PostMapping("/browseQuotes")
    public BrowseQuotesResponse browseQuotes(@RequestBody BrowseQuotesRequest payload) {
        try {
            return flightService.browseQuotes(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BrowseQuotesResponse();
    }


    //Lista viagens disponiveis dps de passar destino e partida
    @CrossOrigin
    @PostMapping("/browseRoutes")
    public BrowseRoutesResponse browseRoutes(@RequestBody BrowseQuotesRequest payload) {
        try {
            return flightService.browseRoutes(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BrowseRoutesResponse();
    }

    //Vai realizar postagem pro consumer fazer o processamento do pagamento
    @CrossOrigin
    @PostMapping("/checkout")
    public CheckoutId checkoutFlight(@RequestBody CheckoutVO checkoutVO) {
        checkoutVO.idCheckout = UUID.randomUUID();
        try {
            rabbitMQService.sendMessageToRabbit(checkoutVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CheckoutId(checkoutVO.idCheckout);
    }

    class CheckoutId {
        @JsonProperty("idCheckout")
        UUID idCheckout;

        CheckoutId(UUID idCheckout) {
            this.idCheckout = idCheckout;
        }
    }

    //Realiza chamada ao servico soap que buscara mais informacoes sobre paises
    @CrossOrigin
    @PostMapping("/moreInformation")
    public Country moreInformation(@RequestBody MoreInformationCountryVO moreInformationVO) {
        try {
            ListPlacesRequest payload = new ListPlacesRequest();
            payload.setQueryParameter(moreInformationVO.getCountry());
            payload.setCountry("br");
            payload.setCurrency("brl");
            payload.setLocale("en-GB");

            ListPlacesResponse listPlacesResponse = flightService.listPlaces(payload);

            String countryId = listPlacesResponse.getPlacesList().get(0).getCountryId();
            String replace = countryId.replace("-sky", "");

            Country s = soapService.callSoapService(replace);
            return s;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
