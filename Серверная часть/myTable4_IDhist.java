import javax.persistence.*;

@Entity
@Table(name = "idhist")
public class myTable4_IDhist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;

    @Column(name="lastname")
    private String lastname;

    @Column(name="firstname")
    private String firstname;

    @Column(name="patronymic")
    private String patronymic;

    @Column(name="idhist")
    private String idhist;

    @Column(name="data_create")
    private java.sql.Date data_create;

    public myTable4_IDhist() {}

    public void setId(int id) {
        this.id = id;
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
    public void setData_create(java.sql.Date data_create) {
        this.data_create = data_create;
    }
    public void setIdhist(String idhist) {
        this.idhist = idhist;
    }

    public int getId() {
        return this.id;
    }
    public String getLastname() { return this.lastname; }
    public String getFirstname() {
        return this.firstname;
    }
    public String getPatronymic() {
        return this.patronymic;
    }
    public java.sql.Date getData_create() {
        return this.data_create;
    }
    public String getIdhist() {
        return this.idhist;
    }
}
