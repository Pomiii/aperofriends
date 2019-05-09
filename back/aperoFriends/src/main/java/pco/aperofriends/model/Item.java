package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the Item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItem;

	private String nameItem;
	
	private String picItem;

	private int priceItem;

	//bi-directional many-to-one association to Bucket
	@JsonBackReference
	@OneToMany(mappedBy="item")
	private List<Bucket> buckets;

	//bi-directional many-to-one association to TypeItem
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="idTypeItem")
	private TypeItem typeItem;

	public Item() {
	}

	public Item(String nameItem, int priceItem, String picItem, TypeItem typeItem) {
		this.nameItem = nameItem;
		this.priceItem = priceItem;
		this.picItem = picItem;
		this.typeItem = typeItem;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getNameItem() {
		return this.nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public int getPriceItem() {
		return this.priceItem;
	}

	public void setPriceItem(int priceItem) {
		this.priceItem = priceItem;
	}

	public List<Bucket> getBuckets() {
		return this.buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public Bucket addBucket(Bucket bucket) {
		getBuckets().add(bucket);
		bucket.setItem(this);

		return bucket;
	}

	public Bucket removeBucket(Bucket bucket) {
		getBuckets().remove(bucket);
		bucket.setItem(null);

		return bucket;
	}

	public TypeItem getTypeItem() {
		return this.typeItem;
	}

	public void setTypeItem(TypeItem typeItem) {
		this.typeItem = typeItem;
	}

	public String getPicItem() {
		return picItem;
	}

	public void setPicItem(String picItem) {
		this.picItem = picItem;
	}

}