
package com.compunet.bookstore;

import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.IBookService;
import com.compunet.bookstore.services.impl.AuthorService;
import com.compunet.bookstore.services.impl.BookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class    BookstoreApplication {


    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);
    }


}
