package com.aktarulahsan.erp.tms.order.report;

import com.aktarulahsan.erp.core.reportConfig.ReportBaseController;

import com.aktarulahsan.erp.core.reportConfig.reportConfig.CusJasperReportDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/report")
public class OrderReportController extends ReportBaseController {
    @Autowired
    OrderReportService reportService;

//    @PostMapping(value = "/student-rpt")
//    public ResponseEntity<byte[]> barcodeListRePrintByInvoiceId(@RequestBody(required = false) String reqObj) throws IOException {
//        CusJasperReportDef report = reportService.demoReport(785l);
//        return respondReportOutputWithoutHeader(report, false);
//    }


//    @GetMapping(value = "/rolereport")
//    public ResponseEntity<byte[]> appointmentSlip() throws IOException {
//        CusJasperReportDef report = reportService.demoReport();
//        return respondReportOutput(report, false);
//
//    }

    @PostMapping(value = "/rolereport")
    public ResponseEntity<byte[]> test(@RequestBody String reqObj) throws IOException {
        CusJasperReportDef report = reportService.demoReport(reqObj);
        return respondReportOutputWithoutHeader(report, false);
    }

//    @PostMapping(value = "/labelBarcode")
//    public ResponseEntity<byte[]> labelBarcode(@RequestParam("labNos") String[] labNos) throws IOException {
//
//        CusJasperReportDef report = reportService.labelBarcode(labNos);
//        return respondReportOutput(report, false);
//
//    }

}
