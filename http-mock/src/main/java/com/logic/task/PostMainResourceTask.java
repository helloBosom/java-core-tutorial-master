package com.logic.task;

import java.util.HashMap;
import java.util.Map;

import com.logic.service.HttpClientService;

public class PostMainResourceTask implements Runnable {
    private final String url;

    private final String taskId;

    public PostMainResourceTask(String url, String taskId) {
        this.url = url;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        Map<String, String> reqBody = new HashMap<String, String>();
        reqBody.put("taskId", taskId);
        HttpClientService.newInstance().post(url, HttpClientService.ContentType.FORM_URLENCOED, reqBody);
    }
}
