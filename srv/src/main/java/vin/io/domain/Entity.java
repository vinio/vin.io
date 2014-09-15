package vin.io.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

@JsonTypeInfo(property = "@class", use = JsonTypeInfo.Id.CLASS)
public abstract class Entity {

    @ObjectId
    @Id
    private String key;

    public String getKey() {
        return key;
    }

    public Entity setKey(final String key) {
        this.key = key;
        return this;
    }
}
