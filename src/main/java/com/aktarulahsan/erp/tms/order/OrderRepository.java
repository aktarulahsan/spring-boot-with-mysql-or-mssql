package com.aktarulahsan.erp.tms.order;


import com.aktarulahsan.erp.core.base.BaseRepository;

import com.aktarulahsan.erp.tms.order.model.OrderDetailsModels;
import com.aktarulahsan.erp.tms.order.model.OrderMasterModel;
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
//        OrderDetailsModels detailsModel = new OrderDetailsModels();
        List<OrderDetailsModels> orderDetailsModelsList = new ArrayList<>();
//        OrderMasterModel model = objectMapperReadValue(reqObj, OrderMasterModel.class);
        OrderMasterModel model = objectMapperReadValue(reqObj , OrderMasterModel.class);

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


        for (int i = 0; i < model.getDetailsList().size(); i++) {
            OrderDetailsModels detailsModel= model.getDetailsList().get(i);
//            accountDetailsModel.setOrderMaserNo(oidi);
//            accountDetailsModel.setSsCreatedOn(new Date());
//            accountDetailsModel.setItemTotalAmount(accountDetailsModel.getQty()*accountDetailsModel.getItemRate());
//            accountDetailsModel.detailsModel.setOrderd_no(oidi);

            detailsModel.setId(0);
//            detailsModel = model.getDetailsList().get(i);
            detailsModel.setOrderd_no(oidi);
            detailsModel.setCust_code(model.getCustomerCode());
//            detailsModel.setQty(accountDetailsModel.getQty());
//            detailsModel.setItem_total_val(accountDetailsModel.getQty()*accountDetailsModel.getItemRate());
//            detailsModel.setItem_price(accountDetailsModel.getItemRate());
//            Response resp;
//            resp = baseOnlySave(accountDetailsModel);
            Response rs;
            rs = baseOnlySave(detailsModel);
            String p = rs.toString();

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
        OrderMasterModel model = objectMapperReadValue(reqObj, OrderMasterModel.class);
        orderId = model.getOrderNo();
        JSONObject json = new JSONObject(reqObj);

        model.setSsModifiedOn(new Date());

        OrderDetailsModels detailsModel = new OrderDetailsModels();




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


            detailsModel = accountDetailsModel.detailsModel;
            detailsModel.setOrderd_no(orderId);
            detailsModel.setCust_code(model.getCustomerCode());
            detailsModel.setQty(accountDetailsModel.getQty());
            detailsModel.setItem_total_val(accountDetailsModel.getQty()*accountDetailsModel.getItemRate());
            detailsModel.setItem_price(accountDetailsModel.getItemRate());

            Response re;
                re = baseOnlySave(detailsModel);

//            for (int j = 0; j < model.getOrderAccountDetailsList().get(i).getOrdermeasurementList().size(); j++) {
//
//                OrderDetailsModel detailsModel = model.getOrderAccountDetailsList().get(i).getOrdermeasurementList().get(j);
//                detailsModel.setOrderDetailsNo(0);
//                detailsModel.setOrderMaserNo(orderId);
//                accountDetailsModel.setSsCreatedOn(model.getSsCreatedOn());
//                detailsModel.setSsCreatedOn(new Date());
//                Response re;
//                re = baseOnlySave(detailsModel);
//            }
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

        OrderMasterModel  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public Response findOrderByDeliveryStatus(HttpServletRequest request) {
        int cusId = Integer.parseInt(request.getParameter("customerCode"));
        OrderMasterModel entity = new OrderMasterModel();
        entity.setStatus(1);
//        if(cusId !="ADMIN"){
            entity.setCustomerCode(cusId);

//        }

        return getListFindById(criteriaQuery(entity));
    }

    public Response findOrderByCustomerId(String id) {
        OrderMasterModel entity = new OrderMasterModel();
        entity.setCustomerCode(Integer.parseInt(id));
        return getListFindById(criteriaQuery(entity));
    }

    public OrderMasterModel findById(String id) {

        OrderMasterModel model 	= new OrderMasterModel();
        model.setOrderNo(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), OrderMasterModel.class);
        }
        return null;
    }


    public Response findOrderInfo(String id) {
        OrderMasterModel entity = new OrderMasterModel();
        entity.setOrderNo(Integer.parseInt(id));
        return baseFindById(criteriaQuery(entity));
    }




    public Response list(String reqObj) {

        OrderMasterModel branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, OrderMasterModel.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(OrderMasterModel filter) {
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
    private List<Predicate> criteriaCondition(OrderMasterModel filter, CriteriaBuilder builder, Root<OrderMasterModel> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {
//            if (filter.getOrderNo() >0) {
//                Predicate condition 	= builder.equal(root.get("orderNo"), filter.getOrderNo());
//                p.add(condition);
//            }
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
        initEntityManagerBuilderCriteriaQueryRoot(OrderMasterModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}

