package edu.masterjava.easybakery.persistence.model.feedstock;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QFeedstock is a Querydsl query type for Feedstock
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFeedstock extends EntityPathBase<Feedstock> {

    private static final long serialVersionUID = 329512820;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QFeedstock feedstock = new QFeedstock("feedstock");

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> modificationTime = createDateTime("modificationTime", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final QUnit unit;

    public final NumberPath<Integer> unitId = createNumber("unitId", Integer.class);

    public QFeedstock(String variable) {
        this(Feedstock.class, forVariable(variable), INITS);
    }

    public QFeedstock(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFeedstock(PathMetadata<?> metadata, PathInits inits) {
        this(Feedstock.class, metadata, inits);
    }

    public QFeedstock(Class<? extends Feedstock> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.unit = inits.isInitialized("unit") ? new QUnit(forProperty("unit")) : null;
    }

}

