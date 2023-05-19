package org.mastercs.cyborg.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * Author: cyborg
 * Create: 2023/5/18 10:31
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HardwareInfoSupplier {

    private static final SystemInfo SYSTEM_INFO = new SystemInfo();

    private static final int BYTE_TO_GB = 1024 * 1024 * 1024;

    public static LocalDateTime getBootTime() {
        long systemBootTime = SYSTEM_INFO.getOperatingSystem().getSystemBootTime();
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(systemBootTime), ZoneId.systemDefault());
    }

    public static long getUsageDiskStore() {
        FileSystem fileSystem = SYSTEM_INFO.getOperatingSystem().getFileSystem();
        List<OSFileStore> fileStores = fileSystem.getFileStores();
        return fileStores.stream().mapToLong(item -> item.getTotalSpace() - item.getUsableSpace()).sum();
    }

    public static long getTotalDiskStore() {
        FileSystem fileSystem = SYSTEM_INFO.getOperatingSystem().getFileSystem();
        List<OSFileStore> fileStores = fileSystem.getFileStores();
        return fileStores.stream().mapToLong(OSFileStore::getTotalSpace).sum();
    }

    public static long getTotalMemory() {
        GlobalMemory memory = SYSTEM_INFO.getHardware().getMemory();
        return memory.getTotal();
    }

    public static long getUsageMemory() {
        GlobalMemory memory = SYSTEM_INFO.getHardware().getMemory();
        return memory.getTotal() - memory.getAvailable();
    }

    public static long getUsageDiskStoreInGB() {
        return getUsageDiskStore() / BYTE_TO_GB;
    }

    public static long getTotalDiskStoreInGB() {
        return getTotalDiskStore() / BYTE_TO_GB;
    }

    public static long getTotalMemoryInGB() {
        return getTotalMemory() / BYTE_TO_GB;
    }

    public static long getUsageMemoryInGB() {
        return getUsageMemory() / BYTE_TO_GB;
    }
}
