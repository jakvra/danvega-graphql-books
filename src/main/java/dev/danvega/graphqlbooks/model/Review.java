package dev.danvega.graphqlbooks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String comment;
    @ManyToOne
    private Book book;

    public Review(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
