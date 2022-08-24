package in.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;
import in.ashokit.service.PlanService;


@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategories(){
		Map<Integer, String> categories=planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
		
	}
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String responseMsg="";
		boolean isSaved=planService.savePlan(plan);
		if(isSaved) {
			responseMsg="Plan Saved";
		}
		else {
			responseMsg="Plan not saved";
			
		}
	  return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	@PostMapping("/category")
	public ResponseEntity<String> savePlan(@RequestBody PlanCategory planCategory){
		String responseMsg="";
		boolean isSaved=planService.savePlanCategory(planCategory);
		if(isSaved) {
			responseMsg="Category Saved";
		}
		else {
			responseMsg="Category not saved";
			
		}
	  return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allplans=planService.getAllPlans();
		return new ResponseEntity<>(allplans,HttpStatus.OK);
		
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan=planService.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
		
	}
	@GetMapping("/planCategory/{planCategoryId}")
	public ResponseEntity<Plan> editPlans(@PathVariable Integer planCategoryId){
		Plan planCategory=planService.getPlanById(planCategoryId);
		return new ResponseEntity<>(planCategory,HttpStatus.OK);
		
	}
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted=planService.deleteById(planId);
		String msg="";
		if(isDeleted) {
			msg="Plan Deleted";
		}
		else {
			msg="Plan Not Deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		String Msg="";
		boolean isUpdated=planService.updatePlan(plan);
		if(isUpdated) {
			Msg="Plan Updated";
		}
		else {
			Msg="Plan not Updated";
			
		}
	  return new ResponseEntity<>(Msg,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
		String msg="";
		boolean isStatusChanged=planService.planStatusChange(planId,status);
		if(isStatusChanged) {
			msg="Status Changed";
		}
		else {
			msg="Status not changed";
			
		}
	  return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	

}
