package com.logic.servlet;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.task.PostMainResourceTask;

public class MockServlet extends HttpServlet {
    private static final long serialVersionUID = -2492471543198697167L;

    private final Executor executor = new ScheduledThreadPoolExecutor(100);

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String count = req.getParameter("count");
        String url = req.getParameter("url");
        doPostRequest(url, Integer.valueOf(count));
    }

    private void doPostRequest(String url, int count) {
        if (count <= 0) {
            return;
        }

        for (int i = 0; i < count; i++) {
            executor.execute(new PostMainResourceTask(url, UUID.randomUUID().toString()));
        }
    }
}
