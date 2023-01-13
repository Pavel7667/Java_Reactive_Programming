package org.reactor.assignment.assigmentSix;

import com.github.javafaker.Book;
import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;


@Data
@ToString
public class BookOrder {

    private String title;
    private String author;
    private String category;
    private int price;


    public BookOrder() {
        Book book = Utils.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Utils.faker().random().nextInt(50, 100);

    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    ////////////////




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
