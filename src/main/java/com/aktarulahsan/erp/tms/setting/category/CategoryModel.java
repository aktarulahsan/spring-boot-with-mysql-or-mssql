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

//C_ID, C_NAME, STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

    @Id
    @Column(nullable = false, name = "C_ID")
    int categoryId;

    @Column(  name = "C_NAME")
    String cname;

    @Column(  name = "STATUS")
    int status;





}
