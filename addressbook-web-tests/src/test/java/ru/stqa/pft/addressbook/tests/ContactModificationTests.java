package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactModificationTests extends TestBase {
    @Test
    public void testContactMofidication() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Isa", "Mail", "Ya", "Isa", "OOO", "Flower", "Moscow", "3277723", "89999999999", "88888888888", "31258123", "test@test.test", "test2@test.test", "test3@test.test", "myhomepage.test", "10", "January", "1901", "18", "January", "1901", "test1", "Eu", "nothing", "Pakistan"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Is", "Mail", "Ya", "Is", "OOO", "Flower", "Moscow", "3277723", "89999999999", "88888888888", "31258123", "test@test.test", "test2@test.test", "test3@test.test", "myhomepage.test", "10", "January", "1901", "18", "January", "1901", null, "Eu", "nothing", "Pakistan");
        app.getContactHelper().fillContactForm((contact),false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1,c2)->Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
