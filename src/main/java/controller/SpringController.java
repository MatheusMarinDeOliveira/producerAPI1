package controller;

import entities.checkout.CheckoutVO;
import entities.country.Country;
import entities.country.MoreInformationCountryVO;
import entities.browsequotes.BrowseQuotesRequest;
import entities.browsequotes.BrowseQuotesResponse;
import entities.listplaces.ListPlacesRequest;
import entities.listplaces.ListPlacesResponse;
import infrastructure.flightapi.FlightService;
import infrastructure.rabbitmq.RabbitMQService;
import infrastructure.soapService.SoapService;
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

    @Autowired
    public SoapService soapService;

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
    @PostMapping("/checkout")
    public String checkoutFlight(@RequestBody CheckoutVO checkoutVO) {
        try {
            rabbitMQService.sendMessageToRabbit(checkoutVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Processing requesting for the checkout";
    }

    //Realiza chamada ao servico soap que buscara mais informacoes sobre paises
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
