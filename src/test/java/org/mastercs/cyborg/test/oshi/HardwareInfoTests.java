package org.mastercs.cyborg.test.oshi;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

public class HardwareInfoTests {


    @Test
    void cpuUsage() {
        OperatingSystemMXBean osmx = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double systemCpuLoad = osmx.getSystemCpuLoad();
        System.out.println((int) (systemCpuLoad * 100));
    }

    @Test
    void cpuCore() {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println(core);
    }
}
