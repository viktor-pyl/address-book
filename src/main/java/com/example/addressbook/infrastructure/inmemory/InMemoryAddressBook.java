package com.example.addressbook.infrastructure.inmemory;

import com.example.addressbook.domain.AddressBook;
import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InMemoryAddressBook implements AddressBook {

  private List<Person> persons = new ArrayList<>();

  public void init(List<Person> persons) {
    this.persons = persons;
  }

  @Override
  public List<Person> findAllPersons() {
    return persons.stream().toList();
  }

  @Override
  public List<Person> findPersonsByFirstName(String firstName) {
    return persons.stream().filter(p -> p.firstName().equalsIgnoreCase(firstName)).toList();
  }

  @Override
  public List<Person> findPersonsByGender(Gender gender) {
    return persons.stream().filter(p -> p.gender() == gender).toList();
  }
}
