package com.mk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvToJsonSample {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static void main(String[] args) throws Exception {

    ColumnPositionMappingStrategy<CsvRecordDto> beanStrategy = new
        ColumnPositionMappingStrategy<CsvRecordDto>();
    beanStrategy.setType(CsvRecordDto.class);
    beanStrategy.setColumnMapping(
        new String[]{"id", "firstName", "lastName", "rating1", "rating2", "rating3"});
    CSVReader reader = new CSVReaderBuilder(
        new InputStreamReader(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("sample_csv.csv")))
        .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
        .withSkipLines(1)
        .build();
    CsvToBean<CsvRecordDto> csvToBean = new CsvToBean<CsvRecordDto>();
    csvToBean.setMappingStrategy(beanStrategy);
    csvToBean.setCsvReader(reader);
    List<CsvRecordDto> csvRecordDtos = csvToBean.parse();

    List<JsonDto> jsonDtos = csvRecordDtos.stream()
        .map(csvRecordDto -> {
              NameDto name = NameDto.builder()
                  .first(csvRecordDto.getFirstName())
                  .last(csvRecordDto.getFirstName())
                  .build();
              List<Integer> ratings = new ArrayList<>();
              ratings.add(csvRecordDto.getRating1());
              ratings.add(csvRecordDto.getRating2());
              ratings.add(csvRecordDto.getRating3());
              return JsonDto.builder().id(csvRecordDto.getId()).name(name).rating(ratings).build();
            }
        ).collect(Collectors.<JsonDto>toList());
    String jsonDtoStr = OBJECT_MAPPER.writeValueAsString(jsonDtos);
    System.out.println(jsonDtoStr);

  }

}