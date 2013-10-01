package edu.masterjava.easybakery.persistence.model.batch;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QBatch is a Querydsl query type for Batch
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBatch extends EntityPathBase<Batch> {

    private static final long serialVersionUID = 512699128;

    public static final QBatch batch = new QBatch("batch");

    public final NumberPath<java.math.BigDecimal> batchCost = createNumber("batchCost", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<BatchIngredient, QBatchIngredient> ingredients = this.<BatchIngredient, QBatchIngredient>createSet("ingredients", BatchIngredient.class, QBatchIngredient.class);

    public final DateTimePath<java.util.Date> modificationTime = createDateTime("modificationTime", java.util.Date.class);

    public final NumberPath<Integer> recipeId = createNumber("recipeId", Integer.class);

    public final NumberPath<Double> totalAmount = createNumber("totalAmount", Double.class);

    public QBatch(String variable) {
        super(Batch.class, forVariable(variable));
    }

    public QBatch(Path<? extends Batch> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QBatch(PathMetadata<?> metadata) {
        super(Batch.class, metadata);
    }

}

