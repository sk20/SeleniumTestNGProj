package exceptions;

public class InvalidPathForExtentReportFileException extends InvalidPathForFilesException {

	public InvalidPathForExtentReportFileException(String message) {
		super(message);
	}

	public InvalidPathForExtentReportFileException(String message, Throwable cause) {
		super(message, cause);
	}
}
