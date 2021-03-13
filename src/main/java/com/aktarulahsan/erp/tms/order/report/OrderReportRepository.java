package com.aktarulahsan.erp.tms.order.report;


import com.aktarulahsan.erp.core.base.BaseRepository;
import com.aktarulahsan.erp.core.reportConfig.reportConfig.CoreJasperService;
import com.aktarulahsan.erp.core.reportConfig.reportConfig.CusJasperReportDef;
import com.aktarulahsan.erp.tms.order.*;
import com.aktarulahsan.erp.tms.order.model.OrderMasterModel;
import com.aktarulahsan.erp.util.CommonFunction;
import com.aktarulahsan.erp.util.Response;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import java.util.List;

@Repository
@Transactional
public class OrderReportRepository extends BaseRepository {
    @Autowired
    CoreJasperService coreJasperService;

    @Autowired
    OrderRepository repository;

    @Autowired
    OrdertailsRepository drepository;
    @Autowired
    OrderDetailsViewRepository viewRepository;


    public CusJasperReportDef demoReport(String reqObj) {

        OrderReportDato demoDto = new OrderReportDato();
        List<OrderReportDato> demoList = new ArrayList<>();


        List<OrdertailsView> orderList = new ArrayList<>();
        OrderMasterModel model = objectMapperReadValue(reqObj , OrderMasterModel.class);

//        demoDto.setPatientname("Mohammad Galib");
//        demoDto.setRank("Maj.");
//        demoDto.setAge("27Y");
//        demoDto.setCompanyName("Global  IT");
//        demoDto.setCompanyAddress("Mirpur 10, Dhaka");
//        demoDto.setGShear("0");

//        OrderMasterModel model = new OrderMasterModel();
        model =  repository.findById(String.valueOf(model.getOrderNo()));
        OrderAccountDetailsModel orderAccountDetailsModel = new OrderAccountDetailsModel();

        Response res= drepository.findMesurementByOrderid(String.valueOf(model.getOrderNo()));

//        model.setOrderDetailsModelsList(res.getItems());
        Response rs = viewRepository.findAccountInfoByOrderid(String.valueOf(model.getOrderNo()));

//        demoDto.setOrderNo(model.getOrderNo());
//        demoDto.setCustomerCode(model.getCustomerCode());
//        demoDto.setTotalAmount(model.getTotalAmount());

        orderList= rs.getItems();

//        BaseFont unicode = BaseFont.createFont("c:/windows/fonts/NikoshBan.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//        Font font = new Font(unicode);

        CusJasperReportDef report = new CusJasperReportDef();
        report.setOutputFilename("demo");
        report.setReportName("orderdetailsReport");
        report.setReportDir(CommonFunction.getResoucePath("/report/order") + "/");
        report.setReportFormat(CommonFunction.printFormat("PDF"));


        report.setReportData(orderList);



        ByteArrayOutputStream baos = null;

        try {
            baos = coreJasperService.generateReport(report);
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            finallyOutputStream(baos);
        }
        report.setContent(baos.toByteArray());

        return report;
    }

}
