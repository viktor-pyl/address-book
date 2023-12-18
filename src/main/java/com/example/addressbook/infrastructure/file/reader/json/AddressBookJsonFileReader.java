package com.example.addressbook.infrastructure.file.reader.json;

import com.example.addressbook.domain.model.Person;
import com.example.addressbook.infrastructure.file.reader.AddressBookFileReader;
import com.example.addressbook.infrastructure.inmemory.InMemoryAddressBook;
import java.io.File;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@ConditionalOnBean(InMemoryAddressBook.class)
@Component
public class AddressBookJsonFileReader implements AddressBookFileReader {

  @Override
  public List<Person> readFile(File file) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean supports(File file) {
    return file.getName().toLowerCase().trim().endsWith(".json");
  }
}
