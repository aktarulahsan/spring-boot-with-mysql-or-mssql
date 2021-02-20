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
public class OrderDetailsViewRepository extends BaseRepository {



    public Response findAccountInfoByOrderid(String id) {
        OrdertailsView entity = new OrdertailsView();
        entity.setOrdermNo(Integer.parseInt(id));
        return getListFindById(criteriaQuery(entity));
    }

    public OrdertailsView findById(String id) {

        OrdertailsView model 	= new OrdertailsView();
        model.setOrdermNo(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), OrdertailsView.class);
        }
        return null;
    }





    public Response list(String reqObj) {

        OrdertailsView model = null;
        if (null != reqObj) {
            model = objectMapperReadValue(reqObj, OrdertailsView.class);
        }
        return baseList(criteriaQuery(model));
    }

    private CriteriaQuery criteriaQuery(OrdertailsView filter) {
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
    private List<Predicate> criteriaCondition(OrdertailsView filter, CriteriaBuilder builder, Root<OrdertailsView> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {
            if (filter.getOrdermNo() >0) {
                Predicate condition 	= builder.equal(root.get("orderMaserNo"), filter.getOrdermNo());
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
        initEntityManagerBuilderCriteriaQueryRoot(OrdertailsView.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }
}
