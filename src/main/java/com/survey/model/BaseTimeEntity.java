package com.survey.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    @Column(name = "publish_start", updatable = false)
    private LocalDate publishStart;

    @LastModifiedDate
    @Column(name = "publish_end")
    private LocalDate publishEnd;
}
