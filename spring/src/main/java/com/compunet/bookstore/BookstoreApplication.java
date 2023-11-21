
package com.compunet.bookstore;

import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.IBookService;
import com.compunet.bookstore.services.impl.AuthorService;
import com.compunet.bookstore.services.impl.BookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class    BookstoreApplication {


    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);
        IBookService service = context.getBean("bookService", BookService.class);
        AuthorService authorService = context.getBean("authorService", AuthorService.class);

        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        Author author1 = new Author(1L,"Gabriel Garcia Marquez", "Colombiano");

        Author author2 = new Author(2L,"Arthur Conan Doyle", "Britanico");


        authorService.createAutor(author1);
        authorService.createAutor(author2);



        // burned models
        Book book1 = new Book(1L,"Sherlock Holmes", date1, author2);
        Book book2 = new Book( 2L,"1984", date1, author1);
        Book book3 = new Book(3L,"The Great Gatsby", date1, author1);
        service.save(book1);
        service.save(book2);
        service.save(book3);
    }


}
