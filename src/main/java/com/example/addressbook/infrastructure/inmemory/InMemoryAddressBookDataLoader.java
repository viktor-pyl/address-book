package com.example.addressbook.infrastructure.inmemory;

import com.example.addressbook.AddressBookApplication;
import com.example.addressbook.infrastructure.file.reader.AddressBookFileReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.FileSystemResource;

/**
 * {@link #run(ApplicationArguments args) run} method is invoked after the application context and
 * all beans are wired up, but before anything else happens. This provides a convenient place for
 * data to be loaded into the address book.
 */
@Slf4j
@RequiredArgsConstructor
public class InMemoryAddressBookDataLoader implements ApplicationRunner {

  private final InMemoryAddressBook inMemoryAddressBook;
  private final List<AddressBookFileReader> addressBookFileReaders;

  @Override
  public void run(ApplicationArguments args) {
    log.debug("Started loading data for Address Book...");

    var filePaths = args.getOptionValues(AddressBookApplication.CommandLineConstants.FILE_PATH);
    if (filePaths == null || filePaths.isEmpty()) {
      return;
    }

    var resource = new FileSystemResource(filePaths.get(0));
    var reader =
        addressBookFileReaders.stream()
            .filter(r -> r.supports(resource.getFile()))
            .findFirst()
            .orElseGet(() -> addressBookFileReaders.get(0));

    log.debug("Started reading file {}", resource.getFilename());
    var persons = reader.readFile(resource.getFile());
    log.debug("Persons: {}", persons);

    inMemoryAddressBook.init(persons);
  }
}
