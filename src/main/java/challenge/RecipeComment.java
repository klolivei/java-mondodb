package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe para mapear o comentario da receita no MongoDB
 *
 */
@Document
public class RecipeComment  {

    @Id
    private String id;
    private String comment;

    public RecipeComment() {
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(String id) {
        this.id = id;
    }


}