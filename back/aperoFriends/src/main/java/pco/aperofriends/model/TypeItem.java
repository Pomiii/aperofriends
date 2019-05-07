package pco.aperofriends.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * The persistent class for the TYPEITEM database table.
 * 
 */
@Entity
//@NamedQuery(name="Typeitem.findAll", query="SELECT t FROM Typeitem t")
public class TypeItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeItem;
	
	@Size(max = 50)
	private String nameTypeItem;
	
	@ManyToMany(mappedBy="typeItem")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Item> items = new HashSet<Item>();

	public int getIdTypeItem() {
		return idTypeItem;
	}

	public void setIdTypeItem(int idTypeItem) {
		this.idTypeItem = idTypeItem;
	}

	public String getNameTypeItem() {
		return nameTypeItem;
	}

	public void setNameTypeItem(String nameTypeItem) {
		this.nameTypeItem = nameTypeItem;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public TypeItem() {
	}

	public TypeItem(int idTypeItem, String nameTypeItem, Set<Item> items) {
		super();
		this.idTypeItem = idTypeItem;
		this.nameTypeItem = nameTypeItem;
		this.items = items;
	}

	@Override
	public String toString() {
		return "TypeItem [idTypeItem=" + idTypeItem + ", nameTypeItem=" + nameTypeItem + ", items=" + items + "]";
	}
	
}