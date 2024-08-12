package com.sa1zer.logstarter.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class HttpUtils {


    public static Map<String, List<String>> getRequestHeaders(HttpServletRequest request) {
        Map<String, List<String>> map = new HashMap<>();

        Collections.list(request.getHeaderNames()).forEach(header -> {
            map.put(header, Collections.list(request.getHeaders(header)));
        });

        return map;
    }

    public static Map<String, List<String>> getResponseHeaders(HttpServletResponse request) {
        Map<String, List<String>> map = new HashMap<>();

        request.getHeaderNames().forEach(header -> {
            map.put(header, request.getHeaders(header).stream().toList());
        });

        return map;
    }

    public static String getRequestHeadersAsString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();

        getRequestHeaders(request).forEach((k, v) -> {
            sb.append(k).append(": ");
            sb.append(String.join(", ", v));
            sb.append("\n");
        });

        return sb.toString();
    }

    public static String getResponseHeadersAsString(HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();

        getResponseHeaders(response).forEach((k, v) -> {
            sb.append(k).append(": ");
            sb.append(String.join(", ", v));
            sb.append("\n");
        });

        return sb.toString();
    }
}
