package edu.masterjava.easybakery.persistence.model.batch;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QBatchIngredient is a Querydsl query type for BatchIngredient
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBatchIngredient extends EntityPathBase<BatchIngredient> {

    private static final long serialVersionUID = -1523309847;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QBatchIngredient batchIngredient = new QBatchIngredient("batchIngredient");

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final QBatch batch;

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<java.math.BigDecimal> feedstockPrice = createNumber("feedstockPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> modificationTime = createDateTime("modificationTime", java.util.Date.class);

    public final NumberPath<Integer> percentage = createNumber("percentage", Integer.class);

    public QBatchIngredient(String variable) {
        this(BatchIngredient.class, forVariable(variable), INITS);
    }

    public QBatchIngredient(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBatchIngredient(PathMetadata<?> metadata, PathInits inits) {
        this(BatchIngredient.class, metadata, inits);
    }

    public QBatchIngredient(Class<? extends BatchIngredient> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.batch = inits.isInitialized("batch") ? new QBatch(forProperty("batch")) : null;
    }

}

