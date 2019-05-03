package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
//@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItem;
	
	@Size(max = 50)
	private String nameItem;
	
	@Size(max = 50)
	private int priceItem;
	
	@Size(max = 50)
	private String picItem;
	
	@OneToOne(cascade=CascadeType.REFRESH)
	@JsonIgnoreProperties("items")
	@JoinColumn(name="idTypeItem")
	private TypeItem typeItem;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "items", cascade = CascadeType.REMOVE)
	private List<Bucket> buckets;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public TypeItem getTypeItem() {
		return typeItem;
	}

	public void setTypeItem(TypeItem typeItem) {
		this.typeItem = typeItem;
	}

	public List<Bucket> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public int getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(int priceItem) {
		this.priceItem = priceItem;
	}

	public String getPicItem() {
		return picItem;
	}

	public void setPicItem(String picItem) {
		this.picItem = picItem;
	}
	
	public Item() {
	}

	public Item(int idItem, String nameItem, int priceItem, String picItem, TypeItem typeItem, List<Bucket> buckets) {
		super();
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.priceItem = priceItem;
		this.picItem = picItem;
		this.typeItem = typeItem;
		this.buckets = buckets;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", nameItem=" + nameItem + ", priceItem=" + priceItem + ", picItem=" + picItem
				+ ", typeItem=" + typeItem + ", buckets=" + buckets + "]";
	}

}