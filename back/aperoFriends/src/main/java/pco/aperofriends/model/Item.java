package pco.aperofriends.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Bucket", insertable=false, updatable=false)
	private Bucket bucket;

	//bi-directional many-to-one association to TypeItem
	@ManyToOne
	@JoinColumn(name="idTypeItem")
	private TypeItem typeItem;

	public Item() {
	}

	public Item(String nameItem, String picItem, TypeItem typeItem, int priceItem) {
		this.nameItem = nameItem;
		this.priceItem = priceItem;
		this.picItem = picItem;
		this.typeItem = typeItem;
	}
	
	public Item(String nameItem, String picItem, int priceItem) {
		this.nameItem = nameItem;
		this.priceItem = priceItem;
		this.picItem = picItem;
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

	public Bucket getBucket() {
		return this.bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
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