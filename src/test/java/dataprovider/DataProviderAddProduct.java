package dataprovider;

import org.testng.annotations.DataProvider;

import constants.FrameworkConstants;
import helpers.ExcelHelpers;
import helpers.Helpers;

public class DataProviderAddProduct {
	@DataProvider(name = "data_provider_add_product")
    public Object[][] dataAddProduct() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_CMS_DATA, "AddProduct", 2, 2);
        return data;
    }
}
