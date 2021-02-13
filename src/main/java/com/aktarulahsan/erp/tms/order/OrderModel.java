package com.aktarulahsan.erp.tms.order;


import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orderm")
public class OrderModel extends BaseModel {

//    ORDERM_NO, CUST_CODE, ORDER_DATE, D_DATE, TOTAL_AMOUNT, DM, ORDER_STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE


    @Id
    @Column(nullable = false, name = "ORDERM_NO")
    int orderNo;

    @Column(name = "CUST_CODE")
    int customerCode;
    @Column(name = "ORDER_DATE")
    Date orderDate;

    @Column(name = "D_DATE")
    Date deliveryDate;

    @Column(name = "TOTAL_AMOUNT")
    double totalAmount;

    @Column(name = "DM")
    String designModel;

    @Column(name = "ORDER_STATUS")
    int status;



}
