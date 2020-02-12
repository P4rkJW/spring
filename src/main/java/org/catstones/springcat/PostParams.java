package org.catstones.springcat;

import javax.validation.constraints.NotEmpty;

import lombok.*;

/**
 * @author An Nyeong
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostParams {
    @NotEmpty
    private long seq;
    private String file;
    private String title;
    private int oppose;
    private int recommand;
    private String content;


    @Builder
    public PostParams(long seq, String file, String title, int oppose, int recommand, String content) {
        this.seq = seq;
        this.file = file;
        this.title = title;
        this.oppose = oppose;
        this.recommand = recommand;
        this.content = content;
    }
}
