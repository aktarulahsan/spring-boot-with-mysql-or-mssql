package com.aktarulahsan.erp.tms.setting.designcategory;

import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "designe_cat")
public class DesignCategoryModel extends BaseModel {
//    ID, DESIGNE, STATUS, COMPANY_ID, BRANCH_ID, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE


    @Id
    @Column(nullable = false, name = "D_ID")
    int designCategoryId;

    @Column(  name = "DESIGNE")
    String desingName;

    @Column(  name = "STATUS")
    int satatus;


    @Transient
    int designSubCategoryId;




}
