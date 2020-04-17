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
public class CommentParams {
    @NotEmpty
    private long seq;
    private long boardseq;
    private String nickname;
    private String text;
    private Date updatetime;

    @Builder
    public CommentParams(long seq, long boardseq, String nickname, String text, Date updatetime) {
        this.seq = seq;
        this.boardseq = boardseq;
        this.nickname = nickname;
        this.text = text;
        this.updatetime = updatetime;
    }
}