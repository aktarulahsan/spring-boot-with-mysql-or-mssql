package com.aktarulahsan.erp.tms.order;

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
@Table(name = "orderd")
public class OrderDetailsModel extends BaseModel {

//    ORDERD_NO, ORDERM_NO, M_ID, M_NAME, HIGHT, BODY, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

//    ORDERD_NO, ORDERM_NO, M_ID, M_NAME, HIGHT, BODY, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
    @Id
    @Column(nullable = false, name = "ORDERD_NO")
    int orderDetailsNo;

    @Column(name = "ORDERM_NO")
    int orderMaserNo;

    @Column(name = "M_ID")
    int measurementId;

    @Column(name = "M_NAME")
    String measurementName;

    @Column(name = "M_VALUE")
    double measurementValue;


}

