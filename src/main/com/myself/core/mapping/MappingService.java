package com.myself.core.mapping;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.DefaultFieldMapper;
import ma.glasnost.orika.Mapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by yjh on 2015/7/29.
 */
public class MappingService implements IMappingService, ApplicationContextAware {
    private static final ConcurrentMap<String, BoundMapperFacade> CACHE = new ConcurrentHashMap(200);
    private static final SingleMapperFactory SINGLE_MAPPER_FACTORY = new SingleMapperFactory();

    public MappingService() {
    }

    public <A, B> List<B> mapAsList(List<A> sourceObject, Class<B> destinationClass) {
        return SINGLE_MAPPER_FACTORY.instance().getMapperFacade().mapAsList(sourceObject, destinationClass);
    }

    public <A, B> B map(A sourceObject, Class<B> destinationClass, boolean cycles) {
        BoundMapperFacade boundMapperFacade = this.getMapperFacade(sourceObject, destinationClass, cycles);
        return (B) boundMapperFacade.map(sourceObject);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map converters = applicationContext.getBeansOfType(Converter.class);
        Iterator mappers = converters.values().iterator();

        while(mappers.hasNext()) {
            Converter i$ = (Converter)mappers.next();
            this.addConverter(i$);
        }

        Map mappers1 = applicationContext.getBeansOfType(Mapper.class);
        Iterator i$1 = mappers1.values().iterator();

        while(i$1.hasNext()) {
            Mapper mapper = (Mapper)i$1.next();
            this.addMapper(mapper);
        }

    }

    private <A, B> BoundMapperFacade<A, B> getMapperFacade(A sourceObject, Class<B> destinationClass, boolean cycles) {
        Class sourceClass = sourceObject.getClass();
        String key = sourceClass.getName() + destinationClass.getName() + cycles;
        BoundMapperFacade boundMapperFacade;
        if(CACHE.containsKey(key)) {
            boundMapperFacade = (BoundMapperFacade)CACHE.get(key);
        } else {
            BoundMapperFacade tmpBoundMapperFacade = SINGLE_MAPPER_FACTORY.instance().getMapperFacade(sourceClass, destinationClass, cycles);
            boundMapperFacade = (BoundMapperFacade)CACHE.putIfAbsent(key, tmpBoundMapperFacade);
            if(boundMapperFacade == null) {
                boundMapperFacade = tmpBoundMapperFacade;
            }
        }

        return boundMapperFacade;
    }

    public void addConverter(Converter<?, ?> converter) {
        SINGLE_MAPPER_FACTORY.instance().getConverterFactory().registerConverter(converter);
    }

    public void addMapper(Mapper mapper) {
        SINGLE_MAPPER_FACTORY.instance().classMap(mapper.getAType(), mapper.getBType()).byDefault(new DefaultFieldMapper[0]).customize(mapper).register();
    }
}
