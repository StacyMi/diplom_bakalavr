

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersnils")

public class myTable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="snils")
	private String snils;

	@Column(name="sex")
	private String sex;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="patronymic")
	private String patronymic;
	
	@Column(name="data_b")
	private Date data_b;
	
	public myTable() {}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setSnils(String snils) {
		this.snils = snils;
	}
	public void setData_b(Date data_b) {
		this.data_b = data_b;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return this.id;
	}
	public String getSnils() {
		return this.snils;
	}
	public String getLastname() {
		return this.lastname;
	}
	public String getFirstname() {
		return this.firstname;
	}
	public String getPatronymic() {
		return this.patronymic;
	}
	public Date getData_b() {
		return this.data_b;
	}
	public String getSex() { return this.sex; }
}
