package com.example.addressbook.domain.model;

import java.util.Date;

public record Person(String firstName, String lastName, Gender gender, Date dateOfBirth) {

  public String getFullName() {
    return (lastName != null && !lastName.isBlank()) ? firstName + " " + lastName : firstName();
  }
}
