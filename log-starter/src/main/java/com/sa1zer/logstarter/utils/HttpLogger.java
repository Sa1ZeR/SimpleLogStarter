package com.sa1zer.logstarter.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HttpLogger {

   public static String httpLoggerBuild(String uri, String method, String requestHeaders,
                                        String responseHeaders, int responseStatus, long startTime, long endTime) {

       return String.format("Request uri: %s \n", uri) +
               String.format("Request method: %s \n", method) +
               String.format("Request headers: %s \n", requestHeaders) +
               String.format("Response headers: %s \n", responseHeaders) +
               String.format("Request duration: %s ms \n", endTime - startTime) +
               String.format("Response status %s \n", responseStatus);
   }
}
