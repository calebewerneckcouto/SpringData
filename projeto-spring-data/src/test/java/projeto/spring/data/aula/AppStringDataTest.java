package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;
import projetos.spring.data.aula.dao.InterfaceSpringDataUser;
import projetos.spring.data.aula.dao.InterfaceTelefone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppStringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	
	
	@Test
	public void testeInsert() {
		
	UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
	usuarioSpringData.setEmail("jujuba@hotmail.com");
	usuarioSpringData.setIdade(14);
	usuarioSpringData.setLogin("julinha");
	usuarioSpringData.setSenha("julinha");
	usuarioSpringData.setNome("Julia Resende Werneck Couto");
	
	interfaceSpringDataUser.save(usuarioSpringData);
	
		
	}
	
	
	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
	}
	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("--------------------------------------------");
			
		}
		
		
		
	}
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("Lilica");
		
		interfaceSpringDataUser.save(data);
		
	}
	@Test
	public void testeDelete() {
		
		interfaceSpringDataUser.deleteById(2L);
		
	}
	
	@Test
	public void testeDelete2() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		interfaceSpringDataUser.delete(usuarioSpringData.get());
		
	}

	@Test
	public void testeConsultaNome() {
		
		List<UsuarioSpringData> lista = interfaceSpringDataUser.buscaPorNome("Livia");
		
	for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("--------------------------------------------");
			
		}
		
		
	}
	
	@Test
	public void testeDeletePorNome() {
		
		interfaceSpringDataUser.deletePorNome("Rita da Costa Werneck");
		
	}
	
	@Test
	public void testeUpdadeEmailPorNome() {
		
		interfaceSpringDataUser.updateEmailPorNome("calebewerneck@gmail.com", "Calebe Werneck Couto");
		
	}
	
	
	
	
	
	@Test
	public void testeConsultaNomeParam() {
		
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Livia de Oliveira Resende Werneck Couto");
		
	
			
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("--------------------------------------------");
			
		
		
		
	}
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(5L);
		
		Telefone telefone = new Telefone();
		telefone.setTipo("Celular");
		telefone.setNumero("987967617");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
		
		
		
	}

}
