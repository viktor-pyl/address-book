package com.example.addressbook.domain;

import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PersonProvider {

  public static Person getMalePerson() {
    return new Person("first", "name", Gender.MALE, new Date());
  }

  public static Person getFemalePerson() {
    return new Person("first", "name", Gender.FEMALE, new Date());
  }
}
