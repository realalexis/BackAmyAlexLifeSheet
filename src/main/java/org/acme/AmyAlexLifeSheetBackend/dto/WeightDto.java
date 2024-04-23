package org.acme.AmyAlexLifeSheetBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeightDto {
    private Long id;
    private int day;
    private int month;
    private int year;
    private int weight;
}
