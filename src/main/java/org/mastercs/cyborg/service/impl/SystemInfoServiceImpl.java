package org.mastercs.cyborg.service.impl;

import lombok.RequiredArgsConstructor;
import org.mastercs.cyborg.model.DashboardVO;
import org.mastercs.cyborg.service.SystemInfoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemInfoServiceImpl implements SystemInfoService {


    @Override
    public DashboardVO getDashboard() {
        DashboardVO dashboardVO = new DashboardVO();
        return dashboardVO;
    }
}
