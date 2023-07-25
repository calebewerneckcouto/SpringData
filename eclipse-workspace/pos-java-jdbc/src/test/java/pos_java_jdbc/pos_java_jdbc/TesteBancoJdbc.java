package pos_java_jdbc.pos_java_jdbc;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() { /*Inserir dados no banco de dados*/
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		
		
		userposjava.setNome("Jose Carlos Resende");
		userposjava.setEmail("zecarlos@gmail.com");
			
		
		userPosDAO.salvar(userposjava);
		
		
	}
	
	
	@Test
	public void initListar() {
		
		UserPosDAO dao = new UserPosDAO();
		try {
			
			
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				
				System.out.println(userposjava);
				System.out.println("------------------------------------");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar() {// buscar um dado pelo id individualmente.
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			
		Userposjava userposjava = dao.buscar(2L);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initAtualizar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("Nome mudado com o metodo atualizar");
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void initDeletar() {
		
		
		try {
			
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(8L);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(31)98796-7617");
		telefone.setTipo("Casa");
		telefone.setUsuario(1L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
	}
	
	@Test
	public void testeCarregaFonesUser() {
		
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone>beanUserFones = dao.listaUserFone(2L);
		
		
		for (BeanUserFone  beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------------------------------------------");
			
		}
		
	}
	
	@Test
		public void testeDeleteUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(6L);
		
		
		
	}

}
