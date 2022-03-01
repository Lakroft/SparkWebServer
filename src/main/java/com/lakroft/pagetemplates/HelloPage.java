package com.lakroft.pagetemplates;

import com.lakroft.TemplateInt;
import org.apache.commons.lang3.StringUtils;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

public class HelloPage implements TemplateInt {

    @Override
    public String getTitle() {
        return "Hello Page";
    }

    @Override
    public String getTemplate() {
        return
                "<html>" +
                    "<head>" +
                    "</head>" +
                    "<body>" +
                        "<h1>Hello, ${message}!</h1>" +
                    "</body>" +
                "</html>";
    }

    @Override
    public Map<String, Object> getData(Request request) {
        Map<String, Object> data = new HashMap<>();
        String user = request.queryParams("user");
        data.put("message", StringUtils.isEmpty(user) ? "user" : user);
        return data;
    }
}
