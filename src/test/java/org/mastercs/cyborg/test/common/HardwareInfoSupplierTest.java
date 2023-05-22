package org.mastercs.cyborg.test.common;

import org.junit.jupiter.api.Test;
import org.mastercs.cyborg.common.HardwareInfoSupplier;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

class HardwareInfoSupplierTest {

    @Test
    void getUsageDiskStoreInGB() {
        System.out.println(HardwareInfoSupplier.getUsageDiskStoreInGB());
    }

    @Test
    void getTotalDiskStoreInGB() {
        System.out.println(HardwareInfoSupplier.getTotalDiskStoreInGB());
    }

    @Test
    void getTotalMemoryInGB() {
        System.out.println(HardwareInfoSupplier.getTotalMemoryInGB());
    }

    @Test
    void getUsageMemoryInGB() {
        System.out.println(HardwareInfoSupplier.getUsageMemoryInGB());
    }

    @Test
    void getBootTime() {
        System.out.println(HardwareInfoSupplier.getBootTime());
    }

    @Test
    void getMemoryUsage() {
        long usageMemory = HardwareInfoSupplier.getUsageMemory();
        long totalMemory = HardwareInfoSupplier.getTotalMemory();
        double proportion = (double) usageMemory / totalMemory;
        System.out.println((int) (proportion * 100));
        System.out.println(usageMemory);
        System.out.println(totalMemory);
    }

    @Test
    void getCPUUsage() {
        CentralProcessor processor = new SystemInfo().getHardware().getProcessor();
        double proportion = processor.getSystemCpuLoadBetweenTicks(processor.getSystemCpuLoadTicks());
        System.out.println((int) (proportion * 100));
    }
}