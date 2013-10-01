package edu.masterjava.easybakery.persistence.model.batch;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QBatchStatistics is a Querydsl query type for BatchStatistics
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBatchStatistics extends EntityPathBase<BatchStatistics> {

    private static final long serialVersionUID = -1411489221;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QBatchStatistics batchStatistics = new QBatchStatistics("batchStatistics");

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final QBatch batch;

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<java.math.BigDecimal> feedstockPrice = createNumber("feedstockPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> ingredientId = createNumber("ingredientId", Integer.class);

    public final DateTimePath<java.util.Date> modificationTime = createDateTime("modificationTime", java.util.Date.class);

    public final NumberPath<Double> percentage = createNumber("percentage", Double.class);

    public QBatchStatistics(String variable) {
        this(BatchStatistics.class, forVariable(variable), INITS);
    }

    public QBatchStatistics(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBatchStatistics(PathMetadata<?> metadata, PathInits inits) {
        this(BatchStatistics.class, metadata, inits);
    }

    public QBatchStatistics(Class<? extends BatchStatistics> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.batch = inits.isInitialized("batch") ? new QBatch(forProperty("batch")) : null;
    }

}

