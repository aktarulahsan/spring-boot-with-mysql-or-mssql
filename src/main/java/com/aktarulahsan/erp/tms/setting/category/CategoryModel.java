package com.aktarulahsan.erp.tms.setting.category;

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
@Table(name = "category")
public class CategoryModel extends BaseModel {



    @Id
    @Column(nullable = false, name = "C_ID")
    int cusId;


    @Column( name = "C_NAME")
    String cusName;

    @Column( name = "STATUS")
    int status;








}
