package DataAn.fileSystem.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
* Title: DateParameters
* @Description: 某一天的参数列表集合
* @author  Shewp
* @date 2016年8月1日
*/
@Entity
@Table(name = "t_dateParameters")
public class DateParameters {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "year_month_day", nullable = false, length = 32)
	private String year_month_day;
	
	@Lob   
	@Basic(fetch = FetchType.LAZY)   
	@Type(type="text")
	@Column(name = "parameters", nullable = false)
	private String parameters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear_month_day() {
		return year_month_day;
	}

	public void setYear_month_day(String year_month_day) {
		this.year_month_day = year_month_day;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	
}
