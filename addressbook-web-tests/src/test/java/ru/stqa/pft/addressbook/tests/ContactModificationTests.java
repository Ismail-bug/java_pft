package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactUpdateData;


public class ContactModificationTests extends TestBase{
    @Test
    public void testContactMofidication(){
app.getContactHelper().editContactd();
app.getContactHelper().fillContactUpdate(new ContactUpdateData("Is", "Mail", "Ya", "Is", "OOO", "Flower", "Moscow", "3277723", "89999999999", "88888888888", "31258123", "test@test.test", "test2@test.test", "test3@test.test", "myhomepage.test", "10", "January", "1901", "18", "January", "1901",  "Eu", "nothing", "Pakistan"));
app.getContactHelper().updateContact();
app.getContactHelper().returnToHomePage();

    }
}
