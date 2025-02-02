package dev.danvega.graphqlbooks.controller;

import dev.danvega.graphqlbooks.model.BookInput;
import dev.danvega.graphqlbooks.repository.BookRepository;
import dev.danvega.graphqlbooks.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findBook(@Argument Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument Integer pages, @Argument String author) {
        Book book = new Book(title, pages, author);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput book) {
        return bookRepository.save(new Book(book.title(),book.pages(),book.author()));
    }

    @MutationMapping
    public List<Book> batchCreate(@Argument List<BookInput> books) {
        return bookRepository.saveAll(books.stream().map(book -> new Book(book.title(),book.pages(),book.author())).toList());
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument BookInput book) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if(bookToUpdate == null) {
            throw new RuntimeException("Book not found");
        }
        bookToUpdate.setTitle(book.title());
        bookToUpdate.setPages(book.pages());
        bookToUpdate.setAuthor(book.author());
        bookRepository.save(bookToUpdate);
        return bookToUpdate;
    }

    @MutationMapping
    public void deleteBook(@Argument Integer id) {
        bookRepository.deleteById(id);
    }

}
