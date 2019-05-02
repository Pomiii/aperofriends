package pco.aperofriends.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ROLE database table.
 * 
 */
@Entity
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;

	private int idUser;

	private String nomRole;

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getidUser() {
		return this.idUser;
	}

	public void setidUser(int idUser) {
		this.idUser = idUser;
	}

	public String getnomRole() {
		return this.nomRole;
	}

	public void setnomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", idUser=" + idUser + ", nomRole=" + nomRole + "]";
	}
	
	public Role() {
	}
	
	public Role(int idRole, int idUser, String nomRole) {
		super();
		this.idRole = idRole;
		this.idUser = idUser;
		this.nomRole = nomRole;
	}
	
}