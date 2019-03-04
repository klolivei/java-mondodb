package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe para mapear o comentario da receita no MongoDB
 *
 */

@Document(collection = "comments")
public class RecipeComment {
    @Id
    private String id;
    private String comment;

}
