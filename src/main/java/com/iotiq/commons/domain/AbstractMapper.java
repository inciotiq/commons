package com.iotiq.commons.domain;

import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.UUID;

// todo might want to remove model mapper
public abstract class AbstractMapper<S, D extends AbstractPersistable<UUID>> {
    private static final ModelMapper updateMapper = new ModelMapper();

    protected AbstractMapper(Class<S> sourceClass, Class<D> destinationClass) {
        updateMapper.typeMap(sourceClass, destinationClass).addMappings(getMappings());
    }

    protected abstract ExpressionMap<S, D> getMappings();

    public void map(S source, D destination) {
        updateMapper.map(source, destination);
    }
}
