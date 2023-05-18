package org.mastercs.cyborg.test;

import lombok.var;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class OperatingSystemTests {

    @Test
    void fileSystem() {
        var systemInfo = new SystemInfo();
        var os = systemInfo.getOperatingSystem();
        var fileSystem = os.getFileSystem();
        var fileStores = fileSystem.getFileStores();

        // 计算所有文件存储的总空间，单位为字节
        long totalSpace = fileStores.stream().mapToLong(OSFileStore::getTotalSpace).sum();

        // 计算所有文件存储的可用空间，单位为字节
        long usableSpace = fileStores.stream().mapToLong(OSFileStore::getUsableSpace).sum();

        // 打印所有文件存储的总空间，单位为GB
        System.out.println("Total disk space: " + totalSpace / 1024 / 1024 / 1024 + " GB");

        // 打印所有文件存储的可用空间，单位为GB
        System.out.println("Usable disk space: " + usableSpace / 1024 / 1024 / 1024 + " GB");
    }

    @Test
    void bootTime() {
        OperatingSystem operatingSystem = new SystemInfo().getOperatingSystem();
        long systemBootTime = operatingSystem.getSystemBootTime();
        LocalDateTime boot = LocalDateTime.ofInstant(Instant.ofEpochSecond(systemBootTime), ZoneId.systemDefault());
        System.out.println(boot);
        System.out.println(boot.toLocalDate());
    }
}
