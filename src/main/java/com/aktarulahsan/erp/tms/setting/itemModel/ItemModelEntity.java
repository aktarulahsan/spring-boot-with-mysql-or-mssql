package com.aktarulahsan.erp.tms.setting.itemModel;

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
@Table(name = "desigen_model")
public class ItemModelEntity extends BaseModel {


//    ID, MODEL_NAME, I_ID, STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

    @Id
    @Column(nullable = false, name = "ID")
    int itemModelId;

    @Column(  name = "MODEL_NAME")
    String modelName;
    @Column(  name = "I_ID")
    int itemId;
    @Column(  name = "STATUS")
    int activeStatus;
}
