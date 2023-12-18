package com.example.addressbook.domain.tasks;

import com.example.addressbook.domain.AddressBook;

public interface Task {

  String getTitle();

  int getNumber();

  void perform(AddressBook addressBook);

  String getResult();
}
