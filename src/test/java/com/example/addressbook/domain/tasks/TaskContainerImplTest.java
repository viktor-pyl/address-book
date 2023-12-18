package com.example.addressbook.domain.tasks;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import com.example.addressbook.domain.AddressBook;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskContainerImplTest {

  private AddressBook addressBook;
  private Task tasks1;
  private Task tasks2;
  private List<Task> tasks;
  private TaskContainerImpl tested;

  @BeforeEach
  void setUp() {
    addressBook = mock(AddressBook.class);
    tasks1 = mock(Task.class);
    tasks2 = mock(Task.class);
    tasks = new ArrayList<>();
    tasks.add(tasks1);
    tasks.add(tasks2);
    tested = new TaskContainerImpl(tasks, addressBook);
  }

  @Test
  void shouldReturnTasksInCorrectOrder() {
    // given
    given(tasks1.getNumber()).willReturn(10);
    given(tasks2.getNumber()).willReturn(8);

    // when
    var listedTasks = tested.listTasks();

    // then
    var correctOrderTasks = new ArrayList<>();
    correctOrderTasks.add(tasks2);
    correctOrderTasks.add(tasks1);
    Assertions.assertEquals(listedTasks, correctOrderTasks);
  }

  @Test
  void shouldPerformTask() {
    // given
    var taskNum = 10;
    given(tasks1.getNumber()).willReturn(taskNum);

    // when
    tested.performTask(taskNum);

    // then
    verify(tasks1, times(1)).perform(addressBook);
  }

  @Test
  void whenTaskNotFound_thenThrowException() {
    // given
    var taskNum = 10;
    given(tasks1.getNumber()).willReturn(taskNum);

    assertThrows(NoSuchElementException.class, () -> tested.performTask(2));
    verify(tasks1, times(0)).perform(addressBook);
  }

  @Test
  void shouldPerformAllTasks() {
    // when
    tested.performTasks();

    // then
    verify(tasks1, times(1)).perform(addressBook);
    verify(tasks2, times(1)).perform(addressBook);
  }
}
