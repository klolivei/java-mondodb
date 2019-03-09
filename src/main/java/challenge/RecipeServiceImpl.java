package challenge;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCommentRepository recipeCommentRepository;

	@Override
	public Recipe save(Recipe recipe) {
        return recipeRepository.insert(recipe);
	}

	@Override
	public void update(String id, Recipe recipe) {
	    Recipe recipeToUpdated = recipeRepository.findById(id).get();

        recipeToUpdated.setDescription(recipe.getDescription());
        recipeToUpdated.setIngredients(recipe.getIngredients());
        recipeToUpdated.setTitle(recipe.getTitle());

        recipeRepository.save(recipeToUpdated);
	}

	@Override
	public void delete(String id) {
        recipeRepository.deleteById(id);
	}

	@Override
	public Recipe get(String id) {
		return recipeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Recipe> listByIngredient(String ingredient) {
		return recipeRepository.findByIngredientsOrderByTitle(ingredient);
	}

	@Override
	public List<Recipe> search(String search) {
        Set<Recipe> recipes = new HashSet<>();
        recipes.addAll(recipeRepository.findByTitleContainingIgnoreCase(search));
        recipes.addAll(recipeRepository.findByDescriptionContainingIgnoreCase(search));

		return recipes.stream()
                .sorted(Comparator.comparing(Recipe::getTitle))
                .collect(Collectors.toList());
	}

	@Override
	public void like(String id, String userId) {
        Recipe recipeToUpdateLikes = recipeRepository.findById(id).get();
        List<String> likes = recipeToUpdateLikes.getLikes();
        likes.add(userId);
        recipeToUpdateLikes.setLikes(likes);
        recipeRepository.save(recipeToUpdateLikes);
	}

	@Override
	public void unlike(String id, String userId) {
        Recipe recipeToUpdateLikes = recipeRepository.findById(id).get();
        List<String> likes = recipeToUpdateLikes.getLikes();
        likes.remove(userId);
        recipeToUpdateLikes.setLikes(likes);
        recipeRepository.save(recipeToUpdateLikes);

	}

	@Override
	public RecipeComment addComment(String id, RecipeComment comment) {
		Recipe recipeToAddComment = recipeRepository.findById(id).get();
		List<RecipeComment> recipeComments = recipeToAddComment.getComments();
		comment.setId(String.valueOf(new ObjectId()));
		recipeComments.add(comment);
		recipeToAddComment.setComments(recipeComments);
		recipeRepository.save(recipeToAddComment);
	    return comment;
	}

	@Override
	public void updateComment(String id, String commentId, RecipeComment comment) {
        Recipe recipeToUpdateComment = recipeRepository.findById(id).get();
        List<RecipeComment> recipeComments = recipeToUpdateComment.getComments();
        RecipeComment recipeComment = recipeComments.stream()
                .filter(recipeComment1 -> commentId.equals(recipeComment1.getId()))
                .findAny()
                .orElse(null);

        recipeComment.setComment(comment.getComment());
        recipeComments.set(recipeComments.indexOf(recipeComment), recipeComment);
        recipeToUpdateComment.setComments(recipeComments);
        recipeRepository.save(recipeToUpdateComment);

	}

	@Override
	public void deleteComment(String id, String commentId) {
        Recipe recipeToDeleteComment = recipeRepository.findById(id).get();
        List<RecipeComment> recipeComments = recipeToDeleteComment.getComments();
        RecipeComment recipeComment = recipeComments.stream()
                .filter(recipeComment1 -> commentId.equals(recipeComment1.getId()))
                .findAny()
                .orElse(null);
        recipeComments.remove(recipeComment);
        recipeToDeleteComment.setComments(recipeComments);
        recipeRepository.save(recipeToDeleteComment);


	}

}
