package com.aktarulahsan.erp.tms.order.report;


import com.aktarulahsan.erp.core.reportConfig.reportConfig.CusJasperReportDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderReportService {

    @Autowired
    OrderReportRepository reportRepository;

//    public CusJasperReportDef barcodeListRePrintByInvoiceId(String reqObj) {
//        return reportRepository.demoReport(8888);
//    }
    public CusJasperReportDef demoReport() {

        return reportRepository.demoReport();
    }

}
