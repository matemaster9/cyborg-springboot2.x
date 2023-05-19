package org.mastercs.cyborg.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DashboardVO {

    /**
     * cpu总核数
     */
    private Long cpuTotalCore;

    /**
     * cpu可用核数
     */
    private Long cpuUsageCore;

    /**
     * 开机时间
     */
    private String bootTime;

    /**
     * 已使用内存
     */
    private Long usageMemory;

    /**
     * 总内存
     */
    private Long totalMemory;

    /**
     * 已使用磁盘
     */
    private Long usageDiskStore;

    /**
     * 总磁盘
     */
    private Long totalDiskStore;
}