package edu.masterjava.easybakery.persistence.model.feedstock;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUnit is a Querydsl query type for Unit
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUnit extends EntityPathBase<Unit> {

    private static final long serialVersionUID = 1032499400;

    public static final QUnit unit = new QUnit("unit");

    public final DateTimePath<java.util.Date> creationTime = createDateTime("creationTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QUnit(String variable) {
        super(Unit.class, forVariable(variable));
    }

    public QUnit(Path<? extends Unit> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUnit(PathMetadata<?> metadata) {
        super(Unit.class, metadata);
    }

}

