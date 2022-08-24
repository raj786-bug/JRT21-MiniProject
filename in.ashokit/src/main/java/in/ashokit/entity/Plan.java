package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="PLAN_MASTER")
@Data
public class Plan {
	
	@Id
	@GeneratedValue
	@Column(name="Plan_ID")
	private Integer plan_id;
	@Column(name="Plan_Name")
	private String plan_name;
	
	@Column(name="Plan_StartDate")
	@CreationTimestamp
	private LocalDate plan_start_date;
	@CreationTimestamp
	@Column(name="Plan_EndDate")
	private LocalDate plan_end_date;
	@Column(name="PlanCategory")
	private int plan_category_id;
	@Column(name="Plan_Active_SW")
	private String active_sw;
	
	@Column(name="Create_Date")
	@CreationTimestamp
	private LocalDate create_date;
	@Column(name="Update_Date")
	@UpdateTimestamp
	private LocalDate update_date;
	@Column(name="Created_By")
	private String created_by;
	@Column(name="Updated_By")
	private String updated_by;


}
