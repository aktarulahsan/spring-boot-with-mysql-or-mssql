package com.aktarulahsan.erp.tms.setting.itemModel;


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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ItemModelRepository  extends BaseRepository {

    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object pricipal = auth.getPrincipal();
        ItemModelEntity model = objectMapperReadValue(reqObj, ItemModelEntity.class);


        model.setSsModifiedOn(new Date());

        JSONObject json = new JSONObject(reqObj);

        return baseOnlySave(model);
    }

    public Response update(String reqObj) {

        ItemModelEntity  model = objectMapperReadValue(reqObj, ItemModelEntity.class);


        model.setSsCreatedOn(new Date());

        return baseSaveOrUpdate(model);

    }

    public Response delete(String id) {
        if (id == null) {
            return getErrorResponse("Id is blank");
        }

        ItemModelEntity  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public ItemModelEntity findById(String id) {

        ItemModelEntity model 	= new ItemModelEntity();
        model.setItemModelId(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), ItemModelEntity.class);
        }
        return null;
    }





    public Response list(String reqObj) {

        ItemModelEntity branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, ItemModelEntity.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(ItemModelEntity filter) {
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
    private List<Predicate> criteriaCondition(ItemModelEntity filter, CriteriaBuilder builder, Root<ItemModelEntity> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {


            if (filter.getItemModelId() >0) {
                Predicate condition 	= builder.equal(root.get("itemModelId"), filter.getItemModelId());
                p.add(condition);
            }


        }

        return p;
    }

    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(ItemModelEntity.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}

