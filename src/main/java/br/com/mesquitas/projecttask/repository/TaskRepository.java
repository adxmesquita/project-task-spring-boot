/**
 * 
 */
package br.com.mesquitas.projecttask.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import br.com.mesquitas.projecttask.model.Task;

/**
 * @author Alessandro Mesquita
 *
 */

@Transactional
public interface TaskRepository extends CrudRepository<Task, Long>{

	public Task findByName(String name);

	public Task findByNameIgnoreCase(String name);
	
	public Task findByNameAndId(String name, long id);
	
	public List<Task> findAllByOrderByIdDesc();
	
	public List<Task> findAllByOrderByNameAsc();

}
