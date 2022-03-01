package com.lakroft;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

public class PageGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageGenerator.class);
    private static final String ERRORR_PAGE =
            "<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<h1>Error</h1>" +
                    "<p>Something went wrong. We will try to fix this as soon as possible</p>" +
                "</body>" +
            "</html>";

    Configuration configuration;

    public PageGenerator() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public String render (String strTemplate, Map<String, Object> data) {
        try {
            Template template = new Template("", new StringReader(strTemplate), configuration);
            StringWriter writer = new StringWriter();
            template.process(data, writer);

            return writer.toString();
        } catch (Exception e) {
            LOGGER.error("Page generation error:", e);
            LOGGER.error("Page template:");
            LOGGER.error(strTemplate);
            LOGGER.error("Data");
            data.forEach((key, value) -> LOGGER.error(key + ":" + value));
        }
        return ERRORR_PAGE;
    }
}
