import javax.persistence.*;

@Entity
@Table(name = "userauth")

public class myTable2 {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public myTable2() {}

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

}
