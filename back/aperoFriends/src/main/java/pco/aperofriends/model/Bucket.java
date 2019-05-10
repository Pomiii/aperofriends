package pco.aperofriends.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the Bucket database table.
 * 
 */
@Entity
@NamedQuery(name="Bucket.findAll", query="SELECT b FROM Bucket b")
public class Bucket implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BucketPK id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int total;

	//bi-directional many-to-one association to AccountFriend
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="idAF", insertable=false, updatable=false)
	private AccountFriend accountFriend;

	//bi-directional many-to-one association to Item
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="idItem", insertable=false, updatable=false)
	private Item item;

	public Bucket() {
	}

	public BucketPK getId() {
		return this.id;
	}

	public void setId(BucketPK id) {
		this.id = id;
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

	public AccountFriend getAccountFriend() {
		return this.accountFriend;
	}

	public void setAccountFriend(AccountFriend accountFriend) {
		this.accountFriend = accountFriend;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}