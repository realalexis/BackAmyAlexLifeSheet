package org.acme.AmyAlexLifeSheetBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Security layer, Entity isn't handled directly
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeightDto {
    private Long id;
    private int year;
    private int quarter;
    private int month;
    private int week;
    private int day;
    private int hour;
    private int minute;
    private int weight;
}
