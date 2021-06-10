package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void createNewContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNick());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeaddress());
        type(By.name("mobile"), contactData.getMobilenumber());
        type(By.name("work"), contactData.getWorknumber());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getMail());
        type(By.name("email2"), contactData.getReservemail());
        type(By.name("email3"), contactData.getExtramail());
        type(By.name("homepage"), contactData.getDomen());
        selectelement("bday", contactData.getBirthday());
        selectelement("bmonth", contactData.getBirthdaymonth());
        selectelement("bmonth", contactData.getBirthdaymonth());
        type(By.name("byear"), contactData.getBirthdayyear());
        selectelement("aday", contactData.getAnniversaryday());
        selectelement("amonth", contactData.getAnniversarymonth());
        type(By.name("ayear"), contactData.getAnniversaryyear());
        selectelement("new_group", contactData.getSelectgroup());
        type(By.name("address2"), contactData.getReserveaddress());
        type(By.name("phone2"), contactData.getSecondhome());
        type(By.name("notes"), contactData.getNotes());
    }
}