package pizzahut.model.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Usuario {

	@NotNull @NotEmpty
	@Column(unique=true)
	private String login;

	@NotNull @NotEmpty
	private String pass;
	
	@Transient
	@NotNull @NotEmpty
	private String confirmacionPass;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getConfirmacionPass() {
		return confirmacionPass;
	}

	public void setConfirmacionPass(String confirmacionPass) {
		this.confirmacionPass = confirmacionPass;
	}
}