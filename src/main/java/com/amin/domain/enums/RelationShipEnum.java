package com.amin.domain.enums;

import com.amin.domain.converter.ConvertableEnum;

public enum RelationShipEnum implements ConvertableEnum {
    FATHER(1),
    MOTHER(2),
    BROTHER(3),
    SISTER(4);

    private final Integer key;

    RelationShipEnum(Integer key) {
        this.key = key;
    }

    @Override
    public int getKey() {
        return key;
    }
}
