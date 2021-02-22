package com.aktarulahsan.erp.tms.order;

import com.aktarulahsan.erp.core.base.BaseRepository;
import com.aktarulahsan.erp.util.Response;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class OrderAccountDetailsRepository   extends BaseRepository {

    ArrayList<OrderAccountDetailsModel> list = new ArrayList<OrderAccountDetailsModel>();
    public Response delete(int id) {
        if (id ==0) {
            return getErrorResponse("Id is blank");
        }

        Response  res = findDetailsById(String.valueOf(id));

        if(res.isSuccess()){
            list = (ArrayList<OrderAccountDetailsModel>) res.getItems();
            for (int i = 0; i < list.size(); i++) {
                baseDelete(list.get(i));
            }
            return res;
        }

        return getErrorResponse("Id not found");
    }

    public Response findDetailsById(String id) {
        OrderAccountDetailsModel entity = new OrderAccountDetailsModel();
        entity.setOrderMaserNo(Integer.parseInt(id));
//        roomEntity.setActiveStatus(1);
        return getListFindById(criteriaQuery(entity));
    }

//    public Response delete(String id) {
//        if (id == null) {
//            return getErrorResponse("Id is blank");
//        }
//
//        OrderAccountDetailsModel  model = findById(id);
//
//        if (model != null) {
//            return baseDelete(model);
//        }
//
//        return getErrorResponse("Id not found");
//    }

//    public Response findOrderByDeliveryStatus(HttpServletRequest request) {
//        int cusId = Integer.parseInt(request.getParameter("customerCode"));
//        OrderAccountDetailsModel entity = new OrderAccountDetailsModel();
//        entity.setStatus(1);
////        if(cusId !="ADMIN"){
//        entity.setCustomerCode(cusId);
//
////        }
//
//        return getListFindById(criteriaQuery(entity));
//    }

    public Response findAccountInfoByOrderid(String id) {
        OrderAccountDetailsModel entity = new OrderAccountDetailsModel();
        entity.setOrderMaserNo(Integer.parseInt(id));
        return getListFindById(criteriaQuery(entity));
    }

    public OrderAccountDetailsModel findById(String id) {

        OrderAccountDetailsModel model 	= new OrderAccountDetailsModel();
        model.setOrderMaserNo(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), OrderAccountDetailsModel.class);
        }
        return null;
    }





    public Response list(String reqObj) {

        OrderAccountDetailsModel model = null;
        if (null != reqObj) {
            model = objectMapperReadValue(reqObj, OrderAccountDetailsModel.class);
        }
        return baseList(criteriaQuery(model));
    }

    private CriteriaQuery criteriaQuery(OrderAccountDetailsModel filter) {
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
    private List<Predicate> criteriaCondition(OrderAccountDetailsModel filter, CriteriaBuilder builder, Root<OrderAccountDetailsModel> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {
            if (filter.getOrderMaserNo() >0) {
                Predicate condition 	= builder.equal(root.get("orderMaserNo"), filter.getOrderMaserNo());
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
        initEntityManagerBuilderCriteriaQueryRoot(OrderAccountDetailsModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }
}
