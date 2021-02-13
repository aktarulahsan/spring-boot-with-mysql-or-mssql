package com.aktarulahsan.erp.tms.setting.subCategory;



import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tms/subCategory")
public class SubCategoryController {


    @Autowired
    SubCategoryService service;


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
    public Response findorderById(@RequestParam("categoryId") String id) {
        return service.findDetailsById(id);
    }
    @GetMapping("/findByCategoryId")
    public Response findByCategoryId(@RequestParam("categoryId") String id) {
        return service.findByCategoryId(id);
    }


}
