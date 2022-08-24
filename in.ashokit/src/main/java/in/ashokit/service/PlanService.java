package in.ashokit.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;


public interface PlanService {
	// Integer is id as key and String for plan category as value
	public Map<Integer,String> getPlanCategories();
	public boolean savePlan(Plan plan);
	public boolean savePlanCategory(PlanCategory planCategory);
	public List<Plan> getAllPlans();
	public Plan getPlanById(Integer planId);
    public boolean updatePlan(Plan plan);
    public boolean deleteById(Integer planId);
    public boolean planStatusChange(Integer planId,String status);
    
	
	

}
