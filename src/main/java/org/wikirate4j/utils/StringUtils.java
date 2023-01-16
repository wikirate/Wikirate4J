package org.wikirate4j.utils;
/**
 * StringUtils Class contains methods to help us process certain string values
 * @author Vasiliki Gkatziaki
 */
public class StringUtils {

    /**
     * Checks if the given string is empty or null
     * @param value
     * @return boolean
     */
    public static boolean isBlank(String value) {
        return value.equals(null) || value.trim().isEmpty();
    }

    /**
     * Transforms the given name to a wikirate friendly one
     * @param name
     * @return
     */
    public static String transformToWikiRateFriendlyName(String name) {
        return name.replace(",", " ")
                .replace(".", " ")
                .replace("/", " ")
                .replace("-", " ")
                .replace("(", " ")
                .replace(")", " ")
                .replace("&", " ")
                .replace(";", " ")
                .replace("@", " ")
                .replace("#", " ")
                .replace("^", " ")
                .replace("!", " ")
                .replace("=", " ")
                .replace("'", " ")
                .replace("\"", " ")
                .replace("%", " ")
                .replace(" +", " ").trim()
                .replace(" ", "_");
    }
}
