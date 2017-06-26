package entidade;

import java.sql.Date;

public class Pessoa {
	
	private int idPessoa;
	private String nome;
	private Date dataNascimento;
	private String login;
	private String senha;
	private String email;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int idPessoa, String nome, Date dataNascimento, String login, String senha, String email) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
