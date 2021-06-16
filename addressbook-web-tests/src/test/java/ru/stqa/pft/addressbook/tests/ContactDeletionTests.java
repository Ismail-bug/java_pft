package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Isa", "Mail", "Ya", "Isa", "OOO", "Flower", "Moscow", "3277723", "89999999999", "88888888888", "31258123", "test@test.test", "test2@test.test", "test3@test.test", "myhomepage.test", "10", "January", "1901", "18", "January", "1901","test1","Eu", "nothing", "Pakistan"),true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().confirmationDeletionContacts();
        app.getContactHelper().returnToHomePage();
    }
}
