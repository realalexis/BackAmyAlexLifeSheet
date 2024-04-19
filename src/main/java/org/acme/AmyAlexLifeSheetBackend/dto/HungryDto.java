package org.acme.AmyAlexLifeSheetBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HungryDto {
    private Long id;
    private String day;
    private String month;
    private String key;
}
