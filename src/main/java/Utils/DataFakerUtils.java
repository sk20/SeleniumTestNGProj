package Utils;

import java.util.Locale;

import constants.FrameworkConstants;
import net.datafaker.Faker;

public class DataFakerUtils {

	private static Faker faker = null; //English US

    public static Faker getFaker() {
        if (faker == null) {
            faker = new Faker(new Locale(FrameworkConstants.LOCATE));
        }
        return faker;
    }

    public static void setFaker(Faker faker) {
        DataFakerUtils.faker = faker;
    }

    public static void setLocate(String LocateName) {
        faker = new Faker(new Locale(LocateName));
    }
}
