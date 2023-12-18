package com.example.addressbook.infrastructure.file.reader;

import com.example.addressbook.domain.model.Person;
import java.io.File;
import java.util.List;

/** Operations related to reading of persons from a file */
public interface AddressBookFileReader {

  /**
   * Reads persons from the given file.
   *
   * @param file the file with persons data from address book
   * @return the list of persons
   */
  List<Person> readFile(File file);

  /**
   * Checks whether reader can process that file
   *
   * @param file the file with persons data from address book
   * @return true in case of the file can be processed
   */
  boolean supports(File file);
}
