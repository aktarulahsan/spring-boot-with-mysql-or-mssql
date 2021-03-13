package com.aktarulahsan.erp.tms.order.model;

import com.aktarulahsan.erp.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "orderdetils")
public class OrderDetailsModels {
//
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "ID")
    int id;

    @Column(name = "ORDERD_NO")
    int orderd_no;

    @Column(name = "CUST_CODE")
    int cust_code;

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

    @Column(name = "BUTTON_DESIGN")
    String button_design;

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

    @Column(name = "D_DATE")
    Date d_date;

    @Column(name = "COMMENTS")
    String  comments;



}
