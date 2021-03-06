package com.api.core.utils;

public class CommonUtils {
    private CommonUtils() {
    }

    public static boolean verifyTimestampCreationIsLessThanNow(long timeStamp, long now) {
        return timeStamp < now;
    }
}
