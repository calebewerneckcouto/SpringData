package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	@Test
	public void testeHibernate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(200);
		pessoa.setLogin("Janete");
		pessoa.setNome("Janete Candida de Oliveira Resende");
		pessoa.setEmail("janeteresende@hotmail.com");
		pessoa.setSobrenome("Resnde");
		pessoa.setSenha("arranjo");
		
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
	public void testeDelete() {
DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L,UsuarioPessoa.class);
		
		daoGeneric.deletarPoId(pessoa);
		
		
		
		
	}
	
	
	
	@Test
	public void testeConsultar() {
DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for( UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("----------------------------------------------");
			
			
			
		}
		
		
		
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
	@Test
	public void testeQueryList() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new  DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa where nome = 'Hamilton Couto'").getResultList();
		
		for(UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			
		}
		
	}

}
