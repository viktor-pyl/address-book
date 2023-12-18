package com.example.addressbook.infrastructure.configuration;

import com.example.addressbook.domain.AddressBook;
import com.example.addressbook.domain.tasks.*;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskContainerConfiguration {

  @Bean
  TaskContainer taskContainer(List<Task> tasks, AddressBook addressBook) {
    return new TaskContainerImpl(tasks, addressBook);
  }

  @Bean
  Task task1() {
    return new CountMalesTask();
  }

  @Bean
  Task task2() {
    return new FindOldestPersonTask();
  }

  @Bean
  Task task3() {
    return new BillAndPaulAgeDiffTask();
  }
}
