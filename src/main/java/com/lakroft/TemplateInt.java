package com.lakroft;

import spark.Request;

import java.util.Collections;
import java.util.Map;

public interface TemplateInt {
    public String getTemplate();

    public String getTitle();

    public default Map<String, Object> getData(Request request) {return Collections.emptyMap();}
}
