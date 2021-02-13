package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


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

    public Response orderList( HttpServletRequest reqObj ) {
        return repository.findOrderByDeliveryStatus(reqObj);

    }
}
