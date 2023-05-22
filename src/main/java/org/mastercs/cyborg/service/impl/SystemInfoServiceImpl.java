package org.mastercs.cyborg.service.impl;

import lombok.RequiredArgsConstructor;
import org.mastercs.cyborg.common.HardwareInfoSupplier;
import org.mastercs.cyborg.model.DashboardVO;
import org.mastercs.cyborg.service.SystemInfoService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class SystemInfoServiceImpl implements SystemInfoService {


    @Override
    public DashboardVO getDashboard() {
        DashboardVO dashboardVO = new DashboardVO();
        dashboardVO.setBootTime(HardwareInfoSupplier.getBootTime().format(DateTimeFormatter.ISO_DATE));
        dashboardVO.setTotalMemory(HardwareInfoSupplier.getTotalMemoryInGB());
        dashboardVO.setUsageMemory(HardwareInfoSupplier.getUsageMemoryInGB());
        dashboardVO.setTotalDiskStore(HardwareInfoSupplier.getTotalDiskStoreInGB());
        dashboardVO.setUsageDiskStore(HardwareInfoSupplier.getUsageDiskStoreInGB());
        return dashboardVO;
    }
}
