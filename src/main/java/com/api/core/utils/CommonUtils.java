package com.api.core.utils;

public class CommonUtils {
    private CommonUtils() {
    }

    public static boolean isTimestampCreationLessThanNow(long timeStamp, long now) {
        return timeStamp < now;
    }
}
