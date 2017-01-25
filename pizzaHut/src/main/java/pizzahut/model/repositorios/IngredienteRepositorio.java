package pizzahut.model.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pizzahut.model.entidades.Ingrediente;


@Repository
public interface IngredienteRepositorio extends CrudRepository<Ingrediente, Long> {

	//AQU� PUEDO A�ADIR MIS M�TODOS PERSONALIZADOS
}
