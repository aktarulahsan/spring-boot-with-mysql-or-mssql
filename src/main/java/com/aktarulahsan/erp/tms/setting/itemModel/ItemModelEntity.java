package com.aktarulahsan.erp.tms.setting.itemModel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "items_model")
public class ItemModelEntity {


//    ID, MODEL_NAME, I_ID, STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

    @Id
    @Column(nullable = false, name = "ID")
    int categoryId;

    @Column(  name = "MODEL_NAME")
    String modelName;
    @Column(  name = "I_ID")
    int itemId;
    @Column(  name = "STATUS")
    int activeStatus;
}
