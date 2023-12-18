package com.example.addressbook.infrastructure.file.reader.csv;

import com.example.addressbook.domain.model.Gender;
import com.example.addressbook.domain.model.Person;
import com.example.addressbook.infrastructure.file.reader.AddressBookFileReader;
import com.example.addressbook.infrastructure.file.reader.csv.model.CsvPerson;
import com.example.addressbook.infrastructure.inmemory.InMemoryAddressBook;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@ConditionalOnBean(InMemoryAddressBook.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@Slf4j
public class AddressBookCsvFileReader implements AddressBookFileReader {

  @SneakyThrows
  @Override
  public List<Person> readFile(File file) {
    try (var fileReader = new FileReader(file)) {
      var csvToBeanBuilder = new CsvToBeanBuilder<CsvPerson>(fileReader);
      List<CsvPerson> csvPersons = csvToBeanBuilder.withType(CsvPerson.class).build().parse();
      log.debug("Parsed csv persons: {}", csvPersons);

      return csvPersons.stream().map(this::map).toList();
    }
  }

  private Person map(CsvPerson csvPerson) {

    var parts = csvPerson.getFullName().trim().split("\\s", 2);
    return new Person(
        parts[0],
        parts.length > 1 ? parts[1] : "",
        Gender.valueOf(csvPerson.getGender().trim().toUpperCase()),
        csvPerson.getDateOfBirth());
  }

  @Override
  public boolean supports(File file) {
    return file.getName().toLowerCase().trim().endsWith(".csv");
  }
}
