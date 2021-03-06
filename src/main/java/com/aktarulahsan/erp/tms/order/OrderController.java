package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/tms/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/list")
    public Response getAll(@RequestBody(required = false) String reqObj) {
        return service.list(reqObj);
    }

    @PostMapping("/create")
    public Response create(@RequestBody String reqObj) {

        return service.save(reqObj);
    }

    @PutMapping("/update")
    public Response update(@RequestBody String reqObj) {
        return service.update(reqObj);
    }


    @DeleteMapping("/delete")
    public Response delete(@RequestParam("l1Code") String reqId) {
        return service.delete(reqId);
    }




    @GetMapping("/orderList")
    public Response findOrderByDeliveryStatus(HttpServletRequest request) {
        return service.orderList(request);
    }


    @GetMapping("/findOrderByCustomerId")
    public Response findDetailsById(@RequestParam("customerCode") String id) {
        return service.findOrderByCustomerId(id);
    }

    @GetMapping("/findMesurementByOrderid")
    public Response findMesurementByOrderid(@RequestParam("orderId") String id) {
        return service.findMesurementByOrderid(id);
    }

    @GetMapping("/findAccountInfoByOrderid")
    public Response findAccountInfoByOrderid(@RequestParam("orderId") String id) {
        return service.findAccountInfoByOrderid(id);
    }

    @PostMapping("/findAccountInfoByOrderidandItemId")
    public Response findAccountInfoByOrderidandItemId(@RequestBody String reqObj) {

        return service.findAccountInfoByOrderidandItemId(reqObj);
    }
    @GetMapping("/findOrderDetailsByOrderid")
    public Response findOrderDetailsByOrderid(@RequestParam("orderId") String id) {
        return service.findOrderDetailsByOrderid(id);
    }



//    @GetMapping("/findById")
//    public OrderModel findById(@RequestParam("orderId") String id) {
//        return service.findById(id);
//    }
@GetMapping("/findById")
public Response findById(@RequestParam String id) {
    return service.findl3Id(id);
}



    @GetMapping("/findViewByOrderid")
    public Response findViewByOrderid(@RequestParam("orderId") String id) {
        return service.findViewByOrderid(id);
    }


}
