package com.example.addressbook.domain.tasks;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.addressbook.domain.AddressBook;
import com.example.addressbook.domain.PersonProvider;
import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountMalesTaskTest {

  private AddressBook addressBook;
  private final CountMalesTask tested = new CountMalesTask();

  @BeforeEach
  public void setUp() {
    addressBook = mock(AddressBook.class);
  }

  @Test
  void shouldCountMalesInEmptyAddressBook() {
    // given
    given(addressBook.findPersonsByGender(Gender.MALE)).willReturn(Collections.emptyList());

    // when
    tested.perform(addressBook);

    // then
    Assertions.assertEquals("0", tested.getResult());
  }

  @Test
  void shouldCountMalesInAddressBook() {
    // given
    var malesList = new ArrayList<Person>(2);
    malesList.add(PersonProvider.getMalePerson());
    malesList.add(PersonProvider.getMalePerson());
    given(addressBook.findPersonsByGender(Gender.MALE)).willReturn(malesList);

    // when
    tested.perform(addressBook);

    // then
    Assertions.assertEquals("2", tested.getResult());
  }
}
