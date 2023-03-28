package codility.cases.cacheassessment;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArticlesRepository {

    private List<Article> listArticles = Stream.of(Article.builder()
                            .articleId(1l)
                            .contents(String.format("Contents for article '%s'.", String.valueOf(1l)))
                            .likes(1)
                            .build(),
                    Article.builder()
                            .articleId(2l)
                            .contents(String.format("Contents for article '%s'.", String.valueOf(2l)))
                            .likes(2)
                            .build(),
                    Article.builder()
                            .articleId(3l)
                            .contents(String.format("Contents for article '%s'.", String.valueOf(3l)))
                            .likes(3)
                            .build()
            )
            .collect(Collectors.toList());

    public void save(Article article) {
        listArticles.add(article);
    }

    public Article get(Long articleId) {

        Optional<Article> optArticle = listArticles.parallelStream().filter(article -> article.getArticleId().equals(articleId)).findFirst();

        return optArticle.isPresent() ? optArticle.get() : null;
    }

    public void remove(Long articleId) {

        Article article = this.get(articleId);

        if(article != null) {
            listArticles.remove(article);
        }

    }

    public Article updateLikes(Long articleId, int likes){

        Article article = this.get(articleId);

        if(article != null) {

            listArticles.remove(article);
            article.setLikes(likes);
            listArticles.add(article);

        }

        return article;
    }
}
