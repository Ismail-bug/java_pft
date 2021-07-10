package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size()==0){
            app.contact().create(new ContactData()
                    .withFirstname("Isa").withMiddlename( "Mail").withLastname( "Ya").withNick( "Isa").withTitle( "OOO").withCompany( "Flower").withAddress( "Moscow").withHomeaddress( "3277723").withMobilenumber( "89999999999").withWorknumber( "88888888888").withFax( "31258123").withMail( "test@test.test").withReservemail( "test2@test.test").withExtramail( "test3@test.test").withDomen( "myhomepage.test").withBirthday( "10").withBirthdaymonth( "January").withBirthdayyear( "1901").withAnniversaryday( "18").withAnniversarymonth( "January").withAnniversaryyear( "1901").withSelectgroup( "test1").withReserveaddress( "Eu").withNotes( "nothing").withSecondhome( "Pakistan"),true);
        }
    }
    @Test
    public void testContactDeletion() {

        List<ContactData> before = app.contact().list();
        app.contact().deletecontact(before);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(before.size()-1);
            Assert.assertEquals(after,before);
        }


}
