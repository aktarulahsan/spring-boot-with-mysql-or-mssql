package com.aktarulahsan.erp.tms.setting.measurement;


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
@Table(name = "measurement")
public class MeasurementModel extends BaseModel {

//    M_ID, I_ID, M_NAME, STATUS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

    @Id
    @Column(nullable = false, name = "M_ID")
    int measurementId;

    @Column(  name = "I_ID")
    int itemId;

    @Column(  name = "M_NAME")
    String measurementName;

    @Column(  name = "STATUS")
    int status;



}
