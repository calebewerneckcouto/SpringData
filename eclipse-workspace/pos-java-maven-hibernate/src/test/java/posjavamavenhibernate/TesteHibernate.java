package posjavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	@Test
	public void testeHibernate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(35);
		pessoa.setLogin("cwc3d");
		pessoa.setNome("Calebe Werneck Couto");
		pessoa.setEmail("calebewerneck@hotmail.com");
		pessoa.setSobrenome("Werneck Couto");
		pessoa.setSenha("cwc3d14694899");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	@Test
	public void testeBuscar() {
DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(1L);
		
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
	}
	

}
