package org.acme.AmyAlexLifeSheetBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Weight")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private int month;

    @Column(name = "year")
    private int year;

    @Column(name = "weight")
    private int weight;
}
