package com.example.intern_task;

public class ApiUtils {

    public static final String BASE_URL = "https://mekvahan.com/api/android_intern_task";

    public static UsrSrvc getUserService(){
        return RetroClient.getClient(BASE_URL).create(UsrSrvc.class);
    }

}
