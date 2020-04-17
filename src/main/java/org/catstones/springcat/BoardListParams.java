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
public class BoardListParams {
    @NotEmpty
    private long seq;
    private String boardname;
    private String author;

    @Builder
    public BoardListParams(long seq, String boardname, String author) {
        this.seq = seq;
        this.boardname = boardname;
        this.author = author;
    }
}
