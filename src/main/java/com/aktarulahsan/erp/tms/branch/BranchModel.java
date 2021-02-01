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

    @Id
    @Column(nullable = false, name = "branchID")
    int branchID;

    @Column(name = "companyID")
    int comId;

    @Column(name = "branchName")
    String bName;


}
