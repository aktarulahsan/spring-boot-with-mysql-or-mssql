package com.aktarulahsan.erp.tms.order;


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
@Table(name = "orderview")
public class OrdertailsView {

//    ORDERM_NO, CUST_CODE, ORDER_DATE, DM, D_DATE, TOTAL_AMOUNT, ORDER_STATUS, COMPANY_ID, BRANCH_ID, I_ID, M_ID, M_NAME, M_VALUE, RATE, QTY, I_TOTAL_AMOUNT

    @Id
    @Column(name = "ORDERM_NO")
    int ordermNo;

    @Column(name = "CUST_CODE")
    int customerCode;

    @Column(name = "ORDER_DATE")
    Date orderDate;

    @Column(name = "DM")
    String designModel;

    @Column(name = "D_DATE")
    Date deliveryDate;

    @Column(name = "TOTAL_AMOUNT")
    double totalAmount;

    @Column(name = "ORDER_STATUS")
    int status;

    @Column(name = "COMPANY_ID")
    int companyId;

    @Column(name = "BRANCH_ID")
    int branchId;

    @Column(name = "I_ID")
    int itemId;

    @Column(name = "M_ID")
    int measurementId;

    @Column(name = "M_NAME")
    String measurementName;

    @Column(name = "M_VALUE")
    double measurementValue;

    @Column(name = "RATE")
    double itemRate;

    @Column(name = "QTY")
    int qty;

    @Column(name = "I_TOTAL_AMOUNT")
    double itemTotalAmount;




}
