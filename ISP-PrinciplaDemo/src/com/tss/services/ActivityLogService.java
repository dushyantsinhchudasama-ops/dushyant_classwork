package com.tss.services;

import java.util.ArrayList;
import java.util.List;

public class ActivityLogService
{
    private List<String> logs;

    public ActivityLogService()
    {
        logs = new ArrayList<>();
    }

    public void addLog(String activity)
    {
        logs.add(activity);
    }

    public void showLogs()
    {
        for (String log : logs)
        {
            System.out.println(log);
        }
    }
}
