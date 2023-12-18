package com.example.addressbook.domain.tasks;

import java.util.List;

/** Operations related to listing and running tasks */
public interface TaskContainer {

  /**
   * Lists tasks that can be performed
   *
   * @return the list of all available tasks
   */
  List<Task> listTasks();

  /**
   * Finds task by task number and performs it
   *
   * @param number the number of task that should be performed
   * @return performed task
   */
  Task performTask(int number);

  /**
   * Iterates through available tasks and performs them
   *
   * @return performed tasks
   */
  List<Task> performTasks();
}
