package org.mastercs.cyborg.test.components;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class BootTimeFetcher {

    private static final SystemInfo SYSTEM_INFO = new SystemInfo();

    public static void main(String[] args) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();

        String command;
        if (os.contains("win")) {
            command = "wmic os get lastbootuptime";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            command = "cat /proc/stat | grep btime";
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + os);
        }

        Process process = Runtime.getRuntime().exec(command);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }


    public static LocalDateTime getBootTime() {
        OperatingSystem operatingSystem = SYSTEM_INFO.getOperatingSystem();
        long systemBootTime = operatingSystem.getSystemBootTime();
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(systemBootTime), ZoneId.systemDefault());
    }
}
