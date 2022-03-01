package com.lakroft;

import com.lakroft.pagetemplates.HelloPage;
import com.lakroft.pagetemplates.OnOffPage;
import com.lakroft.pagetemplates.PageNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class TemplatesManager {
    private Map<String, TemplateInt> existingPages = new HashMap<>();

    public TemplatesManager() {
        existingPages.put("hello", new HelloPage());
        existingPages.put("button", new OnOffPage());
    }

    public Set<String> getPages (String urlPrefix) {
        return existingPages.keySet().stream().map(key -> urlPrefix + "/" + key).collect(Collectors.toSet());
    }

    public TemplateInt getTemplate (String path) {
        if (existingPages.containsKey(path)) {
            return existingPages.get(path);
        }
        return new PageNotFound();
    }
}
