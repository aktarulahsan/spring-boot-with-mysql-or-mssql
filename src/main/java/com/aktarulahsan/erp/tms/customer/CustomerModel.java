package com.aktarulahsan.erp.tms.customer;

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
@Table(name = "customerinfo")
public class CustomerModel extends BaseModel {



    //    CUST_CODE, CUST_NAME, GENDER, MOBILE_NUMBER, ADDRESS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
//    CUST_CODE, COMPANY_ID, BRANCH_ID, CUST_NAME, GENDER, MOBILE_NUMBER, ADDRESS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE
//    CUST_CODE, CUST_NAME, GENDER, MOBILE_NUMBER, ADDRESS, CREATED_BY, CREATE_DATE, UPDATED_BY, UPDATE_DATE

    @Id
    @Column(nullable = false, name = "CUST_CODE")
    int cusId;

//    @Column(name = "COMPANY_ID")
//    String companyId;

//    @Column(name = "BRANCH_ID")
//    String branchId;

    @Column(name = "CUST_NAME")
    String customerName;

    @Column(name = "GENDER")
    String gender;

    @Column(name = "MOBILE_NUMBER")
    String mobile;

    @Column(name = "ADDRESS")
    String address;



}
