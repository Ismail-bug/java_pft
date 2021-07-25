package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class ContactHelper extends HelperBase {
    private Contacts contactCache = null;

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
        //attach(By.name("photo"), contactData.getPhoto());
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

        // if (creation) {
        //    selectelement("new_group", contactData.getSelectgroup());
        // } else {
        //      Assert.assertFalse(isElementPresent(By.name("new_group")));

        //  }
        type(By.name("address2"), contactData.getReserveaddress());
        type(By.name("phone2"), contactData.getSecondhome());
        type(By.name("notes"), contactData.getNotes());
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    private void editContactById(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void create(ContactData contact, boolean creation) {
        goToNewContact();
        fillContactForm(contact, creation);
        createNewContact();
        contactCache = null;
        returnToHomePage();
    }

    public void edit(List<ContactData> before, ContactData contact) {
        editContact(before.size() - 1);
        fillContactForm(contact, false);
        updateContact();
        returnToHomePage();
    }

    public void edit(ContactData contact) {
        editContactById(contact.getId());
        fillContactForm(contact, false);
        updateContact();
        contactCache = null;
        returnToHomePage();
    }

    public void deletecontact(List<ContactData> before) {
        selectContact(before.size() - 1);
        deleteSelectedContacts();
        confirmationDeletionContacts();
        returnToHomePage();
    }

    public void deletecontact(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        confirmationDeletionContacts();
        contactCache = null;
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
        for (int i = 0; i < elements.size(); i++) {
            String lastname = cellsLasttname.get(i).getText();
            String firstname = cellsFirstname.get(i).getText();
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        List<WebElement> cellsLasttname = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[2]"));
        List<WebElement> cellsFirstname = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[3]"));
        List<WebElement> cellsAllPhones = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[6]"));
        List<WebElement> cellsAdress = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[4]"));
        List<WebElement> cellsAllMails = wd.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr/td[5]"));
        for (int i = 0; i < elements.size(); i++) {
            String lastname = cellsLasttname.get(i).getText();
            String firstname = cellsFirstname.get(i).getText();
            String allPhones = cellsAllPhones.get(i).getText();
            String address = cellsAdress.get(i).getText();
            String allMails = cellsAllMails.get(i).getText();
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones).withAddress(address).withAllMails(allMails));
        }
        return new Contacts(contactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomeaddress(home).withMobilenumber(mobile).withWorknumber(work).withReserveaddress(phone2).withAddress(address).withMail(email).withReservemail(email2).withExtramail(email3);
    }

    public void addContactToGroup(ContactData contact, GroupData addToGroup) {
        selectContactById(contact.getId());
        selectGroupToAdd(addToGroup);
        addTo();
        goToAddGroupPage(addToGroup.getId());
    }

    public void goToAddGroupPage(int id) {
        wd.findElement(By.cssSelector("a[href='./?group=" + id + "']")).click();
    }

    private void addTo() {
        wd.findElement(By.name("add")).click();
    }

    private void selectGroupToAdd(GroupData group) {
        wd.findElement(By.name("to_group")).click();
        int id = group.getId();
        new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(group.getId()));
    }

    public void contactGroupPage(ContactData cRemove) {
        Select select = new Select(wd.findElement(By.name("group")));
        select.selectByVisibleText(cRemove.getGroups().iterator().next().getName());
    }

    public void removeFromGroup(ContactData cRemove) {
        Assert.assertEquals(cRemove.getGroups().size(), 1);
        selectContactById(cRemove.getId());
        click(By.name("remove"));
        confirmationRemoveGroup(cRemove);
    }

    private void confirmationRemoveGroup(ContactData cRemove) {
        wd.findElement(By.tagName("h1")).getText().equals("Groups");
        assertTrue(isElementPresent(By.linkText("group page \"" + cRemove.getGroups().iterator().next().getName() + "\"")));
    }
}


