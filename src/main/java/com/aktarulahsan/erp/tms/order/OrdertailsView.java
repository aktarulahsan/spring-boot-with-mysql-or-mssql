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
@Table(name = "orderdetailsview")
public class OrdertailsView {
//    ORDERD_NO, CUST_CODE, ORDER_DATE, D_DATE, TOTAL_AMOUNT, ADVANCE_AMOUNT, ORDER_STATUS, I_ID, LOMBA, BUK, PET, HIP, KAD, HATA, GOLA, KAF, MOHORI,
//    GER, KOMOR, HIF, THAI, HAI, KOF_DESIGN, KOLOR_DESIGN, POKET_DESIGN, SELAY_DESIGN, CHAIN_DESIGN, ITEM_PRICE, QTY, ITEM_TOTAL_VAL
//    ORDERM_NO, CUST_CODE, ORDER_DATE, DM, D_DATE, TOTAL_AMOUNT, ORDER_STATUS, COMPANY_ID, BRANCH_ID, I_ID, M_ID, M_NAME, M_VALUE, RATE, QTY, I_TOTAL_AMOUNT

    @Id
    @Column(name = "ORDERD_NO")
    int orderNo;

    @Column(name = "CUST_CODE")
    int customerCode;

    @Column(name = "ORDER_DATE")
    Date orderDate;

    @Column(name = "D_DATE")
    Date deliveryDate;

    @Column(name = "TOTAL_AMOUNT")
    double totalAmount;

    @Column(name = "ADVANCE_AMOUNT")
    double adAmunt;

    @Column(name = "ORDER_STATUS")
    int status;

    @Column(name = "I_ID")
    int i_id;

    @Column(name = "LOMBA")
    double lomba;

    @Column(name = "BUK")
    double buk;

    @Column(name = "PET")
    double pet;

    @Column(name = "HIP")
    double hip;

    @Column(name = "KAD")
    double kad;

    @Column(name = "HATA")
    double hata;

    @Column(name = "GOLA")
    double gola;

    @Column(name = "KAF")
    double kaf;

    @Column(name = "MOHORI")
    double mohori;

    @Column(name = "GER")
    double ger;

    @Column(name = "KOMOR")
    double komor;

    @Column(name = "HIF")
    double hif;

    @Column(name = "THAI")
    double thai;

    @Column(name = "HAI")
    double hai;

    @Column(name = "KOF_DESIGN")
    String kof_design;

    @Column(name = "KOLOR_DESIGN")
    String kolor_design;

//    @Column(name = "BUTTON_DESIGN")
//    String button_design;

    @Column(name = "POKET_DESIGN")
    String poket_design;

    @Column(name = "SELAY_DESIGN")
    String selay_design;

    @Column(name = "CHAIN_DESIGN")
    String chain_design;

    @Column(name = "ITEM_PRICE")
    double item_price;

    @Column(name = "QTY")
    int qty;

    @Column(name = "ITEM_TOTAL_VAL")
    double item_total_val;





}
