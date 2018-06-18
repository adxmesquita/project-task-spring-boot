/**
 * 
 */
package br.com.mesquitas.projecttask.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mesquitas.projecttask.model.Task;
import br.com.mesquitas.projecttask.repository.TaskRepository;

/**
 * @author Alessandro Mesquita
 *
 */
@Controller
public class TaskController {

	@Autowired
	private TaskRepository repository;

	public TaskController(TaskRepository taskRepository) {
		this.repository = taskRepository;
	}

	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	Iterable<Task> findaAll() {
		return repository.findAll();
	}

	@RequestMapping(path = "/findByName", method = RequestMethod.GET)
	@ResponseBody
	Task findByName() {
		return repository.findByName("Pagar as contas de consumo principais");
	}

	@RequestMapping(path = "/findById", method = RequestMethod.GET)
	@ResponseBody
	Optional<Task> findById() {
		return repository.findById((long) 3);
	}

	@RequestMapping(path = "/findAllByOrderByIdDesc", method = RequestMethod.GET)
	@ResponseBody
	List<Task> findAllByOrderByIdAsc() {
		return repository.findAllByOrderByIdDesc();
	}

	@RequestMapping(path = "/findAllByOrderByNameAsc", method = RequestMethod.GET)
	@ResponseBody
	List<Task> findAllByOrderByNameAsc() {
		return repository.findAllByOrderByNameAsc();
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	Task create(String name) {
		Task task = new Task(name);

		repository.save(task);

		return task;
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	@ResponseBody
	Task update(@PathVariable Long id, String name) {
		Optional<Task> obj = repository.findById(id);

		Task task = new Task();

		task.setId(obj.get().getId());
		task.setName(name);

		repository.save(task);

		return task;

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	Long deletar(@PathVariable Long id) {
		Optional<Task> obj = repository.findById(id);

		Task task = new Task();

		task.setId(obj.get().getId());

		repository.deleteById(id);

		return id;

	}

	@RequestMapping(path = "/deleteAll/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	void deleteAll(@PathVariable Long id) {

		repository.deleteAll();

	}
}