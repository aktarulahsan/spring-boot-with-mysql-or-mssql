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


}
