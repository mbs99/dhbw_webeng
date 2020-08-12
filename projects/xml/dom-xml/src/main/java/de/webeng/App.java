package de.webeng;

import de.webeng.model.Company;
import de.webeng.model.Staff;
import de.webeng.model.base.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {

    App.createDoc();
  }

  private static void readDoc() {
    try {
      Parser parser = new Parser();
      Document xmlDoc = parser.parse(Parser.class.getResourceAsStream("/xml/company.xml"));

      Element root = xmlDoc.getDocumentElement();
      NodeList staffElements = root.getElementsByTagName("staff");
      for (int i = 0; i < staffElements.getLength(); i++) {
        Node staff = staffElements.item(i);
        App.handleStaffElement(((Element) staff));
      }

      NodeList children = root.getChildNodes();
      for (int i = 0; i < children.getLength(); i++) {
        Node child = children.item(i);
        if (child.getNodeType() == Node.ELEMENT_NODE) {
          App.handleStaffElement(((Element) child));
        } else if (child.getNodeType() == Node.TEXT_NODE) {
          System.out.println(child.getNodeValue());
        }
      }

    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }
  }

  private static void handleStaffElement(Element staff) {
    String firstName = staff.getElementsByTagName("firstname").item(0).getTextContent();
    System.out.println("firstname=" + firstName);

    String lastName = staff.getElementsByTagName("lastname").item(0).getTextContent();
    System.out.println("lastname=" + lastName);
  }

  private static void createDoc() {
    try {
      CompanyBuilder builder = new CompanyBuilder();

      Staff jon = new Staff(new Name("John", "Doe"), 120000d);
      List<Staff> staff = new ArrayList<>();
      staff.add(jon);

      Company company = new Company(staff);

      builder.toXml(company, System.out);

    } catch (ParserConfigurationException | TransformerException e) {
      e.printStackTrace();
    }
  }
}
