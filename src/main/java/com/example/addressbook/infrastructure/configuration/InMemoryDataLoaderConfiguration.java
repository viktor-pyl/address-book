package com.example.addressbook.infrastructure.configuration;

import com.example.addressbook.infrastructure.file.reader.AddressBookFileReader;
import com.example.addressbook.infrastructure.inmemory.InMemoryAddressBook;
import com.example.addressbook.infrastructure.inmemory.InMemoryAddressBookDataLoader;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@ConditionalOnBean(InMemoryAddressBook.class)
@Configuration
public class InMemoryDataLoaderConfiguration {

  @Order(Ordered.HIGHEST_PRECEDENCE)
  @Bean
  ApplicationRunner dataLoader(
      InMemoryAddressBook inMemoryAddressBook, List<AddressBookFileReader> addressBookFileReaders) {
    return new InMemoryAddressBookDataLoader(inMemoryAddressBook, addressBookFileReaders);
  }
}
