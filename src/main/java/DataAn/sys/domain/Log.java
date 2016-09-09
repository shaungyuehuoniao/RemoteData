package DataAn.sys.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_log")
public class Log implements java.io.Serializable{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "logId", unique = true, nullable = false)
	private long logId;
	@Column(name = "userName", length = 32)
	private String userName;
	@Column(name = "userIp", length = 15)
	private String userIp;
	@Column(name = "title", length = 256)
	private String title;
	@Column(name = "content", nullable = false, length = 1000)
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", nullable = true)
	private Date createDate;
	
	public long getLogId() {
		return logId;
	}
	public void setLogId(long logId) {
		this.logId = logId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
