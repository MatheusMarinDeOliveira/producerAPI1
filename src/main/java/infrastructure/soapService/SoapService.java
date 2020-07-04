package infrastructure.soapService;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import entities.country.Country;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Component
public class SoapService {

    public Country callSoapService(String isoCode) throws IOException, ParserConfigurationException, SAXException {
        //Code to make a webservice HTTP request
        String responseString = "";
        String outputString = "";
        String wsURL = "https://soap-dsid-country.herokuapp.com/ws/countries.wsdl";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "\t\t\t\t  xmlns:gs=\"http://spring.io/guides/gs-producing-web-service\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <gs:getCountryRequest>\n" +
                "         <gs:name>" + isoCode + "</gs:name>\n" +
                "      </gs:getCountryRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();

        String SOAPAction = "getCountryRequest";

        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length",
                String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        //Write the content of the request to the outputstream of the HTTP Connection.
        out.write(b);
        out.close();
        //Ready with sending the request.

        //Read the response.
        InputStreamReader isr;
        if (httpConn.getResponseCode() == 200) {
            isr = new InputStreamReader(httpConn.getInputStream());
        } else {
            isr = new InputStreamReader(httpConn.getErrorStream());
        }

        BufferedReader in = new BufferedReader(isr);

        //Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
        Document document = parseXmlFile(outputString); // Write a separate method to parse the xml input.

        Country country = new Country();
        country.setName(document.getElementsByTagName("ns2:name").item(0).getTextContent());
        country.setCapital(document.getElementsByTagName("ns2:capital").item(0).getTextContent());
        country.setCurrency(document.getElementsByTagName("ns2:currency").item(0).getTextContent());
        country.setPhoneCode(document.getElementsByTagName("ns2:phoneCode").item(0).getTextContent());
        country.setLanguage(document.getElementsByTagName("ns2:language").item(0).getTextContent());

        return country;
    }

    private Document parseXmlFile(String in) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(in));
        return db.parse(is);
    }
}
