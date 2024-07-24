package com.hello_events.Controleurs;

import com.hello_events.Entites.Dashboard;
import com.hello_events.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public Dashboard getDashboardMetrics() {
        return dashboardService.getDashboardMetrics();
    }
}
