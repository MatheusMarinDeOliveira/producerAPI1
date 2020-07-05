package infrastructure.flightapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import entities.browsequotes.BrowseQuotesRequest;
import entities.browsequotes.BrowseQuotesResponse;
import entities.browsequotes.BrowseRoutesResponse;
import entities.listplaces.ListPlacesRequest;
import entities.listplaces.ListPlacesResponse;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    public ListPlacesResponse listPlaces(ListPlacesRequest listPlacesRequest) throws UnirestException {
        String queryParameter = listPlacesRequest.getQueryParameter();
        queryParameter = queryParameter.replace(" ", "%20");

        HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/" + listPlacesRequest.getCountry() + "/"
                + listPlacesRequest.getCurrency() //
                + "/" + listPlacesRequest.getLocale()  //
                + "/?query=" //
                + queryParameter) //
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "c060e08a97mshf3bbed1846f8a7ep17dbc9jsnae0c1ee8d09d")
                .asString();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().toString(), ListPlacesResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public BrowseQuotesResponse browseQuotes(BrowseQuotesRequest browseQuotesRequest) throws UnirestException {

        String queryInboundpartialDate = "";

        String inboundpartialDate = browseQuotesRequest.getInboundpartialDate();
        if (inboundpartialDate != null && !inboundpartialDate.isEmpty()) {
            queryInboundpartialDate = "?inboundpartialdate=" + inboundpartialDate;
        }

        HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/"
                + browseQuotesRequest.getCountry() + "/"
                + browseQuotesRequest.getCurrency() + "/"
                + browseQuotesRequest.getLocale() + "/"
                + browseQuotesRequest.getOriginPlace() + "/"
                + browseQuotesRequest.getDestinationPlace() + "/"
                + browseQuotesRequest.getOutboundpartialDate()
                + queryInboundpartialDate)
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "c060e08a97mshf3bbed1846f8a7ep17dbc9jsnae0c1ee8d09d")
                .asString();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().toString(), BrowseQuotesResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }



    public BrowseRoutesResponse browseRoutes(BrowseQuotesRequest browseQuotesRequest) throws UnirestException {

        String queryInboundpartialDate = "";

        String inboundpartialDate = browseQuotesRequest.getInboundpartialDate();
        if (inboundpartialDate != null && !inboundpartialDate.isEmpty()) {
            queryInboundpartialDate = "?inboundpartialdate=" + inboundpartialDate;
        }

        HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browseroutes/v1.0/"
                + browseQuotesRequest.getCountry() + "/"
                + browseQuotesRequest.getCurrency() + "/"
                + browseQuotesRequest.getLocale() + "/"
                + browseQuotesRequest.getOriginPlace() + "/"
                + browseQuotesRequest.getDestinationPlace() + "/"
                + browseQuotesRequest.getOutboundpartialDate()
                + queryInboundpartialDate)
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "c060e08a97mshf3bbed1846f8a7ep17dbc9jsnae0c1ee8d09d")
                .asString();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().toString(), BrowseRoutesResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
