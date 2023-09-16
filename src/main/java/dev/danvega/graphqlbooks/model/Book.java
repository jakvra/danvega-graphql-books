package dev.danvega.graphqlbooks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Integer pages;
    private String author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "book_id")
    private List<Review> reviews;

    public Book(String title, Integer pages, String author) {
        this.title = title;
        this.pages = pages;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
