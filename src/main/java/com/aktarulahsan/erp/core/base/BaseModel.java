package com.aktarulahsan.erp.core.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract public class BaseModel {

    @Column( name = "COMPANY_ID")
    int companyId;

    @Column( name = "BRANCH_ID")
    int branchId;

    @Column(name = "CREATED_BY")
    private String ssCreator;

    @Column(name = "CREATE_DATE")
    private Date ssCreatedOn;


    @Column(name = "UPDATED_BY")
    private String ssModifier;

    @Column(name = "UPDATE_DATE")
    private Date ssModifiedOn;

}
