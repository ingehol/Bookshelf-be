package dev.ingeb.bookshelf.infrastructure.config;

import dev.ingeb.bookshelf.stores.BookStore;
import dev.ingeb.bookshelf.stores.BookshelfStore;
import dev.ingeb.bookshelf.stores.UserStore;
import org.dalesbred.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"dev.ingeb.bookshelf"})
public class SpringConfiguration {

    @Bean
    public Database database(DataSource dataSource) {
        return new Database(dataSource);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserStore userStore(Database database) {
        return new UserStore(database);
    }

    @Bean
    public BookStore bookStore(Database database) {
        return new BookStore(database);
    }

    @Bean
    public BookshelfStore bookshelfStore(Database database) {
        return new BookshelfStore(database);
    }
}
