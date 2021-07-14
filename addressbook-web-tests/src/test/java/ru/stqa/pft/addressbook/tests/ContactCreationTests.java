package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Isa").withMiddlename("Mail").withLastname("Ya").withNick("Isa").withTitle("OOO").withCompany("Flower").withAddress("Moscow").withHomeaddress("3277723").withMobilenumber("89999999999").withWorknumber("88888888888").withFax("31258123").withMail("test@test.test").withReservemail("test2@test.test").withExtramail("test3@test.test").withDomen("myhomepage.test").withBirthday("10").withBirthdaymonth("January").withBirthdayyear("1901").withAnniversaryday("18").withAnniversarymonth("January").withAnniversaryyear("1901").withSelectgroup("test1").withReserveaddress("Eu").withNotes("nothing").withSecondhome("Pakistan");
        app.contact().create((contact), true);
        assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
