package com.example.addressbook;

import com.example.addressbook.domain.tasks.Task;
import com.example.addressbook.domain.tasks.TaskContainer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class AddressBookApplication implements ApplicationRunner {

  public static void main(String[] args) {
    SpringApplication.run(AddressBookApplication.class, args);
  }

  private final TaskContainer taskContainer;

  @Override
  public void run(ApplicationArguments args) {
    var filePaths = args.getOptionValues(AddressBookApplication.CommandLineConstants.FILE_PATH);
    if (filePaths != null && !filePaths.isEmpty()) {
      taskContainer.performTasks().forEach(AddressBookApplication::printTaskToConsole);
    } else {
      System.err.println("Pass correct arguments");
      printUsage();
      System.exit(1);
    }
  }

  private static void printTaskToConsole(Task task) {
    System.out.printf("%d. %s%n", task.getNumber(), task.getTitle());
    if (task.getResult() != null) {
      System.out.println(task.getResult());
    }
  }

  private static void printUsage() {
    System.out.printf(
        "Usage: java -jar address-book.jar [--%s=<file path>]%n", CommandLineConstants.FILE_PATH);
  }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static final class CommandLineConstants {
    public static final String FILE_PATH = "filePath";
  }
}
