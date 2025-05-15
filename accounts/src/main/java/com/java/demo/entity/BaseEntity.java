package com.java.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createAt;

    @Column(insertable = false)
    private LocalDateTime updateAt;

    @Column(updatable = false)
    private String createBy;

    @Column(insertable = false)
    private String updateBy;
}
