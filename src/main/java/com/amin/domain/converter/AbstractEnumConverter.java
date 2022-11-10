package com.amin.domain.converter;

import jakarta.persistence.AttributeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEnumConverter<E extends ConvertableEnum> implements AttributeConverter<E, Integer> {

    private static final Logger log = LoggerFactory.getLogger(AbstractEnumConverter.class);

    private final Map<Integer, E> map = new HashMap<>();

    private final Class<E> subClass;

    /**
     * AbstractEnumConverter
     */
    @SuppressWarnings("unchecked")
    protected AbstractEnumConverter() {

        subClass = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractEnumConverter.class);
        if (subClass != null) {
            E[] values;
            try {
                values = (E[]) subClass.getMethod("values").invoke(null);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                log.error("{} could not be configured.", subClass.getCanonicalName());
                throw new IllegalStateException(subClass.getCanonicalName() + " could not be configured.", e);
            }
            for (E e : values) {
                if (map.get(e.getKey()) != null) {
                    log.error("{} has duplicate in defined id-key {}.", subClass.getCanonicalName(), e.getKey());
                    throw new IllegalStateException(
                            subClass.getCanonicalName() + " has duplicate in defined id-key " + e.getKey());
                }
                map.put(e.getKey(), e);
            }
        }

    }

    @Override
    public Integer convertToDatabaseColumn(E attribute) {
        if (attribute != null) {
            return attribute.getKey();
        } else {
            return null;
        }
    }

    @Override
    public E convertToEntityAttribute(Integer dbData) {
        return map.get(dbData);
    }

}
