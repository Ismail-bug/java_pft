package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void createNewContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
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
        if (creation) {
            selectelement("new_group", contactData.getSelectgroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }
        type(By.name("address2"), contactData.getReserveaddress());
        type(By.name("phone2"), contactData.getSecondhome());
        type(By.name("notes"), contactData.getNotes());
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmationDeletionContacts() {
        wd.switchTo().alert().accept();
    }

    public void editContact(int index) {

       wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void create(ContactData contact, boolean creation) {
        goToNewContact();
        fillContactForm(contact, creation);
        createNewContact();
        returnToHomePage();
    }
    public void edit(List<ContactData> before, ContactData contact) {
        editContact(before.size()-1);
        fillContactForm(contact,false);
        updateContact();
        returnToHomePage();
    }
    public void deletecontact(List<ContactData> before) {
        selectContact(before.size() - 1);
        deleteSelectedContacts();
        confirmationDeletionContacts();
        returnToHomePage();
    }

    private void goToNewContact() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
                && isElementPresent(By.name("submit"))) {
            return;
        }
        click(By.linkText("add new"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        List<WebElement> cellsLasttname = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[2]"));
        List<WebElement> cellsFirstname = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[3]"));
        for (int i = 0; i < elements.size() ; i++) {
            String lastname = cellsLasttname.get(i).getText();
            String firstname = cellsFirstname.get(i).getText();
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstname( firstname).withLastname( lastname);
            contacts.add(contact);
        }
        return contacts;
    }
}

