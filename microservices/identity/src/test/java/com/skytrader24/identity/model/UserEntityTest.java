package com.skytrader24.identity.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;

class UserEntityTest {

    @Test
    void shouldProvideNoArgConstructorForORM() {
        // Given
        Class<UserEntity> userEntityClass = UserEntity.class;

        // When
        Constructor<?>[] constructors = userEntityClass.getDeclaredConstructors();

        // Then
        assertThat(constructors)
                .as("UserEntity should provide a no-argument constructor for ORM.")
                .anySatisfy(constructor -> assertThat(constructor.getParameterCount()).isZero());
    }

}
