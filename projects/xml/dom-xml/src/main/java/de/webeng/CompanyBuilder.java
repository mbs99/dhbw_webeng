package de.webeng;

import de.webeng.model.Company;
import de.webeng.model.base.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

public class CompanyBuilder {

  TransformerFactory transformerFactory = TransformerFactory.newInstance();
  Transformer transformer = transformerFactory.newTransformer();
  private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
  private DocumentBuilder builder = builderFactory.newDocumentBuilder();

  public CompanyBuilder() throws ParserConfigurationException, TransformerConfigurationException {
  }

  public void toXml(Company company, OutputStream xmlBuffer) throws TransformerException {
    Document doc = builder.newDocument();
    Element rootElement = doc.createElement("company");
    doc.appendChild(rootElement);
    company.getStaff().stream()
            .map(
                    staff -> {
                      Element staffElement = doc.createElement("staff");

                      if (null != staff.getStaffName()) {
                        Name name = staff.getStaffName();
                        if (null != name.getFirstName()) {
                          Element firstNameElement = doc.createElement("firstname");
                          firstNameElement.setTextContent(name.getFirstName());
                          staffElement.appendChild(firstNameElement);
                        }
                        if (null != name.getLastName()) {
                          Element lastNameElement = doc.createElement("lastname");
                          lastNameElement.setTextContent(name.getLastName());
                          staffElement.appendChild(lastNameElement);
                        }
                        if (null != name.getFirstName()) {
                          Element nickNameElement = doc.createElement("nickname");
                          nickNameElement.setTextContent(name.getNickName());
                          staffElement.appendChild(nickNameElement);
                        }
                      }

                      if (null != staff.getSalary()) {
                        Element salaryElement = doc.createElement("salary");
                        salaryElement.setTextContent(staff.getSalary().toString());
                        staffElement.appendChild(salaryElement);
                      }

                      return staffElement;
                    })
            .forEach(rootElement::appendChild);

    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(xmlBuffer);

    transformer.transform(source, result);
  }
}
