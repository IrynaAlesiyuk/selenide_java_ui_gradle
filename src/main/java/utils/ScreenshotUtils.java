package utils;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {


    public static void createFolderIfNotExists(String folderName) {
        File folder = new File(folderName);
        if (!folder.exists()) folder.mkdirs();
    }

    public static String getScreenshotName(String baseName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        return baseName + "_" + timestamp;
    }


}
