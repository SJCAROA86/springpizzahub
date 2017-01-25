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
import pizzahut.model.entidades.Pizza;
import pizzahut.model.enumeraciones.IngredienteCategoria;
import pizzahut.model.enumeraciones.PizzaCategoria;
import pizzahut.model.repositorios.IngredienteRepositorio;
import pizzahut.model.repositorios.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaRepositorio pizzaRepo;
	@Autowired
	private IngredienteRepositorio ingredRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPizzas(Model model) {

		Iterable<Pizza> listaPizzas = pizzaRepo.findAll();
		model.addAttribute("titulo", "Listado de Pizzas");
		model.addAttribute("pizzas", listaPizzas);
		model.addAttribute("ingredientes", ingredRepo.findAll());
		model.addAttribute("categorias", PizzaCategoria.values());

		return "pizzas/listadoPizzas";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(Model model, @Valid @ModelAttribute Pizza pizza, Ingrediente ingrediente, BindingResult bindingResult) {
		
		pizzaRepo.save(pizza);
		ingredRepo.save(ingrediente);
		
		Iterable<Pizza> listaPizzas = pizzaRepo.findAll();
		Iterable<Ingrediente> listaIngredientes = ingredRepo.findAll();
		model.addAttribute("titulo", "Listado de Pizzas");
		model.addAttribute("pizzas", listaPizzas);
		model.addAttribute("ingredientes", listaIngredientes);
		model.addAttribute("categorias", IngredienteCategoria.values());

		return "pizzas/listadoPizzas";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> borrar(@PathVariable Long id){
		
		try{
			pizzaRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);//ok
		}
		catch(Exception e){
			return  new ResponseEntity<String>(HttpStatus.BAD_REQUEST);//error
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Pizza buscarPizza(@PathVariable Long id){
		
		Pizza pizza = pizzaRepo.findOne(id);
		return pizza;
	}
	
}
