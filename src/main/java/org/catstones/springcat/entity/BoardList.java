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
@Table(name = "boardlist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardList {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    // @Column(name = "list_seq")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private long listSeq;

    @Column(name = "boardname")
    private String boardname;

    @Column(name = "author")
    private String author;

    @Builder
    public BoardList(long seq, long listSeq, String boardname, String author) {
        this.seq = seq;
        // this.listSeq = listSeq;
        this.boardname = boardname;
        this.author = author;
    }
}

// public Post update(String author, String nickname, String content) {
// this.nickname = nickname;
// this.content = content;
// return this;
// }
