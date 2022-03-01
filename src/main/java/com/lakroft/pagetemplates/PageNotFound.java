package com.lakroft.pagetemplates;

import com.lakroft.TemplateInt;

public class PageNotFound implements TemplateInt {

    @Override
    public String getTitle() {
        return "Page not found";
    }

    @Override
    public String getTemplate() {
        return
            "<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                    "<h1>404 Page not found</h1>" +
                "</body>" +
            "</html>";
    }
}
