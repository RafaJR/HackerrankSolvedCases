package codility.cases.cacheassessment;

public interface ArticlesService {

    Article getArticle(Long articleld);
    void removeArticle(Long articleld);
    void saveArticle(Article article) ;
    Article updateLikes(Long articleId, int likes);
}
