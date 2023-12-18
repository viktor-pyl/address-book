package com.example.addressbook.domain;

import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import java.util.List;

public interface AddressBook {

  List<Person> findAllPersons();

  List<Person> findPersonsByFirstName(String firstName);

  List<Person> findPersonsByGender(Gender gender);
}
