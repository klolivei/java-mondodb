package challenge;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findByIngredientsOrderByTitle(String ingredient);
    List<Recipe> findByTitleContainingIgnoreCase(String search);
    List<Recipe> findByDescriptionContainingIgnoreCase(String search);




}
