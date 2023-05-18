package org.mastercs.cyborg.test;

import lombok.var;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;

public class GlobalMemoryTests {

    @Test
    void memory() {
        var si = new SystemInfo();
        var memory = si.getHardware().getMemory();

        // 获取系统的总内存，单位为字节
        long total = memory.getTotal();

        // 获取系统的可用内存，单位为字节
        long available = memory.getAvailable();

        // 打印系统的总内存，单位为GB
        System.out.println("Total memory: " + total / 1024 / 1024 / 1024 + " GB");

        // 打印系统的可用内存，单位为GB
        System.out.println("Available memory: " + available / 1024 / 1024 / 1024 + " GB");
    }
}
