package com.myself.core.util.id;

import java.io.Serializable;

/**
 * Created by yjh on 2015/7/28.
 */
public abstract class AbstractId implements IIdentity, Serializable {

    private String id;

    protected AbstractId() {
        super();
    }

    protected AbstractId(String anId) {
        this();

        this.setId(anId);
    }

    public String getId() {
        return this.id;
    }


    private void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractId)) return false;

        AbstractId that = (AbstractId) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + "]";
    }


}
