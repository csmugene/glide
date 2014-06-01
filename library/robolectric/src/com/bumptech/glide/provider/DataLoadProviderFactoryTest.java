package com.bumptech.glide.provider;

import com.bumptech.glide.DataLoadProvider;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class DataLoadProviderFactoryTest {
    private DataLoadProviderFactory factory;

    @Before
    public void setUp() {
        factory = new DataLoadProviderFactory();
    }

    @Test
    public void testCanRegisterAndRetrieveDataLoadProvider() {
        DataLoadProvider<Object, Object> provider = mock(DataLoadProvider.class);
        factory.register(Object.class, Object.class, provider);

        assertEquals(provider, factory.get(Object.class, Object.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIfNoProviderRegistered() {
        factory.get(Object.class, Object.class);
    }
}
