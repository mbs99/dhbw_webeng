package de.webeng.basicrest.boundary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "list")
public class PersonListDto {

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<PersonDto> list;

  @JsonCreator
  public PersonListDto(@JsonProperty("person") List<PersonDto> list) {
    this.list = list;
  }

  public List<PersonDto> getList() {
    return list;
  }
}
