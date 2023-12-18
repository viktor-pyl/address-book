package com.example.addressbook.domain.tasks;

import com.example.addressbook.domain.AddressBook;

public class BillAndPaulAgeDiffTask extends AbstractTask {
  public BillAndPaulAgeDiffTask() {
    super(3, "How many days older is Bill than Paul?");
  }

  @Override
  public void perform(AddressBook addressBook) {
    var bill = addressBook.findPersonsByFirstName("Bill").get(0);
    var paul = addressBook.findPersonsByFirstName("Paul").get(0);

    // Calculate the difference in milliseconds
    long timeDifference = paul.dateOfBirth().getTime() - bill.dateOfBirth().getTime();

    // Convert the difference from milliseconds to days
    long daysDifference = timeDifference / (24 * 60 * 60 * 1000);

    result = String.valueOf(daysDifference);
  }
}
