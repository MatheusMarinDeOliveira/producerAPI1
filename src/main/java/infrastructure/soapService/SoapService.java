package infrastructure.soapService;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Component
public class SoapService {

    public void callSoapService(String country) throws IOException, ParserConfigurationException, SAXException {
        //Code to make a webservice HTTP request
        String responseString = "";
        String outputString = "";
        String wsURL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <web:FullCountryInfo>\n" +
                "            <web:sCountryISOCode>BRA</web:sCountryISOCode>\n" +
                "        </web:FullCountryInfo>\n" +
                "    </soapenv:Body>\n" +
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
        InputStreamReader isr = null;
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
        NodeList nodeLst = document.getElementsByTagName("m:sISOCode");
        String elementValue = nodeLst.item(0).getTextContent();
        System.out.println(elementValue);

        //Write the SOAP message formatted to the console.
        String formattedSOAPResponse = formatXML(outputString); // Write a separate method to format the XML input.
        System.out.println(formattedSOAPResponse);
    }

    //format the XML in your String
    private String formatXML(String unformattedXml) throws IOException, SAXException, ParserConfigurationException {
        Document document = parseXmlFile(unformattedXml);
        OutputFormat format = new OutputFormat();
        format.setIndenting(true);
        format.setIndent(3);
        format.setOmitXMLDeclaration(true);
        Writer out = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(out, format);
        serializer.serialize(document);
        return out.toString();
    }

    private Document parseXmlFile(String in) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(in));
        return db.parse(is);
    }
}
