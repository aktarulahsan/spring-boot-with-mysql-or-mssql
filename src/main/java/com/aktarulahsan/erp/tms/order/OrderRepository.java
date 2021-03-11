package com.aktarulahsan.erp.tms.order;


import com.aktarulahsan.erp.core.base.BaseRepository;

import com.aktarulahsan.erp.tms.customer.CustomerModel;
import com.aktarulahsan.erp.util.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class OrderRepository extends BaseRepository {


    @Autowired
    private OrdertailsRepository detailsRepository;

    @Autowired
    private OrderAccountDetailsRepository accountDetailsRepository;


    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = auth.getPrincipal();


        Response res = new Response();
        JSONArray detailsList = new JSONArray();
        String message = "";

        OrderModel model = objectMapperReadValue(reqObj, OrderModel.class);

        JSONObject json = new JSONObject(reqObj);


        Date dte=new Date();
        long orderId = dte.getTime();
        long pssss = orderId;
        String oid = String.valueOf(orderId).substring(4,13);
        int oidi= Integer.parseInt(oid);

        model.setOrderNo(oidi);
//        model.orderAccountDetails.setOrderMaserNo(oidi);
        OrderDetailsModel orderDetailsModel =new OrderDetailsModel();
        res = baseOnlySave(model);


        for (int i = 0; i < model.getOrderAccountDetailsList().size(); i++) {
            OrderAccountDetailsModel accountDetailsModel= model.getOrderAccountDetailsList().get(i);
            accountDetailsModel.setOrderMaserNo(oidi);
            accountDetailsModel.setSsCreatedOn(new Date());
            accountDetailsModel.detailsModel.setOrderd_no(oidi);

            Response resp;
            resp = baseOnlySave(accountDetailsModel);
            Response rs;
            rs = baseOnlySave(accountDetailsModel.detailsModel);

//            for (int j = 0; j < model.getOrderAccountDetailsList().get(i).getOrdermeasurementList().size(); j++) {
//
//                OrderDetailsModel detailsModel = model.getOrderAccountDetailsList().get(i).getOrdermeasurementList().get(j);
//                detailsModel.setOrderMaserNo(oidi);
//                detailsModel.setSsCreatedOn(new Date());
//                Response re;
//                re = baseOnlySave(detailsModel);
//            }
        }


        return res;
    }

    public Response update(String reqObj) {

        Response res = new Response();
        JSONArray detailsList = new JSONArray();
        String message = "";
        int orderId;
        OrderModel model = objectMapperReadValue(reqObj, OrderModel.class);
        orderId = model.getOrderNo();
        JSONObject json = new JSONObject(reqObj);

        model.setSsModifiedOn(new Date());






        res = baseSaveOrUpdate(model);
//                baseOnlySave(model);
        Response dres = detailsRepository.findDetailsById(String.valueOf(orderId));

       if(dres !=null){
           Response ds = detailsRepository.delete(orderId);
           String a = "0";
       }
        Response ps = accountDetailsRepository.findDetailsById(String.valueOf(orderId));
        if(ps !=null){
            Response ds = accountDetailsRepository.delete(orderId);
            String a = "0";
        }

        for (int i = 0; i < model.getOrderAccountDetailsList().size(); i++) {
            OrderAccountDetailsModel accountDetailsModel= model.getOrderAccountDetailsList().get(i);
            accountDetailsModel.setAid(0);
            accountDetailsModel.setOrderMaserNo(orderId);
            accountDetailsModel.setSsCreatedOn(model.getSsCreatedOn());
            accountDetailsModel.setSsCreatedOn(new Date());


            Response resp;
            resp = baseOnlySave(accountDetailsModel);
            for (int j = 0; j < model.getOrderAccountDetailsList().get(i).getOrdermeasurementList().size(); j++) {

                OrderDetailsModel detailsModel = model.getOrderAccountDetailsList().get(i).getOrdermeasurementList().get(j);
                detailsModel.setOrderDetailsNo(0);
                detailsModel.setOrderMaserNo(orderId);
                accountDetailsModel.setSsCreatedOn(model.getSsCreatedOn());
                detailsModel.setSsCreatedOn(new Date());
                Response re;
                re = baseOnlySave(detailsModel);
            }
        }


        return res;



    }

//    public Response deleteAllWithoutItemNo(Long consultationNo) {
//        Connection con = null;
//        ResultSet rs = null;
//        PreparedStatement pstm = null;
//        con = getOraConnection();
//
//        try {
//
//            pstm = con.prepareStatement(integrationStatement.deleteAllInvestigationDataWithOutItemNo());
//            pstm.setLong(1, consultationNo); // OPD_CONSULTATION_NO
//            pstm.executeUpdate();
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            finalyConPstmRs(con, pstm, rs);
//
//        }
//
//        return getSuccessResponse("delete Successfully");
//    }



    public Response delete(String id) {
        if (id == null) {
            return getErrorResponse("Id is blank");
        }

        OrderModel  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public Response findOrderByDeliveryStatus(HttpServletRequest request) {
        int cusId = Integer.parseInt(request.getParameter("customerCode"));
        OrderModel entity = new OrderModel();
        entity.setStatus(1);
//        if(cusId !="ADMIN"){
            entity.setCustomerCode(cusId);

//        }

        return getListFindById(criteriaQuery(entity));
    }

    public Response findOrderByCustomerId(String id) {
        OrderModel entity = new OrderModel();
        entity.setCustomerCode(Integer.parseInt(id));
        return getListFindById(criteriaQuery(entity));
    }

    public OrderModel findById(String id) {

        OrderModel model 	= new OrderModel();
        model.setOrderNo(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), OrderModel.class);
        }
        return null;
    }


    public Response findOrderInfo(String id) {
        OrderModel entity = new OrderModel();
        entity.setOrderNo(Integer.parseInt(id));
        return baseFindById(criteriaQuery(entity));
    }




    public Response list(String reqObj) {

        OrderModel branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, OrderModel.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(OrderModel filter) {
        init();

        List<Predicate> p 	= new ArrayList<Predicate>();
        p = criteriaCondition(filter, null, null);

        if (!CollectionUtils.isEmpty(p)) {
            Predicate[] pArray 	= p.toArray(new Predicate[] {});
            Predicate predicate = builder.and(pArray);
            criteria.where(predicate);
        }
        return criteria;
    }
    private List<Predicate> criteriaCondition(OrderModel filter, CriteriaBuilder builder, Root<OrderModel> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {
            if (filter.getOrderNo() >0) {
                Predicate condition 	= builder.equal(root.get("customerCode"), filter.getOrderNo());
                p.add(condition);
            }
            if (filter.getCustomerCode() >0) {
                Predicate condition 	= builder.equal(root.get("customerCode"), filter.getCustomerCode());
                p.add(condition);
            }

            if (filter.getOrderNo() >0) {
                Predicate condition 	= builder.equal(root.get("orderNo"), filter.getOrderNo());
                p.add(condition);
            }


        }

        return p;
    }

    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(OrderModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}

