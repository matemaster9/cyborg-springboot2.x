package org.mastercs.cyborg.test;

import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.hardware.*;

import java.util.Arrays;
import java.util.List;

/**
 * Author: cyborg
 * Create: 2023/5/18 10:48
 */
public class OSHITests {


    @Test
    void test() {
        // 创建一个SystemInfo对象
        SystemInfo si = new SystemInfo();

        // 获取HardwareAbstractionLayer对象
        HardwareAbstractionLayer hal = si.getHardware();

        // 获取并打印CPU信息
        CentralProcessor processor = hal.getProcessor();
        System.out.println("Physical CPU count: " + processor.getPhysicalProcessorCount());
        System.out.println("Logical CPU count: " + processor.getLogicalProcessorCount());

        // 获取并打印内存信息
        GlobalMemory memory = hal.getMemory();
        System.out.println("Total memory: " + memory.getTotal());
        System.out.println("Available memory: " + memory.getAvailable());

        // 获取并打印每个磁盘的信息
        List<HWDiskStore> diskStores = hal.getDiskStores();
        for (HWDiskStore ds : diskStores) {
            System.out.println("Disk name: " + ds.getName());
            System.out.println("Disk size: " + ds.getSize());
        }

        // 获取并打印每个网络接口的信息
        List<NetworkIF> networkIFs = hal.getNetworkIFs();
        for (NetworkIF net : networkIFs) {
            System.out.println("Network interface name: " + net.getName());
            System.out.println("IPv4 address: " + Arrays.toString(net.getIPv4addr())); // assuming there's at least one IPv4 address
        }
    }

    @Test
    void display() {
        // 创建一个SystemInfo对象
        SystemInfo si = new SystemInfo();

        // 获取HardwareAbstractionLayer对象
        HardwareAbstractionLayer hal = si.getHardware();

        List<Display> displays = hal.getDisplays();
        for (Display display : displays) {
            System.out.println(display);
        }
    }

    @Test
    void cards() {
        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();

        hal.getSoundCards().forEach(System.out::println);

        hal.getGraphicsCards().forEach(System.out::println);

    }


    @Test
    void memory() {
        // 创建SystemInfo对象
        SystemInfo si = new SystemInfo();

        // 从SystemInfo对象中获取硬件抽象层对象
        HardwareAbstractionLayer hal = si.getHardware();

        // 从硬件抽象层对象中获取全局内存对象
        GlobalMemory memory = hal.getMemory();

        // 打印可用内存，单位为MB
        System.out.println("Available memory: " + memory.getAvailable() / 1024 / 1024 + " MB");

        // 打印总内存，单位为MB
        System.out.println("Total memory: " + memory.getTotal() / 1024 / 1024 + " MB");

        // 打印虚拟内存，单位为MB
        System.out.println("Virtual memory: " + memory.getVirtualMemory().getVirtualMax() / 1024 / 1024 + " MB");

        // 打印物理内存，单位为MB
        System.out.println("Physical memory: " + memory.getTotal() / 1024 / 1024 + " MB");

        // 打印页面大小，单位为字节
        System.out.println("Page size: " + memory.getPageSize() + " bytes");

    }


    @Test
    void diskStore() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
    }

}
