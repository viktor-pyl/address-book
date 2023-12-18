package com.example.addressbook.domain;

import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import java.util.List;

/** Operations related to retrieving of address book persons */
public interface AddressBook {

  /**
   * Finds all persons in address book
   *
   * @return the list of all persons from address book
   */
  List<Person> findAllPersons();

  /**
   * Finds persons with a specific first name in address book
   *
   * @param firstName the first name of person
   * @return the list of persons with a specific first name
   */
  List<Person> findPersonsByFirstName(String firstName);

  /**
   * Finds persons with a specific gender in address book
   *
   * @param gender
   * @return the list of persons with a specific gender
   */
  List<Person> findPersonsByGender(Gender gender);
}
