package com.example.addressbook.domain.tasks;

import java.util.List;

public interface TaskContainer {

  List<Task> listTasks();

  Task performTask(int number);

  List<Task> performTasks();
}
