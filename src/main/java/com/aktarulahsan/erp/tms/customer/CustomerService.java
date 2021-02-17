package com.aktarulahsan.erp.tms.customer;

import com.aktarulahsan.erp.tms.branch.BranchRepository;
import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    public Response list(String reqObj) {
        return repository.list(reqObj);
    }

    public Response save(String reqObj) {
        return repository.save(reqObj);
    }

    public Response update(String reqObj ) {
        return repository.update(reqObj);
    }

    public Response delete(String id) {
        return repository.delete(id);
    }
    public Response findDetailsById(String id) {

        return repository.findDetailsById(id);
    }
}
