package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean {

	private String nome;
	
	private HtmlCommandButton  commandButton;

	private List<String> nomes = new ArrayList<>();
	
	
	
	

	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public String addNome() {
		 
		
		nomes.add(nome);
		
		if(nomes.size()>5) {
			commandButton.setDisabled(true);
		}
		
		
		return "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
