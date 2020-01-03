package org.catstones.springcat.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * createdAt과 updatedAt을 갖는 기본 Entity 클래스.
 *
 * @author An Nyeong
 *
 */
@Getter
@MappedSuperclass // 자식 클래스로 매핑 정보를 상속하겠다는 의미
@EntityListeners(AuditingEntityListener.class) // created, modified를 다룸
public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
