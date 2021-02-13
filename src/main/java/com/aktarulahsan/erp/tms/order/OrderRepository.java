package com.aktarulahsan.erp.tms.order;


import com.aktarulahsan.erp.core.base.BaseRepository;
import com.aktarulahsan.erp.tms.customer.CustomerModel;
import com.aktarulahsan.erp.util.Response;
import org.json.JSONObject;
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

    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object pricipal = auth.getPrincipal();
        OrderModel model = objectMapperReadValue(reqObj, OrderModel.class);


        model.setSsModifiedOn(new Date());

        JSONObject json = new JSONObject(reqObj);

        return baseOnlySave(model);
    }

    public Response update(String reqObj) {

        OrderModel  model = objectMapperReadValue(reqObj, OrderModel.class);


        model.setSsCreatedOn(new Date());

        return baseSaveOrUpdate(model);

    }

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
        String ssCreator = request.getParameter("ssCreator");
        OrderModel entity = new OrderModel();
        entity.setStatus(1);
        if(ssCreator !="ADMIN"){
            entity.setSsCreator(ssCreator);

        }

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

