package de.webeng;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class App {
  public static void main(String[] args) {
    try {
      DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = builderFactory.newDocumentBuilder();
      Document xmlDocument = builder.parse(App.class.getResourceAsStream("/xml/company.xml"));
      XPath xPath = XPathFactory.newInstance().newXPath();
      String expression = "/company/staff[contains(firstname,'C')]/firstname";
      NodeList nodeList =
              (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

      for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        System.out.println(node.getNodeName());
        System.out.println(node.getNodeValue());
        System.out.println(node.getChildNodes().getLength());
      }

    } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
      e.printStackTrace();
    }
  }
}
