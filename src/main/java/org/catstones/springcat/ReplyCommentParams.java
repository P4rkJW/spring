package org.catstones.springcat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import lombok.*;

/**
 * @author An Nyeong
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyCommentParams {
    @NotEmpty
    private long seq;
    private long comment_seq;
    private String nickname;
    private String text;
    private Date update_time;

    @Builder
    public ReplyCommentParams(long seq, long comment_seq, String nickname, String text, Date update_time) {
        this.seq = seq;
        this.comment_seq = comment_seq;
        this.nickname = nickname;
        this.text = text;
        this.update_time = update_time;
    }
}