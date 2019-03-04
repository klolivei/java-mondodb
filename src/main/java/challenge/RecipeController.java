package challenge;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeService service;
    @PostMapping
	public Recipe save(@RequestBody Recipe recipe) {
		return service.save(recipe);
	}

	public void update() {
		service.update(null, null);
	}

	public void delete() {
		service.delete(null);
	}

	public Recipe get() {
		return service.get(null);
	}

	public List<Recipe> listByIngredient() {
		return service.listByIngredient(null);
	}

	public List<Recipe> search() {
		return service.search(null);
	}

	public void like() {
		service.like(null, null);
	}

	public void unlike() {
		service.unlike(null, null);
	}

	public RecipeComment addComment() {
		return service.addComment(null, null);
	}

	public void updateComment() {
		service.updateComment(null, null, null);
	}

	public void deleteComment() {
		service.deleteComment(null, null);
	}

}
