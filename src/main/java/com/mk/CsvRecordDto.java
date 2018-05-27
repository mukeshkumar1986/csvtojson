package com.mk;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CsvRecordDto {

  private String id;
  private String firstName;
  private String lastName;
  private Integer rating1;
  private Integer rating2;
  private Integer rating3;
}
