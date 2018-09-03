import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class myTable3 {
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
    private java.sql.Date data_b;

    @Column(name="data_create")
    private java.sql.Date data_create;

    @Column(name="ok")
    private Boolean ok;

    public myTable3() {}

    public void setId(int id) {
        this.id = id;
    }
    public void setSnils(String snils) {
        this.snils = snils;
    }
    public void setData_b(java.sql.Date data_b) {
        this.data_b = data_b;
    }
    public void setData_create(java.sql.Date data_create) {
        this.data_create = data_create;
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
    public void setOk(Boolean ok) {this.ok = ok; }

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
    public java.sql.Date getData_b() {
        return this.data_b;
    }
    public java.sql.Date getData_create() {
        return this.data_create;
    }
    public String getSex() { return this.sex; }
    public Boolean getOk() { return this.ok;}
}
