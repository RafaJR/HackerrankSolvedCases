package codility.cases.cacheassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachedArticlesService implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;
    private final String idCache = "articles";
    private final String articlesCacheKey = "#articleId";

    private final Cache articlesCache;

    @Autowired
    public CachedArticlesService(ArticlesRepository articlesRepository, CacheManager cacheManager) {
        this.articlesRepository = articlesRepository;
        this.articlesCache = cacheManager.getCache(idCache);
    }

    @Override
    @Cacheable(value = idCache, key = articlesCacheKey)
    public Article getArticle(Long articleId) {
        return articlesRepository.get(articleId);
    }

    @Override
    @CacheEvict(value = idCache, key = articlesCacheKey)
    public void removeArticle(Long articleId) {
        articlesRepository.remove(articleId);
    }

    @Override
    public void saveArticle(Article article) {
        articlesRepository.save(article);
    }

    @Override
    @CacheEvict(value = idCache, key = articlesCacheKey)
    public Article updateLikes(Long articleId, int likes) {
        Article article = articlesRepository.updateLikes(articleId, likes);
        if (article != null) {
            // Actualizar el artículo en la caché
            articlesCache.put(articleId, article);
        }
        return article;
    }
}
