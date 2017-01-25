package pizzahut.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pizzahut.model.entidades.Ingrediente;
import pizzahut.model.enumeraciones.IngredienteCategoria;
import pizzahut.model.repositorios.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteRepositorio ingredRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String listarIngredientes(Model model) {
		
		Iterable<Ingrediente> listaIngredientes = ingredRepo.findAll();
		model.addAttribute("titulo", "Listado de Ingredientes");
		model.addAttribute("ingredientes", listaIngredientes);
		model.addAttribute("categorias", IngredienteCategoria.values());

		return "ingredientes/listadoIngredientes";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(Model model, @Valid @ModelAttribute Ingrediente ingrediente, BindingResult bindingResult) {
		
		ingredRepo.save(ingrediente);
		Iterable<Ingrediente> listaIngredientes = ingredRepo.findAll();
		model.addAttribute("titulo", "Listado de Ingredientes");
		model.addAttribute("ingredientes", listaIngredientes);
		model.addAttribute("categorias", IngredienteCategoria.values());

		return "ingredientes/listadoIngredientes";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar(@PathVariable Long id){
		
		try{
			ingredRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);//ok
		}
		catch(Exception e){
			return  new ResponseEntity<String>(HttpStatus.BAD_REQUEST);//error
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Ingrediente buscarIngrediente(@PathVariable Long id){
		
		Ingrediente ingrediente = ingredRepo.findOne(id);
		return ingrediente;
	}
	

}
