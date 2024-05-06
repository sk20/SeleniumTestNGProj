package projects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import projects.cms.brands.BrandPage;
import projects.cms.category.CategoryPage;
import projects.cms.login.LoginPageCMS;
import projects.cms.products.AddProductPage;
import projects.cms.user.pages.order.OrderPage;
import projects.cms.user.pages.products.ProductInfoPageCMS;
import projects.cms.user.pages.profiles.ProfilePage;

import static keywords.WebUI.*;

public class CommonPageCMS {

	private LoginPageCMS loginPage;
    private AddProductPage addProductPage;
    private ProfilePage profilePage;
    private ProductInfoPageCMS productInfoPage;
    private OrderPage orderPage;
    
    public LoginPageCMS getLoginPageCMS() {
        if (loginPage == null) {
            loginPage = new LoginPageCMS();
        }
        return loginPage;
    }

    public ProfilePage getProfilePage() {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        return profilePage;
    }

    public OrderPage getOrderPage() {
        if (orderPage == null) {
            orderPage = new OrderPage();
        }
        return orderPage;
    }

    public AddProductPage getAddProductPage() {
        if (addProductPage == null) {
            addProductPage = new AddProductPage();
        }
        return addProductPage;
    }

    public ProductInfoPageCMS getProductInfoPage() {
        if (productInfoPage == null) {
            productInfoPage = new ProductInfoPageCMS();
        }
        return productInfoPage;
    }

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
//    private By menuBrand = By.xpath("//span[normalize-space()='Brand']");
//    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
//    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");
    private By messageNotify = By.xpath("//span[@data-notify='message']");
    private By buttonEdit = By.xpath("(//a[@title='Edit'])[1]");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");
    private By inputSearch = By.xpath("//input[@id='search']");
    public By avatarProfile = By.xpath("//span[contains(@class,'avatar avatar-sm')]");
    public By buttonCookies = By.xpath("//button[normalize-space()='Ok. I Understood']");


    public void enterDataOnSearchDataTable(String value) {
        setText(inputSearch, value, Keys.ENTER);
    }

    public void clickEditButton() {
        clickElement(buttonEdit);
    }
    public void clickSaveButton() {
        clickElement(buttonSave);
    }

    public String getMessageNotify() {
        return getTextElement(messageNotify);
    }

    public CommonPageCMS clickMenuProducts() {
        clickElement(menuProducts);
        return this;
    }

    public CategoryPage clickMenuCategory() {
        clickElement(menuCategory);
        return new CategoryPage();
    }

    public BrandPage clickMenuBrand() {
        clickElement(menuProducts);
        return new BrandPage();
    }
}
