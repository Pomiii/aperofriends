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
	private int idAF;

	@Column(insertable=false, updatable=false)
	private int idItem;

	public BucketPK() {
	}
	public int getIdAF() {
		return this.idAF;
	}
	public void setIdAF(int idAF) {
		this.idAF = idAF;
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
			(this.idAF == castOther.idAF)
			&& (this.idItem == castOther.idItem);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAF;
		hash = hash * prime + this.idItem;
		
		return hash;
	}
}