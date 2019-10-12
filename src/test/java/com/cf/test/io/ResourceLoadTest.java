package com.cf.test.io;

import com.cf.copyioc.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoadTest {

    @Test
    public void testResourceLoadTest() throws IOException {
        String location = "test.xml";
        ResourceLoader resourceLoader = new ResourceLoader();
        InputStream inputStream = resourceLoader.getResource(location).getInputStream();
        Assert.assertNotNull(inputStream);
    }

}
