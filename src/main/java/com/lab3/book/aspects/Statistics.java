package com.lab3.book.aspects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Statistics")
@JacksonXmlRootElement(localName = "Statistics")
@JsonRootName("Statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("id")
    @JacksonXmlProperty(localName="id")
    private Long id;

    @JsonProperty("method")
    @JacksonXmlProperty(localName="method")
    private String method;

    @JsonProperty("classname")
    @JacksonXmlProperty(localName="classname")
    private String classname;

    @JsonProperty("number")
    @JacksonXmlProperty(localName="number")
    private int number;

    public Statistics() {
    }

    public Statistics(String classname, String method, int number) {
        this.method = method;
        this.classname = classname;
        this.number = number;
    }

    public Statistics(String classname, String method) {
        this.method = method;
        this.classname = classname;
        this.number = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics s = (Statistics) o;
        return Objects.equals(this.id, s.id) &&
                Objects.equals(this.classname, s.classname) &&
                Objects.equals(this.method, s.method) &&
                Objects.equals(this.number, s.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classname,method, number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Statistics {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    classname: ").append(toIndentedString(classname)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
