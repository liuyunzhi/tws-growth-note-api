package cn.thoughtworks.school.growthnoteapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String content;

    @JsonIgnore
    private static final String DATE_FORMAT = "yyyy/MM/dd";

    public void setDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
        }
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(this.date);
    }

    public void updateDiary(String date, String content) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
        }
        this.content = content;
    }
}
