package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by BluePrints Developer on 22-05-2017.
 */
@Entity
@Table(name = "ABM_TEMPORIZADOR")
public class Timer extends BaseEntity implements Serializable {

    private Long id;
    private String year;
    private String month;
    private String day;
    private String dayOfWeek;
    private String hour;
    private String minute;
    private String second;
    private List<String> days;
    private List<String> months;
    private Date parsedDate;

    public Timer() {
    }

    public Timer(Long id, String year, String month, String day, String dayOfWeek, String hour, String minute, String second, List<String> days, List<String> months, Date parsedDate) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.days = days;
        this.months = months;
        this.parsedDate = parsedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AGNO")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "MES")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Basic
    @Column(name = "DIA")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Basic
    @Column(name = "DIA_SEMANA")
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Basic
    @Column(name = "HORA")
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Transient
    public Date getDateHour() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.parse(this.getHour());
    }

    @Transient
    public Date getParsedDate() {
        return parsedDate;
    }

    public void setParsedDate(Date parsedDate) {
        this.parsedDate = parsedDate;
    }

    @Basic
    @Column(name = "MINUTO")
    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    @Basic
    @Column(name = "SEGUNDO")
    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Transient
    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    @Transient
    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }
}