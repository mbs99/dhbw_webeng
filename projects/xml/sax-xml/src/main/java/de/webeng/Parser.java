package de.webeng;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class Parser {

  SAXParserFactory factory = SAXParserFactory.newInstance();
  SAXParser saxParser = factory.newSAXParser();
  DefaultHandler handler = new SaxHandler();

  public Parser() throws ParserConfigurationException, SAXException {
  }

  public void parse(InputStream xmlStream) throws SAXException, IOException {
    saxParser.parse(xmlStream, handler);
  }

  class SaxHandler extends DefaultHandler {
    boolean isFirstName = false;
    boolean isLastName = false;
    boolean isNickName = false;
    boolean isSalary = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {

      System.out.println("Start Element :" + qName);

      if (qName.equalsIgnoreCase("FIRSTNAME")) {
        isFirstName = true;
      }

      if (qName.equalsIgnoreCase("LASTNAME")) {
        isLastName = true;
      }

      if (qName.equalsIgnoreCase("NICKNAME")) {
        isNickName = true;
      }

      if (qName.equalsIgnoreCase("SALARY")) {
        isSalary = true;
      }
    }

    public void endElement(String uri, String localName, String qName) {

      System.out.println("End Element :" + qName);
    }

    public void characters(char[] ch, int start, int length) {

      if (isFirstName) {
        System.out.println("First Name : " + new String(ch, start, length));
        isFirstName = false;
      }

      if (isLastName) {
        System.out.println("Last Name : " + new String(ch, start, length));
        isLastName = false;
      }

      if (isNickName) {
        System.out.println("Nick Name : " + new String(ch, start, length));
        isNickName = false;
      }

      if (isSalary) {
        System.out.println("Salary : " + new String(ch, start, length));
        isSalary = false;
      }
    }
  }
}
