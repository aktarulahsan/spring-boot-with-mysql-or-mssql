package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orderd")
public class OrderDetailsModel extends BaseModel {

//    ORDERD_NO, ORDERM_NO, M_ID, M_NAME, HIGHT, BODY, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

//    ORDERD_NO, ORDERM_NO, M_ID, M_NAME, HIGHT, BODY, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
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

    @Column(name = "DM")
    String designModel;


}

