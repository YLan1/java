package com.lhzs.springbootdemo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score", schema = "test", catalog = "")
public class ScoreModel {
    private int id;
    private Double mathe;
    private Double english;
    private Double chainese;
    private Integer studentId;


    public ScoreModel() {

    }

    public ScoreModel(int id, Double mathe, Double english) {
        this.id = id;
        this.mathe = mathe;
        this.english = english;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mathe")
    public Double getMathe() {
        return mathe;
    }

    public void setMathe(Double mathe) {
        this.mathe = mathe;
    }

    @Basic
    @Column(name = "english")
    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    @Basic
    @Column(name = "chainese")
    public Double getChainese() {
        return chainese;
    }

    public void setChainese(Double chainese) {
        this.chainese = chainese;
    }

    @Basic
    @Column(name = "student_id")
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "ScoreModel{" +
                "id=" + id +
                ", mathe=" + mathe +
                ", english=" + english +
                ", chainese=" + chainese +
                ", studentId=" + studentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreModel that = (ScoreModel) o;
        return id == that.id &&
                Objects.equals(mathe, that.mathe) &&
                Objects.equals(english, that.english) &&
                Objects.equals(chainese, that.chainese) &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mathe, english, chainese, studentId);
    }
}
