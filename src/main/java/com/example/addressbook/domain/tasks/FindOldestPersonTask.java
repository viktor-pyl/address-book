package com.example.addressbook.domain.tasks;

import com.example.addressbook.domain.AddressBook;
import com.example.addressbook.domain.model.Person;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindOldestPersonTask extends AbstractTask {
  public FindOldestPersonTask() {
    super(2, "Who is the oldest person in the address book?");
  }

  @Override
  public void perform(AddressBook addressBook) {
    var minDate =
        addressBook.findAllPersons().stream()
            .map(Person::dateOfBirth)
            .min(Date::compareTo)
            .orElseThrow();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    result =
        String.join(
            ", ",
            addressBook.findAllPersons().stream()
                .filter(person -> person.dateOfBirth().equals(minDate))
                .map(
                    p ->
                        String.format(
                            "%s (%s)", p.getFullName(), dateFormat.format(p.dateOfBirth())))
                .toList());
  }
}
