package org.catstones.springcat;

import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author An Nyeong
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostParams {
    @NotEmpty
    private String author;

    private String title;

    private String content;

    @Builder
    public PostParams(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
