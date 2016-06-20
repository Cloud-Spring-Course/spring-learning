package spring.example.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import spring.example.jdbc.domain.Article;
import spring.example.jdbc.mapper.ArticleRowMapper;

import java.util.List;

@Service
public class ArticleDAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public void insertNew(Article article) {
        jdbcTemplate.update("INSERT INTO article (title, text, author, date_created) " +
            "VALUES (?, ?, ?, ?)", article.getTitle(), article.getText(), article.getAuthor(), article.getDateCreated());
    }

    public List<Article> getAll() {
        return jdbcTemplate.query("SELECT * FROM article", new ArticleRowMapper());
    }

    public Article get(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new Object[] { id }, new ArticleRowMapper());
    }

    public void delete(Article article) {
        jdbcTemplate.update("DELETE FROM article WHERE id=?", article.getId());
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}