package com.myself.core.util.id;

import java.io.Serializable;

/**
 * 提供一个基本的委托主键
 * Created by yjh on 2015/7/28.
 */
public abstract class IdentifiedDomainObject implements Serializable {

    private String id;

    protected IdentifiedDomainObject() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
