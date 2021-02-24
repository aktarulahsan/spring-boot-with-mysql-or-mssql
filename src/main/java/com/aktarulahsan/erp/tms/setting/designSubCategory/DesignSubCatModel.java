package com.aktarulahsan.erp.tms.setting.designSubCategory;

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
@Table(name = "designe_sub_cat")
public class DesignSubCatModel extends BaseModel {

    @Id
    @Column(nullable = false, name = "DS_ID")
    int designSubCategoryId;


    @Column(  name = "MASURMENT_NAME")
    String measurement;

    @Column(  name = "D_ID")
    int designCategoryId;

    @Column(  name = "STATUS")
    int status;

}
