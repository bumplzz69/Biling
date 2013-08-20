package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.data.format.Formats.DateTime;
import play.db.ebean.Model;

@Entity
public class Biling extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @DateTime(pattern = "dd/MM/yyyy")
    public Date date;

    public Integer validate;

    public String reference;

    public Integer isencaoIVA;

    public String description;

    public Double retention;

    public Integer currency;

    @ManyToOne(cascade = CascadeType.ALL)
    public Client client;

    @ManyToMany(mappedBy = "bilings", cascade = CascadeType.ALL)
    public List<Item> items;

    public static Finder<Long, Biling> find = new Finder<Long, Biling>(
	    Long.class, Biling.class);

    public static List<Biling> all() {
	return find.all();
    }

    public static void create(Biling biling) {
	biling.save();
    }

    public static Biling get(Long id) {
	return find.ref(id);
    }

    public static void delete(Long id) {
	get(id).delete();
    }

}
