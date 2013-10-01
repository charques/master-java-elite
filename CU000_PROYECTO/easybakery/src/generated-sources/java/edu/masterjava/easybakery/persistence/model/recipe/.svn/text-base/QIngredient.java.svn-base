package edu.masterjava.easybakery.persistence.model.recipe;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QIngredient is a Querydsl query type for Ingredient
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIngredient extends EntityPathBase<Ingredient> {

    private static final long serialVersionUID = 470650979;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QIngredient ingredient = new QIngredient("ingredient");

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final edu.masterjava.easybakery.persistence.model.feedstock.QFeedstock feedstock;

    public final NumberPath<Integer> feedstockId = createNumber("feedstockId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> modificationTime = createDateTime("modificationTime", java.util.Date.class);

    public final NumberPath<Integer> percentage = createNumber("percentage", Integer.class);

    public final QRecipe recipe;

    public QIngredient(String variable) {
        this(Ingredient.class, forVariable(variable), INITS);
    }

    public QIngredient(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QIngredient(PathMetadata<?> metadata, PathInits inits) {
        this(Ingredient.class, metadata, inits);
    }

    public QIngredient(Class<? extends Ingredient> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.feedstock = inits.isInitialized("feedstock") ? new edu.masterjava.easybakery.persistence.model.feedstock.QFeedstock(forProperty("feedstock"), inits.get("feedstock")) : null;
        this.recipe = inits.isInitialized("recipe") ? new QRecipe(forProperty("recipe")) : null;
    }

}

