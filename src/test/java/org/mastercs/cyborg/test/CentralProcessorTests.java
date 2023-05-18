package org.mastercs.cyborg.test;

import lombok.var;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;

public class CentralProcessorTests {


    @Test
    void CPUCore() {
        var si = new SystemInfo();
        var cp = si.getHardware().getProcessor();

        int physicalPackageCount = cp.getPhysicalPackageCount();
        System.out.println(physicalPackageCount);
    }
}
