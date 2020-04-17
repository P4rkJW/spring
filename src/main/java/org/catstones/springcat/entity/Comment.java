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
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "boardseq")
    private long boardseq;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "text")
    private String text;

    @Column(name = "updatetime")
    private Date updatetime;

    @Builder
    public Comment(long seq, long boardseq, String nickname, String text, Date updatetime) {
        this.seq = seq;
        this.boardseq = boardseq;
        this.nickname = nickname;
        this.text = text;
        this.updatetime = updatetime;
    }
}

// public Post update(String author, String nickname, String content) {
// this.nickname = nickname;
// this.content = content;
// return this;
// }
