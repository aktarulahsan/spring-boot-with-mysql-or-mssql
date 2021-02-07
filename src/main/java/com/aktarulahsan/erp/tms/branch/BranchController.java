package com.aktarulahsan.erp.tms.branch;

import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tms/branch")
public class BranchController {

    @Autowired
    BranchService service;


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
    public Response delete(@RequestParam("branchID") String reqId) {
        return service.delete(reqId);
    }
}
