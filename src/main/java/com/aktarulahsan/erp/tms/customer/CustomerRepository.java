package com.aktarulahsan.erp.tms.customer;


import com.aktarulahsan.erp.core.base.BaseRepository;
import com.aktarulahsan.erp.tms.branch.BranchModel;
import com.aktarulahsan.erp.tms.setting.measurement.MeasurementModel;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository extends BaseRepository {


    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object pricipal = auth.getPrincipal();
        CustomerModel model = objectMapperReadValue(reqObj, CustomerModel.class);


        model.setSsModifiedOn(new Date());

        JSONObject json = new JSONObject(reqObj);

        return baseOnlySave(model);
    }

    public Response update(String reqObj) {

        CustomerModel  model = objectMapperReadValue(reqObj, CustomerModel.class);


        model.setSsCreatedOn(new Date());

        return baseSaveOrUpdate(model);

    }

    public Response delete(String id) {
        if (id == null) {
            return getErrorResponse("Id is blank");
        }

        CustomerModel  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public CustomerModel findById(String id) {

        CustomerModel model 	= new CustomerModel();
        model.setCusId(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), CustomerModel.class);
        }
        return null;
    }
    public Response findDetailsById(String id) {
        CustomerModel entity = new CustomerModel();
        entity.setCusId(Integer.parseInt(id));
        return baseFindById(criteriaQuery(entity));
    }




    public Response list(String reqObj) {

        CustomerModel branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, CustomerModel.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(CustomerModel filter) {
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
    private List<Predicate> criteriaCondition(CustomerModel filter, CriteriaBuilder builder, Root<CustomerModel> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {


            if (filter.getCusId() >0) {
                Predicate condition 	= builder.equal(root.get("cusId"), filter.getCusId());
                p.add(condition);
            }


        }

        return p;
    }

    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(CustomerModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}
