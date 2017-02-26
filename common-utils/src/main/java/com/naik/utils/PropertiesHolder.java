package com.naik.utils;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder extends Properties {
    public void setPropFile(Resource resource) throws IOException {
        super.load(resource.getInputStream());
    }
}
