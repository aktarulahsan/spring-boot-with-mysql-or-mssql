package com.aktarulahsan.erp.tms.setting.subCategory;

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
@Table(name = "item_info")
public class SubCategoryModel extends BaseModel {

//I_ID, C_ID, ITEM_NAME, ITEM_AMOUNT, STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE


    @Id
    @Column(nullable = false, name = "I_ID")
    int itemID;

    @Column(name = "C_ID")
    int categoryId;

    @Column(name = "ITEM_NAME")
    String itemName;

    @Column(name = "ITEM_AMOUNT")
    int itemAmount;

    @Column(name = "STATUS")
    int status;


}
