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
@Table(name = "Hobbies")
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private int year;

    @Column(name = "quarter")
    private int quarter;

    @Column(name = "month")
    private int month;

    @Column(name = "week")
    private int week;

    @Column(name = "day")
    private int day;

    @Column(name = "hour")
    private int hour;

    @Column(name = "minute")
    private int minute;

    @Column(name = "data")
    private String data;
}
