package com.myself.core.util.id;

import com.myself.core.exception.ConcurrencyException;

public class ConcurrencySafeEntity extends Entity {

    private Integer version;

    protected ConcurrencySafeEntity() {
        super();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void failWhenConcurrencyViolation(Integer version) {
        if (version != this.getVersion()) {
            throw new ConcurrencyException("另一个用户已经修改了记录[id=" + this.getId() + "],请重新提交.");
        }
    }
}
