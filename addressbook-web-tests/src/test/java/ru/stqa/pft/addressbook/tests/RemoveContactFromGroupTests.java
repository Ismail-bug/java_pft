package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {
    private Contacts contacts;
    private Groups groups;

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Isa").withMiddlename("Mail").withLastname("Ya").withNick("Isa").withTitle("OOO").withCompany("Flower").withAddress("Moscow").withHomeaddress("3277723").withMobilenumber("89999999999").withWorknumber("88888888888").withFax("31258123").withMail("test@test.test").withReservemail("test2@test.test").withExtramail("test3@test.test").withDomen("myhomepage.test").withBirthday("10").withBirthdaymonth("January").withBirthdayyear("1901").withAnniversaryday("18").withAnniversarymonth("January").withAnniversaryyear("1901").withReserveaddress("Eu").withNotes("nothing").withSecondhome("Pakistan"), true);
        }

        ContactData contact = app.db().contacts().iterator().next();
        if (contact.getGroups().size() == 0) {
            GroupData group = app.db().groups().iterator().next();
            app.goTo().gotoHomePage();
            app.contact().addContactToGroup(contact, group);
        }
    }

    @Test
    public void testRemoveContactFromGroup() {
        contacts = app.db().contacts();
        groups = app.db().groups();
        ContactData cRemove = contacts.iterator().next();
        GroupData gRemove = groups.iterator().next();
        app.goTo().gotoHomePage();
        app.contact().contactGroupPage(cRemove);
        app.contact().removeFromGroup(cRemove);
        assertThat(cRemove.getGroups(), not(cRemove));
        assertThat(gRemove.getContacts(), not(gRemove));
    }
}

