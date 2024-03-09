 package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = findBookById(id);
        model.addAttribute("book", book);
        return "book/detail";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        book.setId(generateUniqueId());
        books.add(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = findBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute Book updatedBook) {
        Book existingBook = findBookById(id);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setPrice(updatedBook.getPrice());
        }
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book bookToRemove = findBookById(id);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
        return "redirect:/books";
    }

    private Book findBookById(Long id) {
        return books.stream()
                .filter(book -> id.equals(book.getId()))
                .findFirst()
                .orElse(null);
    }

    private Long generateUniqueId() {
        return System.currentTimeMillis();
    }
}
