package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class AddContactToGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Isa").withMiddlename("Mail").withLastname("Ya").withNick("Isa").withTitle("OOO").withCompany("Flower").withAddress("Moscow").withHomeaddress("3277723").withMobilenumber("89999999999").withWorknumber("88888888888").withFax("31258123").withMail("test@test.test").withReservemail("test2@test.test").withExtramail("test3@test.test").withDomen("myhomepage.test").withBirthday("10").withBirthdaymonth("January").withBirthdayyear("1901").withAnniversaryday("18").withAnniversarymonth("January").withAnniversaryyear("1901").withReserveaddress("Eu").withNotes("nothing").withSecondhome("Pakistan"), true);
        }
    }


    @Test
    public void testAddContactToGroup() {


        GroupData gBefore = app.db().groups().iterator().next();
        int gBeforeId = gBefore.getId();
        ContactData cBefore = new ContactData();
        if (app.db().contacts().size() == gBefore.getContacts().size()) {
            app.contact().create(new ContactData().withFirstname("Isa").withMiddlename("Mail").withLastname("Ya").withNick("Isa").withTitle("OOO").withCompany("Flower").withAddress("Moscow").withHomeaddress("3277723").withMobilenumber("89999999999").withWorknumber("88888888888").withFax("31258123").withMail("test@test.test").withReservemail("test2@test.test").withExtramail("test3@test.test").withDomen("myhomepage.test").withBirthday("10").withBirthdaymonth("January").withBirthdayyear("1901").withAnniversaryday("18").withAnniversarymonth("January").withAnniversaryyear("1901").withReserveaddress("Eu").withNotes("nothing").withSecondhome("Pakistan"), true);
        }
        for (ContactData contact : app.db().contacts()) {
            if (!gBefore.getContacts().contains(contact)) {
                cBefore = contact;
            }
        }
        app.goTo().gotoHomePage();
        app.contact().addContactToGroup(cBefore, gBefore);
        app.goTo().gotoHomePage();
        Groups allGroups = app.db().groups();
        for (GroupData group : allGroups) {
            if (group.getId() == gBeforeId) {
                gBefore = group;
            }
        }
        assertThat(gBefore.getContacts(), hasItem(cBefore));
    }
}

