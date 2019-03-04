package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * Classe para mapear a receita no MongoDB
 *
 */
@Document( collection = "recipes")
public class Recipe {
    @Id
    private String id;
    private String title;
    private String description;
    private List<Integer> likes;
    private List<String> ingredients;
    private List<Comment> comments;

    public void setId(String id) {
        this.id = id;
    }

    public Recipe() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getLikes() {
        return likes;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
