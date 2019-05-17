package pco.aperofriends.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the Bucket database table.
 * 
 */
@Entity
@NamedQuery(name="Bucket.findAll", query="SELECT b FROM Bucket b")
public class Bucket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBucket;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int total;

	//bi-directional many-to-one association to AccountFriend
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="idFriend", insertable=false, updatable=false)
	private Friend friend;

	//bi-directional many-to-one association to Item	
	@JsonIgnore
	@OneToMany(mappedBy="bucket")
	private List<Item> items;

	public Bucket() {
	}

	public int getIdBucket() {
		return idBucket;
	}

	public void setIdBucket(int idBucket) {
		this.idBucket = idBucket;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Friend getFriend() {
		return this.friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item addItem(Item item) {
        getItems().add(item);
        item.setBucket(this);

        return item;
    }

    public Item removeItem(Item item) {
        getItems().remove(item);
        item.setBucket(null);

        return item;
    }

}