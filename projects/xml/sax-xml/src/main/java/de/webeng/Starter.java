package de.webeng;

public class Starter {
  public static void main(String[] argv) {

    try {

      Parser parser = new Parser();
      parser.parse(Starter.class.getResourceAsStream("/xml/company.xml"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
