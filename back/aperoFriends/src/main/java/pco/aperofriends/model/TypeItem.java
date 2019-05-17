package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the TypeItem database table.
 * 
 */
@Entity
@NamedQuery(name="TypeItem.findAll", query="SELECT t FROM TypeItem t")
public class TypeItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypeItem;

	private String nameTypeItem;

	//bi-directional many-to-one association to Item
	@JsonIgnore
	@OneToMany(mappedBy="typeItem")
	private List<Item> items;

	public TypeItem() {
	}

	public TypeItem(String nameTypeItem) {
		super();
		this.nameTypeItem = nameTypeItem;
	}

	public int getIdTypeItem() {
		return this.idTypeItem;
	}

	public void setIdTypeItem(int idTypeItem) {
		this.idTypeItem = idTypeItem;
	}

	public String getNameTypeItem() {
		return this.nameTypeItem;
	}

	public void setNameTypeItem(String nameTypeItem) {
		this.nameTypeItem = nameTypeItem;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setTypeItem(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setTypeItem(null);

		return item;
	}

}