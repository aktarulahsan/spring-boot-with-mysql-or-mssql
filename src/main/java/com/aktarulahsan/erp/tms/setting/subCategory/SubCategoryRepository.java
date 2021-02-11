package com.aktarulahsan.erp.tms.setting.subCategory;

import com.aktarulahsan.erp.core.base.BaseRepository;

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
public class SubCategoryRepository extends BaseRepository {



    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        SubCategoryModel model = objectMapperReadValue(reqObj, SubCategoryModel.class);

        model.setSsModifiedOn(new Date());

        JSONObject json = new JSONObject(reqObj);

        return baseOnlySave(model);
    }

    public Response update(String reqObj) {

        SubCategoryModel  model = objectMapperReadValue(reqObj, SubCategoryModel.class);


        model.setSsCreatedOn(new Date());

        return baseSaveOrUpdate(model);

    }
    public Response findDetailsById(String id) {
        SubCategoryModel entity = new SubCategoryModel();
        entity.setItemId(Integer.parseInt(id));
        return getListFindById(criteriaQuery(entity));
    }

    public Response delete(String id) {
        if (id == null) {
            return getErrorResponse("Id is blank");
        }

        SubCategoryModel  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public SubCategoryModel findById(String id) {

        SubCategoryModel model 	= new SubCategoryModel();
        model.setItemId(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), SubCategoryModel.class);
        }
        return null;
    }





    public Response list(String reqObj) {

        SubCategoryModel branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, SubCategoryModel.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(SubCategoryModel filter) {
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
    private List<Predicate> criteriaCondition(SubCategoryModel filter, CriteriaBuilder builder, Root<SubCategoryModel> root) {

        if (builder == null) {
            builder 		= super.builder;
        }
        if (root == null) {
            root 			= super.root;
        }

        List<Predicate> p 	= new ArrayList<Predicate>();

        if (filter != null) {

//            if (filter.getRoleId() !=null) {
//                Predicate condition 	= builder.equal(root.get("activeStatus"), filter.getRoleId());
//                p.add(condition);
//            }
            if (filter.getItemId() >0) {
                Predicate condition 	= builder.equal(root.get("itemId"), filter.getItemId());
                p.add(condition);
            }


        }

        return p;
    }


    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(SubCategoryModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}
