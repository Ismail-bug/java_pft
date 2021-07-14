package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {
    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Isa").withMiddlename("Mail").withLastname("Ya").withNick("Isa").withTitle("OOO").withCompany("Flower").withAddress("Moscow").withHomeaddress("3277723").withMobilenumber("89999999999").withWorknumber("88888888888").withFax("31258123").withMail("test@test.test").withReservemail("test2@test.test").withExtramail("test3@test.test").withDomen("myhomepage.test").withBirthday("10").withBirthdaymonth("January").withBirthdayyear("1901").withAnniversaryday("18").withAnniversarymonth("January").withAnniversaryyear("1901").withSelectgroup("test1").withReserveaddress("Eu").withNotes("nothing").withSecondhome("Pakistan"), true);
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(mergeAdress(contactInfoFromEditForm)));
        assertThat(contact.getAllMails(), equalTo(mergeAllMails(contactInfoFromEditForm)));

    }

    private <T> String mergeAllMails(ContactData contact) {
        return Arrays.asList(contact.getMail(), contact.getReservemail(), contact.getExtramail())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private <T> String mergeAdress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private <T> String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomeaddress(), contact.getMobilenumber(), contact.getWorknumber(), contact.getReserveaddress())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }
}
