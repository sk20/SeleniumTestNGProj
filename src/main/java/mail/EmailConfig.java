package mail;


import static constants.FrameworkConstants.REPORT_TITLE;

public class EmailConfig {

	public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "anhtester@email.com";
    public static final String PASSWORD = "******";

    public static final String[] TO = {"anhtester@mailinator.com"};
    public static final String SUBJECT = REPORT_TITLE;
}
