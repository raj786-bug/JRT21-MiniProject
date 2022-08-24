package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="PLAN_CATEGORY")
@Data
public class PlanCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORY_ID")
	private Integer category_id;
	@Column(name="CATEGORY_NAME")
	private String category_name;
	@Column(name="ACTIVE_SW")
	private String active_sw;
	@Column(name="CREATE_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate create_date;
	@Column(name="UPDATE_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updated_date;
	@Column(name="CREATED_BY")
	private String created_by;
	@Column(name="UPDATED_BY")
	private String updated_by;


}
