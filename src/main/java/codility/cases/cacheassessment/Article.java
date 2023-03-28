package codility.cases.cacheassessment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Article {

    private Long articleId;
    private String contents;
    private int likes;

}