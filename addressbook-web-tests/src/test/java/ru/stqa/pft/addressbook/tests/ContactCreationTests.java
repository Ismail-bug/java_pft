package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Isa").withMiddlename( "Mail").withLastname( "Ya").withNick( "Isa").withTitle( "OOO").withCompany( "Flower").withAddress( "Moscow").withHomeaddress( "3277723").withMobilenumber( "89999999999").withWorknumber( "88888888888").withFax( "31258123").withMail( "test@test.test").withReservemail( "test2@test.test").withExtramail( "test3@test.test").withDomen( "myhomepage.test").withBirthday( "10").withBirthdaymonth( "January").withBirthdayyear( "1901").withAnniversaryday( "18").withAnniversarymonth( "January").withAnniversaryyear( "1901").withSelectgroup( "test1").withReserveaddress( "Eu").withNotes( "nothing").withSecondhome( "Pakistan");
        app.contact().create((contact), true);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    }
}
