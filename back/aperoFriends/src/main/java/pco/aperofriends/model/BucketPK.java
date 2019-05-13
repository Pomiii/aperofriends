package pco.aperofriends.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Bucket database table.
 * 
 */
@Embeddable
public class BucketPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idFriend;

	@Column(insertable=false, updatable=false)
	private int idItem;

	public BucketPK() {
	}
	public int getIdFriend() {
		return this.idFriend;
	}
	public void setIdFriend(int idFriend) {
		this.idFriend = idFriend;
	}
	public int getIdItem() {
		return this.idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BucketPK)) {
			return false;
		}
		BucketPK castOther = (BucketPK)other;
		return 
			(this.idFriend == castOther.idFriend)
			&& (this.idItem == castOther.idItem);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFriend;
		hash = hash * prime + this.idItem;
		
		return hash;
	}
}