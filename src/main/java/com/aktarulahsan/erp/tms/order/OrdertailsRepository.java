package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.core.base.BaseRepository;
import com.aktarulahsan.erp.tms.order.model.OrderDetailsModels;
import com.aktarulahsan.erp.util.Response;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class OrdertailsRepository  extends BaseRepository {

    ArrayList<OrderDetailsModels> list = new ArrayList<OrderDetailsModels>();
    public Response delete(int id) {
        if (id ==0) {
            return getErrorResponse("Id is blank");
        }

        Response  res = findDetailsById(String.valueOf(id));

        if(res.isSuccess()){
            list = (ArrayList<OrderDetailsModels>) res.getItems();
            for (int i = 0; i < list.size(); i++) {
                baseDelete(list.get(i));
            }
            return res;
        }

        return getErrorResponse("Id not found");
    }

    public Response findDetailsById(String id) {
        OrderDetailsModels entity = new OrderDetailsModels();
        entity.setOrderd_no(Integer.parseInt(id));
//        roomEntity.setActiveStatus(1);
        return getListFindById(criteriaQuery(entity));
    }

//    public Response findOrderByDeliveryStatus(HttpServletRequest request) {
//        int cusId = Integer.parseInt(request.getParameter("customerCode"));
//        OrderDetailsModels entity = new OrderDetailsModels();
//        entity.setStatus(1);
////        if(cusId !="ADMIN"){
//        entity.setCustomerCode(cusId);
//
////        }
//
//        return getListFindById(criteriaQuery(entity));
//    }

    public Response findMesurementByOrderid(String id) {
        OrderDetailsModels entity = new OrderDetailsModels();
        entity.setOrderd_no(Integer.parseInt(id));
        return getListFindById(criteriaQuery(entity));
    }

    public Response findAccountInfoByOrderidandItemId(String reqObj) {
        Response res = new Response();
        JSONArray detailsList = new JSONArray();
        String message = "";

        OrderAccountDetailsModel model = objectMapperReadValue(reqObj, OrderAccountDetailsModel.class);
        OrderDetailsModels entity = new OrderDetailsModels();
        entity.setOrderd_no(model.getOrderMaserNo());
        entity.setI_id(model.getItemId());


        return baseFindById(criteriaQuery(entity));

//        return getListFindById(criteriaQuery(entity));
    }

//    public OrderDetailsModels findByorderId(int id) {
//
//        OrderDetailsModels model 	= new OrderDetailsModels();
//        model.setOrderd_no(id);
//        Response response = baseFindById(criteriaQuery(model));
//        if (response.isSuccess()) {
//
//            return getValueFromObject(response.getObj(), OrderDetailsModels.class);
//        }
//        return null;
//    }

    public OrderDetailsModels findById(int id) {

        OrderDetailsModels model 	= new OrderDetailsModels();
        model.setOrderd_no(id);
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), OrderDetailsModels.class);
        }
        return null;
    }





    public Response list(String reqObj) {

        OrderDetailsModels branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, OrderDetailsModels.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(OrderDetailsModels filter) {
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
    private List<Predicate> criteriaCondition(OrderDetailsModels filter, CriteriaBuilder builder, Root<OrderDetailsModels> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {
            if (filter.getOrderd_no() >0) {
                Predicate condition 	= builder.equal(root.get("orderd_no"), filter.getOrderd_no());
                p.add(condition);
            }
            if (filter.getI_id() >0) {
                Predicate condition 	= builder.equal(root.get("i_id"), filter.getI_id());
                p.add(condition);
            }
//            if (filter.ge() >0) {
//                Predicate condition 	= builder.equal(root.get("customerCode"), filter.getCustomerCode());
//                p.add(condition);
//            }

//            if (filter.getOrderNo() >0) {
//                Predicate condition 	= builder.equal(root.get("orderNo"), filter.getOrderNo());
//                p.add(condition);
//            }


        }

        return p;
    }

    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(OrderDetailsModels.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}
