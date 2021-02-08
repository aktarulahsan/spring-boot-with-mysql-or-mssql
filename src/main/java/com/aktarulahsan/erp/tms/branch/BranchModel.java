package com.aktarulahsan.erp.tms.branch;


import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "branchname")
public class BranchModel extends BaseModel {

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


}
