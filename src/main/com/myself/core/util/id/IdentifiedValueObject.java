package com.myself.core.util.id;


/**
 *  所有值对象继承此类获得一个隐藏的委派主键
 * Created by yjh on 2015/7/28.
 */
public abstract class IdentifiedValueObject extends IdentifiedDomainObject {

    protected IdentifiedValueObject() {
        super();
    }
}
