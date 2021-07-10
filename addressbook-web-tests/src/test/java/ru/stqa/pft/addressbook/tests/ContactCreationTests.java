package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                .withFirstname("Isa").withMiddlename( "Mail").withLastname( "Ya").withNick( "Isa").withTitle( "OOO").withCompany( "Flower").withAddress( "Moscow").withHomeaddress( "3277723").withMobilenumber( "89999999999").withWorknumber( "88888888888").withFax( "31258123").withMail( "test@test.test").withReservemail( "test2@test.test").withExtramail( "test3@test.test").withDomen( "myhomepage.test").withBirthday( "10").withBirthdaymonth( "January").withBirthdayyear( "1901").withAnniversaryday( "18").withAnniversarymonth( "January").withAnniversaryyear( "1901").withSelectgroup( "test1").withReserveaddress( "Eu").withNotes( "nothing").withSecondhome( "Pakistan");
        app.contact().create((contact), true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1,c2)->Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
