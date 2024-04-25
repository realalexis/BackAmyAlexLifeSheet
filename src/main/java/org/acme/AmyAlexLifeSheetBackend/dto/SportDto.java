package org.acme.AmyAlexLifeSheetBackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportDto {
    private Long id;
    private int year_month;
    private int year_week;
    private int year;
    private int month;
    private int quarter;
    private int week;
    private int day;
    private int hour;
    private int minute;
    private String command;
    private String reason;
}