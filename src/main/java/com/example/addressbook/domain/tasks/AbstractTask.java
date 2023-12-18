package com.example.addressbook.domain.tasks;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTask implements Task {

  private final int number;
  private final String title;
  protected String result;

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public int getNumber() {
    return number;
  }

  @Override
  public String getResult() {
    return result;
  }
}
