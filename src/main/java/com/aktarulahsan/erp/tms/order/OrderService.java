package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.tms.order.model.OrderMasterModel;
import com.aktarulahsan.erp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private  OrdertailsRepository orderDetailsService;
    @Autowired
    private OrderAccountDetailsRepository adService;

    @Autowired
    private  OrderDetailsViewRepository viewRepository;


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

    public Response findOrderByCustomerId(String id) {

        return repository.findOrderByCustomerId(id);
    }
    public Response findMesurementByOrderid(String id) {

        return orderDetailsService.findMesurementByOrderid(id);
    }

    public Response findAccountInfoByOrderid(String id) {

        return adService.findAccountInfoByOrderid(id);
    }
    public Response  findOrderDetailsByOrderid(String id) {

        return orderDetailsService.findDetailsById(id);
    }

    public Response findViewByOrderid(String id) {

        return viewRepository.findAccountInfoByOrderid(id);
    }


    public Response findAccountInfoByOrderidandItemId(String reqObj) {
        return orderDetailsService.findAccountInfoByOrderidandItemId(reqObj);
    }

    public OrderMasterModel findById(String id) {

        return repository.findById(id);
    }

    public Response findl3Id(String id) {

        return repository.findOrderInfo(id);
    }


}
