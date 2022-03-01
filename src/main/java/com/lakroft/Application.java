package com.lakroft;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;
import static spark.Spark.get;

public class Application {
    private static final TemplatesManager templatesManager = new TemplatesManager();
    private static final PageGenerator pageGenerator = new PageGenerator();
    private static final String GENERATED_PAGES_PREFIX = "/gen";

    public static void main(String[] args) {
        get(GENERATED_PAGES_PREFIX + "/*", (request, response) -> {
            String path = request.pathInfo();
            TemplateInt template = templatesManager.getTemplate(path.substring(path.lastIndexOf('/')+1));
            return pageGenerator.render(template.getTemplate(), template.getData(request));
        });
        get("/", (request, response) -> {
            String html = html(
                head(),
                body(
                    templatesManager.getPages(GENERATED_PAGES_PREFIX).stream().map(key ->
                        div(
                            a(templatesManager.getTemplate(key).getTitle()).withHref(key)
//                            a().withHref("/gen/" + key).withTitle(templatesManager.getTemplate(key).getTitle())
                        )
                    ).toArray(ContainerTag[]::new)
                )
            ).render();

            return html;
        });
    }

}
