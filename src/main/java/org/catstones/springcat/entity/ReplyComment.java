package org.catstones.springcat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.*;

/**
 * 게시판 Entity
 *
 * @author An Nyeong
 */
@Entity
@Getter
@Setter
@Table(name = "reply_comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyComment {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "commentSeq")
    private long comment_seq;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "text")
    private String text;

    @Column(name = "updateTime")
    private Date update_time;

    @Builder
    public ReplyComment(long seq, long comment_seq, String nickname, String text, Date update_time) {
        this.seq = seq;
        this.comment_seq = comment_seq;
        this.nickname = nickname;
        this.text = text;
        this.update_time = update_time;
    }
}

// public Post update(String author, String nickname, String content) {
// this.nickname = nickname;
// this.content = content;
// return this;
// }
