package utils;

import aquality.selenium.browser.AqualityServices;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadFileUtils {

    public static void fileUpload(String path) {
        File file = new File("");
        File dir = new File(String.format("%s%s",file.getAbsoluteFile(), path));
        StringSelection sel = new StringSelection(dir.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
