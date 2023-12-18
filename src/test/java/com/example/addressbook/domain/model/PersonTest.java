package com.example.addressbook.domain.model;

import com.example.addressbook.domain.PersonProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void shouldReturnFullName() {
    // given
    var person = PersonProvider.getMalePerson();
    // when
    var fullName = person.getFullName();
    // then
    Assertions.assertEquals("first name", fullName);
  }
}
