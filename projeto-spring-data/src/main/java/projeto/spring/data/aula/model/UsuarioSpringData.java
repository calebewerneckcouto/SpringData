package projeto.spring.data.aula.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
public class UsuarioSpringData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String login;

	private String senha;

	private String nome;

	private String email;

	private int idade;
	
	@OneToMany(mappedBy = "usuarioSpringData",orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Telefone> getTelefones;
	
	
	
	
	

	public List<Telefone> getGetTelefones() {
		return getTelefones;
	}

	public void setGetTelefones(List<Telefone> getTelefones) {
		this.getTelefones = getTelefones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
