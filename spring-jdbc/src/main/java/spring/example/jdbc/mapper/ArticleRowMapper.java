package spring.example.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import spring.example.jdbc.domain.Article;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet resultSet, int i) throws SQLException {
        Article article = new Article();
        article.setId(resultSet.getInt("id"));
        article.setText(resultSet.getString("text"));
        article.setTitle(resultSet.getString("title"));
        article.setAuthor(resultSet.getString("title"));
        article.setDateCreated(resultSet.getDate("date_created"));
        return article;
    }
}