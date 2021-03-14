package com.aktarulahsan.erp.tms.customer;


import com.aktarulahsan.erp.tms.branch.BranchService;
import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tms/customer")
public class CustomerController {

    @Autowired
    CustomerService service;


    @GetMapping("/list")
    public Response getAlluser(@RequestBody(required = false) String reqObj) {
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
    public Response delete(@RequestParam("cusId") String reqId) {
        return service.delete(reqId);
    }

    @GetMapping("/findById")
    public Response findDetailsById(@RequestParam("mobile") String id) {
        return service.findDetailsById(id);
    }
}
