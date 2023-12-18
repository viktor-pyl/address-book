package com.example.addressbook.domain;

import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PersonProvider {

  public static Person getMalePerson() {
    return new Person("first", "name", Gender.MALE, new Date());
  }

  public static Person getFemalePerson() {
    return new Person("Jane", "Doe", Gender.FEMALE, new Date());
  }

  public static List<Person> getPersons() {
    var list = new ArrayList<Person>(2);
    list.add(PersonProvider.getMalePerson());
    list.add(PersonProvider.getFemalePerson());
    return list;
  }
}
