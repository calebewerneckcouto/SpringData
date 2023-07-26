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
		pessoa.setLogin("livinha");
		pessoa.setNome("Livia de Oliveira Resende Werneck Couto");
		pessoa.setEmail("livinha@hotmail.com");
		pessoa.setSobrenome("Resende");
		pessoa.setSenha("livinha");
		
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
	
	
	@Test
	public void testeBuscar2() {
DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(2L,UsuarioPessoa.class);
		
		
		
		
		
		System.out.println(pessoa);
		
	}
	
	
	@Test
	public void testeUpdate() {
DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L,UsuarioPessoa.class);
		
		
		pessoa.setIdade(99);
		pessoa.setNome("atualizado");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		
		
		
		System.out.println(pessoa);
		
	}

}
