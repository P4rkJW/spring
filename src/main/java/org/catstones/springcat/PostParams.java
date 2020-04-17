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
    private String authorSeq;
    private String imgurl;
    private String title;
    private int like;
    private int subscribe;
    private String party;
    private String nickname;
    private long deletecheck;
    private String content;

    @Builder
    public PostParams(long seq, String authorSeq, String imgurl, String title, int like, int subscribe, String party, String nickname, long deletecheck, String content) {
        this.seq = seq;
        this.authorSeq = authorSeq;
        this.imgurl = imgurl;
        this.title = title;
        this.like = like;
        this.subscribe = subscribe;
        this.party = party;
        this.nickname = nickname;
	this.deletecheck = deletecheck;
	this.content = content;
    }
}
