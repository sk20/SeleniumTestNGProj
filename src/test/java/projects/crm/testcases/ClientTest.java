package projects.crm.testcases;

import annotations.FrameworkAnnotation;
import common.BaseClass;
import dataprovider.DataProviderManager;
import enums.AuthorType;
import enums.CategoryType;

import static keywords.WebUI.*;

import projects.crm.pages.Clients.ClientPageCRM;
import projects.crm.pages.Dashboard.DashboardPageCRM;
import projects.crm.pages.SignIn.SignInPageCRM;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Client Test")
public class ClientTest extends BaseClass {

    SignInPageCRM signInPageCRM;
    DashboardPageCRM dashboardPageCRM;
    ClientPageCRM clientPageCRM;

    public ClientTest() {
        signInPageCRM = new SignInPageCRM();
    }

    @FrameworkAnnotation(author = {AuthorType.AnhTester, AuthorType.AnVo}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "TC05_testAddClient", dataProvider = "getClientDataHashTable", dataProviderClass = DataProviderManager.class)
    public void testAddClient(Hashtable<String, String> data) {
        dashboardPageCRM = signInPageCRM.signInWithAdminRole();
        clientPageCRM = dashboardPageCRM.openClientPage();
        clientPageCRM.openClientTabPage();
        clientPageCRM.addClient(data);
    }

    @FrameworkAnnotation(author = {AuthorType.James}, category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 2, description = "TC06_testSearchClient")
    public void testSearchClient() {
        dashboardPageCRM = signInPageCRM.signInWithAdminRole();
        clientPageCRM = dashboardPageCRM.openClientPage();
        clientPageCRM.openClientTabPage();
        // Search the first
        clientPageCRM.enterDataSearchClient("Adrain Ondricka");
        checkContainsValueOnTableByColumn(2, "Adrain Ondricka");
        // Search the second
        clientPageCRM.enterDataSearchClient("Birdie Erdman");
        checkContainsValueOnTableByColumn(2, "Birdie Erdman");

    }

}
