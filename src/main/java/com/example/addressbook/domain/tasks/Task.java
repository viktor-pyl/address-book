package com.example.addressbook.domain.tasks;

import com.example.addressbook.domain.AddressBook;

/** Interface describes task and operations to run it and get the result */
public interface Task {

  /**
   * Returns the title of task
   *
   * @return the title of task describing the purpose of that task
   */
  String getTitle();

  /**
   * Returns the number of task
   *
   * @return the number of task that identifies that task
   */
  int getNumber();

  /**
   * Performs task using address book
   *
   * @param addressBook address book containing persons information
   */
  void perform(AddressBook addressBook);

  /**
   * Returns the result of performed task
   *
   * @return result of task execution
   */
  String getResult();
}
