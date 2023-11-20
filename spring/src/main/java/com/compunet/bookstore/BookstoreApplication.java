
package com.compunet.bookstore;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.IBookService;
import com.compunet.bookstore.services.impl.AutorService;
import com.compunet.bookstore.services.impl.BookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class    BookstoreApplication {


    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);
        IBookService service = context.getBean("bookService", BookService.class);
        AutorService authorService = context.getBean("autorService", AutorService.class);

        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        Autor autor1 = new Autor(1L,"Gabriel Garcia Marquez", "Colombiano");

        Autor autor2 = new Autor(2L,"Arthur Conan Doyle", "Britanico");


        authorService.createAutor(autor1);
        authorService.createAutor(autor2);



        // burned models
        Book book1 = new Book(1L,"Sherlock Holmes", date1, autor2);
        Book book2 = new Book( 2L,"1984", date1, autor1);
        Book book3 = new Book(3L,"The Great Gatsby", date1, autor1);
        service.save(book1);
        service.save(book2);
        service.save(book3);
    }


}
