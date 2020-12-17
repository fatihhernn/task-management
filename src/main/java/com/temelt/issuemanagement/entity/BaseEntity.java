package com.temelt.issuemanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data //otomatik olarak getter setter getirir.
@MappedSuperclass //diğer classlarda extend edilebilir hale geliyor.
@Getter @Setter  //bunları propertlerin üstüne de yazabilrdik her birinin
public class BaseEntity implements Serializable {


    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "created_by",length = 100)
    private String createBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Column(name = "updated_by")
    private String updateBy;

    @Column(name = "status")
    private Boolean status;
}
