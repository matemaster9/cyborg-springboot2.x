package org.mastercs.cyborg.controller;

import lombok.RequiredArgsConstructor;
import org.mastercs.cyborg.facade.SystemInfoFacade;
import org.mastercs.cyborg.model.DashboardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system-info")
@RequiredArgsConstructor
public class SystemInfoController {

    private final SystemInfoFacade systemInfoFacade;

    @GetMapping("/getDashboard")
    public DashboardVO getDashboard() {
        return systemInfoFacade.getDashboard();
    }
}
