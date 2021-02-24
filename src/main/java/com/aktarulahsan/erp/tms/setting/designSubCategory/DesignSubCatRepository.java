package com.aktarulahsan.erp.tms.setting.designSubCategory;

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
public class DesignSubCatRepository extends BaseRepository {




    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object pricipal = auth.getPrincipal();
        DesignSubCatModel model = objectMapperReadValue(reqObj, DesignSubCatModel.class);
//        if (pricipal instanceof User) {
//            model.setSsCreator(((User) pricipal).getUsername());
//        }

        model.setSsModifiedOn(new Date());

        JSONObject json = new JSONObject(reqObj);

        return baseOnlySave(model);
    }

    public Response update(String reqObj) {

        DesignSubCatModel  model = objectMapperReadValue(reqObj, DesignSubCatModel.class);


        model.setSsModifiedOn(new Date());

        return baseSaveOrUpdate(model);

    }

    public Response delete(String id) {
        if (id == null) {
            return getErrorResponse("Id is blank");
        }

        DesignSubCatModel  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public DesignSubCatModel findById(String id) {

        DesignSubCatModel model 	= new DesignSubCatModel();
        model.setDesignCategoryId(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), DesignSubCatModel.class);
        }
        return null;
    }

    public Response findDetailsById(String id) {
        DesignSubCatModel entity = new DesignSubCatModel();
        entity.setDesignCategoryId(Integer.parseInt(id));
//        roomEntity.setActiveStatus(1);
        return getListFindById(criteriaQuery(entity));
    }



    public Response list(String reqObj) {

        DesignSubCatModel branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, DesignSubCatModel.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(DesignSubCatModel filter) {
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
    private List<Predicate> criteriaCondition(DesignSubCatModel filter, CriteriaBuilder builder, Root<DesignSubCatModel> root) {

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
            if (filter.getDesignSubCategoryId() >0) {
                Predicate condition 	= builder.equal(root.get("designSubCategoryId"), filter.getDesignSubCategoryId());
                p.add(condition);
            }
            if (filter.getDesignCategoryId() >0) {
                Predicate condition 	= builder.equal(root.get("designCategoryId"), filter.getDesignCategoryId());
                p.add(condition);
            }


        }

        return p;
    }

    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(DesignSubCatModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}
