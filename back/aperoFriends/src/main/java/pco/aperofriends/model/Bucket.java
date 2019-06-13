package pco.aperofriends.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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

	//bi-directional many-to-one association to Friend
	@ManyToOne
	@JoinColumn(name="id_friend")
	private Friend friend;

	//bi-directional many-to-one association to Item	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="bucket_has_items"
        , joinColumns={
            @JoinColumn(name="id_bucket")
            }
        , inverseJoinColumns={
            @JoinColumn(name="id_item")
            }
        )
	private List<Item> items;

	public Bucket() {
	}
	
	public Bucket(Friend friend) {
		this.friend = friend;
		this.items = new ArrayList<Item>();
	}
	
	public Bucket(List<Item> items) {
		this.items = items;
	}

	public Bucket(Friend friend, Date date) {
		this.friend = friend;
		this.date = date;
		this.items = new ArrayList<Item>();
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
		item.setBuckets(null);
		return item;
	}
    
    public Item removeItem(Item item) {
        getItems().remove(item);
        item.setBuckets(null);
        return item;
    }
    
}