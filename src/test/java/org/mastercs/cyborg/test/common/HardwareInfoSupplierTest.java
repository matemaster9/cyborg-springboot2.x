package org.mastercs.cyborg.test.common;

import org.junit.jupiter.api.Test;
import org.mastercs.cyborg.common.HardwareInfoSupplier;

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
}