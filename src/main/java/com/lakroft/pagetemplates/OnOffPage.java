package com.lakroft.pagetemplates;

import com.lakroft.TemplateInt;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

public class OnOffPage implements TemplateInt {

    private boolean isOn = false;
    private static final String ON_STATE = "on";
    private static final String OFF_STATE = "off";

    @Override
    public String getTitle() {
        return "Switch on/off button";
    }

    @Override
    public String getTemplate() {
        return "<html>" +
                    "<head>" +
                        "<style>" +
                            ".button {" +
                                "background-color: #e7e7e7;" +
                                "border: none;" +
                                "color: black;" +
                                "padding: 15px 32px;" +
                                "text-align: center;" +
                                "text-decoration: none;" +
                                "display: inline-block;" +
                                "font-size: 16px;" +
                                "margin: 4px 2px;" +
                                "cursor: pointer;" +
                            "}\n" +
                            ".button_blue {background-color: #008CBA; color: white;}" +
                        "</style>" +
                    "</head>" +
                    "<body>" +
                        "<h1>Button is ${is_on}</h1>" +
                        "<button " +
                            "class=\"button ${is_on_color}\" " +
                            "onclick=\"document.location='button?action=${on_click}'\">" +
                            "Press to switch ${on_click}" +
                        "</button>" +
                    "</body>" +
                "</html>";
    }

    @Override
    public Map<String, Object> getData(Request request) {
        Map<String, Object> data = new HashMap<>();
        String action = request.queryParams("action");
        if (ON_STATE.equals(action)) {
            isOn = true;
        }
        if (OFF_STATE.equals(action)) {
            isOn = false;
        }
        data.put("is_on", isOn ? ON_STATE : OFF_STATE);
        data.put("is_on_color", isOn ? "button_blue" : "");
        data.put("on_click", isOn ? OFF_STATE : ON_STATE);
        return data;
    }
}
