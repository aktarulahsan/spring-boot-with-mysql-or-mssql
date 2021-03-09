package com.aktarulahsan.erp.tms.order.report;


import com.aktarulahsan.erp.core.base.BaseRepository;
import com.aktarulahsan.erp.core.reportConfig.reportConfig.CoreJasperService;
import com.aktarulahsan.erp.core.reportConfig.reportConfig.CusJasperReportDef;
import com.aktarulahsan.erp.tms.order.OrderModel;
import com.aktarulahsan.erp.tms.order.OrderRepository;
import com.aktarulahsan.erp.util.CommonFunction;
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




    public CusJasperReportDef demoReport() {

        OrderReportDato demoDto = new OrderReportDato();
        List<OrderReportDato> demoList = new ArrayList<>();

//        demoDto.setPatientname("Mohammad Galib");
//        demoDto.setRank("Maj.");
//        demoDto.setAge("27Y");
//        demoDto.setCompanyName("Global  IT");
//        demoDto.setCompanyAddress("Mirpur 10, Dhaka");
//        demoDto.setGShear("0");

        OrderModel model = new OrderModel();
        model =  repository.findById("992309731");


        demoDto.setOrderNo(454545);
        demoDto.setCustomerCode(101);
        demoDto.setTotalAmount(500.0);

        demoList.add(demoDto);

        CusJasperReportDef report = new CusJasperReportDef();
        report.setOutputFilename("demo");
        report.setReportName("ordersp");
        report.setReportDir(CommonFunction.getResoucePath("/report/order") + "/");
        report.setReportFormat(CommonFunction.printFormat("PDF"));
        report.setReportData(demoList);

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
