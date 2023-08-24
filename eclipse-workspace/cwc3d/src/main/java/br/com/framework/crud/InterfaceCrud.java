package br.com.framework.crud;

import java.io.Serializable;
import java.util.List;

import javax.mail.Session;

import org.hibernate.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {
	/*
	 * Usa Metodo Generico para salvar qualquer objeto
	 * 
	 * Representado por <T>
	 * 
	 */

	/* Salva os dados */
	void save(T obj) throws Exception;

	void persist(T obj) throws Exception;

	/* Salva ou Atualiza */
	void saveOrUpdate(T obj) throws Exception;

	// Realiza o Update/atualização dos dados
	void update(T obj) throws Exception;

	// Realiza o Delete dos dados
	void delete(T obj) throws Exception;

	// Salva ou atualiza e retorna o objeto em estado persistente
	T merge(T obj) throws Exception;

	// Carrega a lista de dadis de determinada classe.
	List<T> findList(Class<T> objs) throws Exception;

	Object findById(Class<T> entidade, Long id) throws Exception;

	T findByPorId(Class<T> entidade, Long id) throws Exception;

	List<T> findListByQueryDinamica(String s) throws Exception;

	// executar update com HQL( hibernate)
	void executeUpdateQueryDinamica(String s) throws Exception;

	// Executar update com SQL
	void executeUpdateSQLDinamica(String s) throws Exception;

	// limpa a sessão do Hibernate
	void clearSession() throws Exception;

	// Retira o Objeto da Sessão do Hibernate
	void evict(Object objs) throws Exception;

	Session getSession() throws Exception;

	List<?> getListSQLDinamica(String sql) throws Exception;

	T findUninqueByPropertyId(Class<T> entidade, Long id, Object atributo) throws Exception;

	T findUniqueByQueryDinamica(String query) throws Exception;

	void executeUpdateSQLDinamica(String query, Long... cods) throws Exception;

	List<T> finListOrderByProperty(Class<T> entidade, String propriedade) throws Exception;

	T findUninqueByProperty(Class<T> entidade, Object valor, String atributo) throws Exception;

	T findUninqueByPropertyId(Class<T> entidade, Long id, Object atributo, String condicaoAdicional) throws Exception;

	JdbcTemplate getJdbcTemplate();

	SimpleJdbcTemplate getSimpleJdbcTemplate();

	SimpleJdbcInsert getSimpleJdbcInsert();

	public T findUninqueByProperty(Class<T> entidade, Object valor, String atributo, String condicao) throws Exception;

	Long totalRegistro(String tabela) throws Exception;

	Query obterQuery(String query) throws Exception;

	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
}
