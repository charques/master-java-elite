package edu.masterjava.easybakery.service.recipe;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;

import edu.masterjava.easybakery.web.model.recipe.RecipeUI;


/**
 * Interface del servicio de recetas.
 * 
 * @author carloshernandezarques
 */
public interface RecipeService {

	/**
	 * Crea una receta.
	 * @param created
	 * @return
	 */
    public RecipeUI create(RecipeUI created);

    /**
     * Elimina una receta.
     * @param recipeId
     * @return
     * @throws RecipeNotFoundException
     * @throws DataIntegrityViolationException
     */
    @Secured ({"ROLE_ADMIN"})
    public RecipeUI delete(Integer recipeId) throws RecipeNotFoundException, DataIntegrityViolationException;

    /**
     * Busca todas las recetas.
     * @return
     */
    public List<RecipeUI> findAll();

    /**
     * Busca una receta por id.
     * @param id    
     * @return 
     */
    public RecipeUI findById(Integer id);

    /**
     * Actualiza la informaci—n de una receta.
     * @param updated
     * @return
     * @throws RecipeNotFoundException
     */
    public RecipeUI update(RecipeUI updated) throws RecipeNotFoundException;

}
