package com.aktarulahsan.erp.tms.branch;


import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "branchname")
public class BranchModel {

//    BRANCH_ID, BRANCH_NAME, COMPANY_ID, STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

    @Id
    @Column(nullable = false, name = "BRANCH_ID")
    int branchID;

    @Column(name = "COMPANY_ID")
    int comId;

    @Column(name = "BRANCH_NAME")
    String bName;

    @Column(name = "STATUS")
    int status;

    @Column(name = "CREATED_BY")
    private String ssCreator;

    @Column(name = "CREATE_DATE")
    private Date ssCreatedOn;


    @Column(name = "UPDATED_BY")
    private String ssModifier;

    @Column(name = "UPDATE_DATE")
    private Date ssModifiedOn;


}
