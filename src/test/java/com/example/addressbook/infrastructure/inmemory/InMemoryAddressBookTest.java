package com.example.addressbook.infrastructure.inmemory;

import com.example.addressbook.domain.PersonProvider;
import com.example.addressbook.domain.model.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InMemoryAddressBookTest {

  private final InMemoryAddressBook inMemoryAddressBook = new InMemoryAddressBook();

  @Test
  void findAllPersons() {
    // given
    var list = PersonProvider.getPersons();
    inMemoryAddressBook.init(list);

    // when
    var result = inMemoryAddressBook.findAllPersons();

    // then
    Assertions.assertEquals(list, result);
  }

  @Test
  void findPersonsByFirstName() {
    // given
    var list = PersonProvider.getPersons();
    inMemoryAddressBook.init(list);
    var firstName = "Jane";

    // when
    var result = inMemoryAddressBook.findPersonsByFirstName(firstName);

    // then
    Assertions.assertEquals(firstName, result.get(0).firstName());
  }

  @Test
  void findPersonsByGender() {
    // given
    var list = PersonProvider.getPersons();
    inMemoryAddressBook.init(list);
    var gender = Gender.MALE;

    // when
    var result = inMemoryAddressBook.findPersonsByGender(gender);

    // then
    Assertions.assertEquals(gender, result.get(0).gender());
  }
}
