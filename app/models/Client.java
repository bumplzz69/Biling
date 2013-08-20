package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Client extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    public String name;

    public Long nif;

    public String email;

    public String address;

    public String cep;

    public Integer country;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public List<Biling> bilings;

}
