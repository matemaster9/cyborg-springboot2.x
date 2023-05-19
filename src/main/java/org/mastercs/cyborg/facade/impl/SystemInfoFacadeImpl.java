package org.mastercs.cyborg.facade.impl;

import lombok.RequiredArgsConstructor;
import org.mastercs.cyborg.facade.SystemInfoFacade;
import org.mastercs.cyborg.model.DashboardVO;
import org.mastercs.cyborg.service.SystemInfoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemInfoFacadeImpl implements SystemInfoFacade {

    private final SystemInfoService systemInfoService;

    @Override
    public DashboardVO getDashboard() {
        return systemInfoService.getDashboard();
    }
}
