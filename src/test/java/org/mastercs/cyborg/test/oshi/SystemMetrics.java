package org.mastercs.cyborg.test.oshi;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

import java.util.List;

public class SystemMetrics {

    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        // 获取并打印CPU使用率
        CentralProcessor processor = hal.getProcessor();
        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(processor.getSystemCpuLoadTicks());
        int cpuUsagePercent = (int) (cpuLoad * 100);
        System.out.println("CPU使用率: " + cpuUsagePercent+ "%");

        // 获取并打印内存使用率
        GlobalMemory memory = hal.getMemory();
        long availableMemory = memory.getAvailable();
        long totalMemory = memory.getTotal();
        int memoryUsage = (int) ((1 - (double) availableMemory / totalMemory) * 100);
        System.out.println("内存使用率: " + memoryUsage + "%");

        // 获取并打印磁盘使用率
        FileSystem fileSystem = si.getOperatingSystem().getFileSystem();
        List<OSFileStore> fileStores = fileSystem.getFileStores();
        long totalSpace = fileStores.stream().mapToLong(OSFileStore::getTotalSpace).sum();
        long usableSpace = fileStores.stream().mapToLong(OSFileStore::getUsableSpace).sum();
        int diskStoreUsage = (int) ((1 - (double) usableSpace / totalSpace) * 100);
        System.out.println("磁盘使用率: " + diskStoreUsage + "%");
    }
}
