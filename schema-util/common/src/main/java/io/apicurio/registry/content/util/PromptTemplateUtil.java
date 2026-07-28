package io.apicurio.registry.content.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility for parsing prompt template contents.
 */
public class PromptTemplateUtil {

    public static final Pattern TEMPLATE_VARIABLE_PATTERN = Pattern.compile("\\{\\{([^}]+)\\}\\}");

    /**
     * Extracts variables from a prompt template string.
     * Example: "Hello {{ my var }}" returns ["my var"]
     * 
     * @param template the raw prompt template string
     * @return a list of variables found in the template
     */
    public static List<String> extractVariables(String template) {
        List<String> variables = new ArrayList<>();
        if (template != null) {
            Matcher matcher = TEMPLATE_VARIABLE_PATTERN.matcher(template);
            while (matcher.find()) {
                variables.add(matcher.group(1).trim());
            }
        }
        return variables;
    }

}
