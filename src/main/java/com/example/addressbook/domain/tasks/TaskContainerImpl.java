package com.example.addressbook.domain.tasks;

import com.example.addressbook.domain.AddressBook;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskContainerImpl implements TaskContainer {

  private final List<Task> tasks;
  private final AddressBook addressBook;

  @Override
  public List<Task> listTasks() {
    return tasks.stream().sorted(Comparator.comparing(Task::getNumber)).toList();
  }

  @Override
  public Task performTask(int number) {
    var task = tasks.stream().filter(t -> t.getNumber() == number).findFirst().orElseThrow();
    task.perform(addressBook);
    return task;
  }

  @Override
  public List<Task> performTasks() {
    tasks.forEach(t -> t.perform(addressBook));
    return listTasks();
  }
}
