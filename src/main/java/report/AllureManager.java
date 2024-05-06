package report;

import org.openqa.selenium.TakesScreenshot;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

import Utils.BrowserInfoUtils;
import Utils.LogUtils;
import constants.FrameworkConstants;
import driver.DriverManager;
import enums.Browser;
import helpers.FileHelpers;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import static org.openqa.selenium.OutputType.BYTES;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;

public class AllureManager {

	private AllureManager() {
	}

	public static void setAllureEnvironmentInformation() {
		AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.<String, String>builder()
				.put("Test URL", FrameworkConstants.URL_CRM).put("Target Execution", FrameworkConstants.TARGET)
				.put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT))
				.put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED))
				.put("Headless Mode", FrameworkConstants.HEADLESS).put("Local Browser", String.valueOf(Browser.CHROME))
				.put("Remote URL", FrameworkConstants.REMOTE_URL).put("Remote Port", FrameworkConstants.REMOTE_PORT)
				.build());

		System.out.println("Allure Reports is installed.");

	}

	@Attachment(value = "Failed test Screenshot", type = "image/png")
	public static byte[] takeScreenshotToAttachOnAllureReport() {
		try {
			return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new byte[0];
	}

	@Attachment(value = "Take step Screenshot", type = "image/png")
	public static byte[] takeScreenshotStep() {
		try {
			return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new byte[0];
	}

	@Attachment(value = "Browser Information", type = "text/plain")
	public static String addBrowserInformationOnAllureReport() {
		return BrowserInfoUtils.getOSInfo();
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	public static void addAttachmentVideoAVI() {
		if (FrameworkConstants.VIDEO_RECORD.toLowerCase().trim().equals(FrameworkConstants.YES)) {
			try {
				// Get file Last Modified in folder
				File video = FileHelpers.getFileLastModified("ExportData/Videos");
				if (video != null) {
					Allure.addAttachment("Failed test Video record AVI", "video/avi",
							Files.asByteSource(video).openStream(), ".avi");
				} else {
					LogUtils.warn("Video record not found.");
					LogUtils.warn("Can not attachment Video in Allure report");
				}

			} catch (IOException e) {
				LogUtils.error("Can not attachment Video in Allure report");
				e.printStackTrace();
			}
		}
	}

	public static void addAttachmentVideoMP4() {
		try {
			// Get file Last Modified in folder
			File video = FileHelpers.getFileLastModified("ExportData/Videos");
			if (video != null) {
				Allure.addAttachment("Failed test Video record MP4", "video/mp4",
						Files.asByteSource(video).openStream(), ".mp4");
			} else {
				LogUtils.warn("Video record not found.");
				LogUtils.warn("Can not attachment Video in Allure report");
			}

		} catch (IOException e) {
			LogUtils.error("Can not attachment Video in Allure report");
			e.printStackTrace();
		}
	}
}
