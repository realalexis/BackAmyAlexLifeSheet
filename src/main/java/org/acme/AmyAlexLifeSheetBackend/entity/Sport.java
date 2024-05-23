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
@Table(name = "Sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year_month")
    private int yearMonth;

    @Column(name = "year_week")
    private int yearWeek;

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

    @Column(name = "command")
    private String command;
    @Column(name = "reason")
    private String reason;
}
