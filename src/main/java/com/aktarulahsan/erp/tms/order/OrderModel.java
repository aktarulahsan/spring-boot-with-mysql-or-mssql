//package com.aktarulahsan.erp.tms.order;
//
//
//import com.aktarulahsan.erp.core.base.BaseModel;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "orderm")
//public class OrderModel extends BaseModel {
//
////    ORDERM_NO, CUST_CODE, ORDER_DATE, D_DATE, TOTAL_AMOUNT, DM, ORDER_STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
//
////    ORDERD_NO, CUST_CODE, ORDER_DATE, D_DATE, TOTAL_AMOUNT, ADVANCE_AMOUNT, ORDER_STATUS,
////    WORKER, COMMENTS, COMPANY_ID, BRANCH_ID, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
//    @Id
//    @Column(nullable = false, name = "ORDERM_NO")
//    int orderNo;
//
//    @Column(name = "CUST_CODE")
//    int customerCode;
//
//    @Column(name = "ORDER_DATE")
//    Date orderDate;
//
//    @Column(name = "D_DATE")
//    Date deliveryDate;
//
//    @Column(name = "TOTAL_AMOUNT")
//    double totalAmount;
//
//    @Column(name = "DM")
//    String designModel;
//
//    @Column(name = "ORDER_STATUS")
//    int status;
//
//    @Transient
//    OrderAccountDetailsModel orderAccountDetails;
//
//    @Transient
//    List<OrderDetailsModel> ordermeasurementList;
//
//    @Transient
//    List<OrderAccountDetailsModel> orderAccountDetailsList;
//
//
//}
