package vin.io.domain;

public class ResponseAck<T extends Entity> {

    private BusinessStatus status;

    private T entity;

    private ResponseAck(T entity, BusinessStatus status) {
        this.entity = entity;
        this.status = status;
    }

    public static <T extends Entity> ResponseAck<T> success(T entity) {
        return new ResponseAck<>(entity, BusinessStatus.OK);
    }

    public static <T extends Entity> ResponseAck<T> error(T entity) {
        return new ResponseAck<>(entity, BusinessStatus.ERROR);
    }

    public BusinessStatus getStatus() {
        return status;
    }

    public T getEntity() {
        return entity;
    }
}
