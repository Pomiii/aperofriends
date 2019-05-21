package pco.aperofriends.model;

<<<<<<< HEAD
import org.springframework.security.core.GrantedAuthority;
=======
import java.io.Serializable;
import javax.persistence.*;

>>>>>>> origin

/**
 * User possible roles.
 */
<<<<<<< HEAD
public enum Role implements GrantedAuthority {

    ROLE_ADMIN, ROLE_CREATOR, ROLE_READER;

    @Override
    public String getAuthority() {
        return name();
    }
}

=======
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;

	private String nomRole;

	//bi-directional many-to-many association to Friend
/*	@ManyToMany
	@JoinTable(
		name="roleFriend"
		, joinColumns={
			@JoinColumn(name="idRole")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idFriend")
			}
		}
	private List<Friend> friends;
*/	
	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return this.nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

/*	public List<Friend> getFriends() {
		return this.friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
*/
}
>>>>>>> origin
