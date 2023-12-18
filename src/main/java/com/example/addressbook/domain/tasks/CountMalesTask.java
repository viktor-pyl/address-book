package com.example.addressbook.domain.tasks;

import com.example.addressbook.domain.AddressBook;
import com.example.addressbook.domain.model.Gender;

public class CountMalesTask extends AbstractTask {

  public CountMalesTask() {
    super(1, "How many males are in the address book?");
  }

  @Override
  public void perform(AddressBook addressBook) {
    result = String.valueOf(addressBook.findPersonsByGender(Gender.MALE).size());
  }
}
