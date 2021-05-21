package com.snowflake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SnowflakeTest {

    @Test
    public void shouldGenerateUniqueId() {
        Snowflake snowflake = new Snowflake();
        int iterations = 5000;

        // Validate that the IDs are not same
        long[] ids = new long[iterations];
        for(int i = 0; i < iterations; i++) {
            ids[i] = snowflake.nextId();
        }

        for(int i = 0; i < ids.length; i++) {
            for(int j = i+1; j < ids.length; j++) {
                assertNotEquals(ids[i], ids[j]);
            }
        }
    }

    @Test
    public void withSingleThread() {
        int iterations = 1000;

        Snowflake snowflake = new Snowflake();
        long beginTimestamp = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            snowflake.nextId();
        }
        long endTimestamp = System.currentTimeMillis();

        long cost = (endTimestamp - beginTimestamp);
        long costMs = iterations/cost;
        System.out.println("Single Thread:: IDs per ms: " + costMs);
    }
}