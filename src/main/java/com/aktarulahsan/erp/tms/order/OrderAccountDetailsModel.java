package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "orderad")
public class OrderAccountDetailsModel extends BaseModel {
//    ORDERAD_NO, ORDERM_NO, ITEMS_CODE, RA1TE, QTY, I_TOTAL_AMOUNT, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
//    ORDERAD_NO, ORDERM_NO, I_ID, RATE, QTY, I_TOTAL_AMOUNT, COMPANY_ID, BRANCH_ID, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE, DM
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(nullable = false, name = "ORDERAD_NO")
    int aid;

    @Column(name = "ORDERM_NO")
    int orderMaserNo;

    @Column(name = "I_ID")
    int itemId;


    @Column(name = "ITEM_NAME")
    String itemName;


    @Column(name = "RATE")
    double itemRate;

    @Column(name = "QTY")
    int qty;

    @Column(name = "I_TOTAL_AMOUNT")
    double itemTotalAmount;

    @Column(name = "DM")
    String designModel;

    @Transient
    List<OrderDetailsModel> ordermeasurementList;
    @Transient
    OrderDetailsModels detailsModel;

}
