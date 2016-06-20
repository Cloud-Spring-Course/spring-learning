package spring.example.jdbc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.example.jdbc.domain.Article;

import java.time.LocalDateTime;
import java.util.Date;

public class MainJDBC {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        ArticleDAO articleDAO = context.getBean(ArticleDAO.class);
        fillData(articleDAO);

        // List all articles
        System.out.println("All articles");
        articleDAO.getAll().forEach(System.out::println);

        // Get article by id
        Article first = articleDAO.getAll()
                .stream().findFirst().get();
        System.out.println("Get article by id = " + first.getId());
        System.out.println(articleDAO.get(first.getId()));

        // Delete article
        articleDAO.delete(first);

        // List
        System.out.println("All articles after deletion");
        articleDAO.getAll().forEach(System.out::println);

        context.close();
    }

    public static void fillData(ArticleDAO articleDAO) {
        Article article1 = new Article();
        article1.setAuthor("ivan.petrov@google.com");
        article1.setDateCreated(new Date());
        article1.setText("This is my article");
        article1.setTitle("First article");
        articleDAO.insertNew(article1);

        Article article2 = new Article();
        article2.setAuthor("petr.sidorov@google.com");
        article2.setDateCreated(new Date());
        article2.setText("I am good man");
        article2.setTitle("About me");
        articleDAO.insertNew(article2);
    }
}