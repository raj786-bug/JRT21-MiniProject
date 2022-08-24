package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;
import in.ashokit.repo.PlanCategoryRepo;
import in.ashokit.repo.PlanRepo;
@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	

	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		List<PlanCategory> categories= planCategoryRepo.findAll();
		Map<Integer,String> categoryMap=new HashMap<Integer, String>();
		categories.forEach(category->{
			categoryMap.put(category.getCategory_id(),category.getCategory_name());
		});
		
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan saved=planRepo.save(plan);
		
		return saved.getPlan_id() !=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
	
		return planRepo.findAll();
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan save=planRepo.save(plan);
		return save.getPlan_id() !=null;
	}

	

	
	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findbyId=planRepo.findById(planId); 
		if(findbyId.isPresent()) {
			return findbyId.get();
		}
		return null;
	}

	@Override
	public boolean deleteById(Integer planId) {
		boolean status=false;
		// TODO Auto-generated method stub
		try {
		planRepo.deleteById(planId);
		status=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId,String status) {
		// TODO Auto-generated method stub
		Plan plan=new Plan();
		plan.setPlan_id(planId);
		plan.setActive_sw(status);
		return false;
	}

	@Override
	public boolean savePlanCategory(PlanCategory planCategory) {
		// TODO Auto-generated method stub
        PlanCategory savee=planCategoryRepo.save(planCategory);
		
		return savee.getCategory_id() !=null;
		
	}

}
