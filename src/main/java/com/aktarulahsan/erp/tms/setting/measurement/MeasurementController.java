package com.aktarulahsan.erp.tms.setting.measurement;


import com.aktarulahsan.erp.tms.setting.category.CategoryService;
import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tms/measurement")
public class MeasurementController {


    @Autowired
    MeasurementService service;


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
    public Response delete(@RequestParam("measurementId") String reqId) {
        return service.delete(reqId);
    }


    @GetMapping("/findDetailsById")
    public Response findDetailsById(@RequestParam("itemId") String id) {
        return service.findDetailsById(id);
    }


}
