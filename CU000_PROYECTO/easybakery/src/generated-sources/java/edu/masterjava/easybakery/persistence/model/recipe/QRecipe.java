package edu.masterjava.easybakery.persistence.model.recipe;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QRecipe is a Querydsl query type for Recipe
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipe extends EntityPathBase<Recipe> {

    private static final long serialVersionUID = 1275825440;

    public static final QRecipe recipe = new QRecipe("recipe");

    public final StringPath comment = createString("comment");

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<Ingredient, QIngredient> ingredientList = this.<Ingredient, QIngredient>createSet("ingredientList", Ingredient.class, QIngredient.class);

    public final DateTimePath<java.util.Date> modificationTime = createDateTime("modificationTime", java.util.Date.class);

    public QRecipe(String variable) {
        super(Recipe.class, forVariable(variable));
    }

    public QRecipe(Path<? extends Recipe> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QRecipe(PathMetadata<?> metadata) {
        super(Recipe.class, metadata);
    }

}

