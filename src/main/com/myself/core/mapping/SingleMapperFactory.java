package com.myself.core.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by yjh on 2015/7/29.
 */
public class SingleMapperFactory {
    private SingleMapperFactory.FinalWrapper wrapper;

    public SingleMapperFactory() {
    }

    public MapperFactory instance() {
        SingleMapperFactory.FinalWrapper w = this.wrapper;
        if(w == null) {
            synchronized(this) {
                w = this.wrapper;
                if(w == null) {
                    w = new SingleMapperFactory.FinalWrapper((new DefaultMapperFactory.Builder()).build());
                    this.wrapper = w;
                }
            }
        }

        return w.instance;
    }

    private static class FinalWrapper {
        public final MapperFactory instance;

        public FinalWrapper(MapperFactory instance) {
            this.instance = instance;
        }
    }
}

