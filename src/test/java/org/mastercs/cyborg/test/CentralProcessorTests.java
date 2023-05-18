package org.mastercs.cyborg.test;

import lombok.var;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;


public class CentralProcessorTests {


    @Test
    void CPUCore() {
        var si = new SystemInfo();
        var cp = si.getHardware().getProcessor();

        int physicalPackageCount = cp.getPhysicalPackageCount();
        System.out.println(physicalPackageCount);
    }

    @Test
    void cpuLoad() {
        var si = new SystemInfo();
        var cp = si.getHardware().getProcessor();

        double systemCpuLoad = cp.getSystemCpuLoad(1);
        System.out.println(systemCpuLoad);
    }

    @Test
    void cpuLoad2() {
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        int physicalProcessorCount = processor.getPhysicalProcessorCount();
        double systemCpuLoad = processor.getSystemCpuLoad(10);
        System.out.println(physicalProcessorCount);
        System.out.println((int) (physicalProcessorCount * systemCpuLoad));
        System.out.println(systemCpuLoad);
    }
}
