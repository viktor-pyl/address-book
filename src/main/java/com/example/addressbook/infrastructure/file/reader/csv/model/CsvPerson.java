package com.example.addressbook.infrastructure.file.reader.csv.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import java.util.Date;
import lombok.Data;

@Data
public class CsvPerson {

  @CsvBindByPosition(position = 0, required = true)
  private String fullName;

  @CsvBindByPosition(position = 1, required = true)
  private String gender;

  @CsvBindByPosition(position = 2, required = true)
  @CsvDate("dd/MM/yyyy")
  private Date dateOfBirth;
}
