package org.catstones.springcat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

/**
 * 게시판 Entity
 *
 * @author An Nyeong
 */
@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @Column(name = "board_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "author_seq")
    private long authorSeq;

    @Column(name = "img_url")
    private String imgurl;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_contents")
    private String content;

    @Column(name = "board_like")
    private int like;

    @Column(name = "board_subscribe")
    private int subscribe;

    @Column(name = "party")
    private String party;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "board_delete_check")
    private long deletecheck;

    @Builder
    public Post(long seq, String  listSeq, String imgurl, String title, int like, int subscribe, String party, String nickname, long deletecheck, String content) {
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

    // public Post update(String author, String title, String content) {
    // this.title = title;
    // this.content = content;
    // return this;
    // }
}
