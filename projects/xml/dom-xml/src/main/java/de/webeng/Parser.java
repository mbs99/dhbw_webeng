package de.webeng;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class Parser {
    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder = builderFactory.newDocumentBuilder();

    public Parser() throws ParserConfigurationException {
    }


    public Document parse(InputStream xmlStream) throws IOException, SAXException {

       return builder.parse(xmlStream);
    }
}
