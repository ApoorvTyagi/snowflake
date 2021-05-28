package com.snowflake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SnowflakeTest {

    @Test
    public void shouldGenerateUniqueId() {
        Snowflake snowflake = new Snowflake();
        int iterations = 5000;

        // Validate that the IDs are not same
        int[] ids = new int[iterations];
        for(int i = 0; i < iterations; i++) {
            ids[i] = snowflake.nextId();
        }

        for(int i = 0; i < ids.length; i++) {
            for(int j = i+1; j < ids.length; j++) {
                assertNotEquals(ids[i], ids[j]);
            }
        }
    }
}