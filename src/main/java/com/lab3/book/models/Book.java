package com.lab3.book.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Objects;

/**
 * Book
 */

@Entity
@Table(name = "books")
@JacksonXmlRootElement(localName = "Book")
@JsonRootName("Book")
public class Book {


  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  //@GeneratedValue(strategy= GenerationType.TABLE)
  @JsonProperty("id")
  @JacksonXmlProperty(localName="id")
  private Long id = null;

  @JsonProperty("title")
  @JacksonXmlProperty(localName="title")
  private String title = null;

  @JsonProperty("author")
  @JacksonXmlProperty(localName="author")
  private String author = null;

  @JsonProperty("info")
  @JacksonXmlProperty(localName="info")
  private String info = null;

  @JsonProperty("year")
  @JacksonXmlProperty(localName="year")
  private Long year = null;

  public Book id(Long id) {
    this.id = id;
    return this;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book author(String author) {
    this.author = author;
    return this;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Book info(String info) {
    this.info = info;
    return this;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Book year(Long year) {
    this.year = year;
    return this;
  }

  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) &&
        Objects.equals(this.title, book.title) &&
        Objects.equals(this.author, book.author) &&
        Objects.equals(this.info, book.info) &&
        Objects.equals(this.year, book.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, info, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
