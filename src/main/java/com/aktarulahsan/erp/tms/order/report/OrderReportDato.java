package com.aktarulahsan.erp.tms.order.report;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Setter
@Getter
public class OrderReportDato {


    int orderNo;
    int customerCode;
    Date orderDate;

    Date deliveryDate;
    double totalAmount;

}
