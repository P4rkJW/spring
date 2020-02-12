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
public class Post{
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "file")
    private String file;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "recommand")
    private int recommand;

    @Column(name = "oppose")
    private int oppose;

    @Builder
    public Post(long seq, String file, String title, int oppose, int recommand, String content) {
        this.seq = seq;
        this.file = file;
        this.title = title;
        this.oppose = oppose;
        this.recommand = recommand;
        this.content = content;
    }

//    public Post update(String author, String title, String content) {
//        this.title = title;
//        this.content = content;
//        return this;
//    }
}
