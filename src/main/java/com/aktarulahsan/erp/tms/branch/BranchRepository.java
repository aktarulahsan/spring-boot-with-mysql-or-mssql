package com.aktarulahsan.erp.tms.branch;


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
public class BranchRepository extends BaseRepository {

    public Response save(String reqObj) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object pricipal = auth.getPrincipal();
        BranchModel model = objectMapperReadValue(reqObj, BranchModel.class);
//        if (pricipal instanceof User) {
//            model.setSsCreator(((User) pricipal).getUsername());
//        }

        model.setSsModifiedOn(new Date());

        JSONObject json = new JSONObject(reqObj);

        return baseOnlySave(model);
    }

    public Response update(String reqObj) {

        BranchModel  model = objectMapperReadValue(reqObj, BranchModel.class);


        model.setSsCreatedOn(new Date());

        return baseSaveOrUpdate(model);

    }

    public Response delete(String id) {
        if (id == null) {
            return getErrorResponse("Id is blank");
        }

        BranchModel  model = findById(id);

        if (model != null) {
            return baseDelete(model);
        }

        return getErrorResponse("Id not found");
    }

    public BranchModel findById(String id) {

        BranchModel model 	= new BranchModel();
        model.setComId(Integer.parseInt(id));
        Response response = baseFindById(criteriaQuery(model));
        if (response.isSuccess()) {

            return getValueFromObject(response.getObj(), BranchModel.class);
        }
        return null;
    }





    public Response list(String reqObj) {

        BranchModel branchModel = null;
        if (null != reqObj) {
            branchModel = objectMapperReadValue(reqObj, BranchModel.class);
        }
        return baseList(criteriaQuery(branchModel));
    }

    private CriteriaQuery criteriaQuery(BranchModel filter) {
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
    private List<Predicate> criteriaCondition(BranchModel filter, CriteriaBuilder builder, Root<BranchModel> root) {

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
            if (filter.getBranchID() >0) {
                Predicate condition 	= builder.equal(root.get("branchID"), filter.getBranchID());
                p.add(condition);
            }


        }

        return p;
    }

    private void init() {
        initEntityManagerBuilderCriteriaQueryRoot(BranchModel.class);
        CriteriaBuilder builder 	= super.builder;
        CriteriaQuery criteria 		= super.criteria;
        Root root 					= super.root;
    }

}
