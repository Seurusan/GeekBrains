package com.geekbrains.storage.server;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class Watcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("/Users/Redor/Documents/GB/watch");
        path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
        while (true) {
            WatchKey take = watchService.take();
            for (WatchEvent event : take.pollEvents()) {
                System.out.println("Event kind: " + event.kind() + " filename: " + event.context());
            }
            take.reset();
        }
    }
}
