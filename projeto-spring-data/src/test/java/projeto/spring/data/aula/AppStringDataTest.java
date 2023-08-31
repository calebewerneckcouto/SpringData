package projeto.spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.model.UsuarioSpringData;
import projetos.spring.data.aula.dao.InterfaceSpringDataUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppStringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		
	UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
	usuarioSpringData.setEmail("livinha.resende@hotmail.com");
	usuarioSpringData.setIdade(38);
	usuarioSpringData.setLogin("livinha");
	usuarioSpringData.setSenha("livinha");
	usuarioSpringData.setNome("Livia de Oliveira Resende Werneck Couto");
	
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

}
