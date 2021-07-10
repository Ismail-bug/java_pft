package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public class ContactData  {
    public  int id = Integer.MAX_VALUE;
    public  String firstname;
    public  String middlename;
    public  String lastname;
    public  String nick;
    public  String title;
    public  String company;
    public  String address;
    public  String homeaddress;
    public  String mobilenumber;
    public  String worknumber;
    public  String fax;
    public  String mail;
    public  String reservemail;
    public  String extramail;
    public  String domen;
    public  String birthday;
    public  String birthdaymonth;
    public  String birthdayyear;
    public  String anniversaryday;
    public  String anniversarymonth;
    public  String anniversaryyear;
    public  String selectgroup;
    public  String reserveaddress;
    public  String notes;
    public  String secondhome;


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNick() {
        return nick;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public String getFax() {
        return fax;
    }

    public String getMail() {
        return mail;
    }

    public String getReservemail() {
        return reservemail;
    }

    public String getExtramail() {
        return extramail;
    }

    public String getDomen() {
        return domen;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBirthdaymonth() {
        return birthdaymonth;
    }

    public String getBirthdayyear() {
        return birthdayyear;
    }

    public String getAnniversaryday() {
        return anniversaryday;
    }

    public String getAnniversarymonth() {
        return anniversarymonth;
    }

    public String getAnniversaryyear() {
        return anniversaryyear;
    }

    public String getSelectgroup() {
            return selectgroup;
    }
    public String getReserveaddress() {
        return reserveaddress;
    }

    public String getNotes() {
        return notes;
    }

    public String getSecondhome() {
        return secondhome;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNick(String nick) {
        this.nick = nick;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
        return this;
    }

    public ContactData withMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
        return this;
    }

    public ContactData withWorknumber(String worknumber) {
        this.worknumber = worknumber;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ContactData withReservemail(String reservemail) {
        this.reservemail = reservemail;
        return this;
    }

    public ContactData withExtramail(String extramail) {
        this.extramail = extramail;
        return this;
    }

    public ContactData withDomen(String domen) {
        this.domen = domen;
        return this;
    }

    public ContactData withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public ContactData withBirthdaymonth(String birthdaymonth) {
        this.birthdaymonth = birthdaymonth;
        return this;
    }

    public ContactData withBirthdayyear(String birthdayyear) {
        this.birthdayyear = birthdayyear;
        return this;
    }

    public ContactData withAnniversaryday(String anniversaryday) {
        this.anniversaryday = anniversaryday;
        return this;
    }

    public ContactData withAnniversarymonth(String anniversarymonth) {
        this.anniversarymonth = anniversarymonth;
        return this;
    }

    public ContactData withAnniversaryyear(String anniversaryyear) {
        this.anniversaryyear = anniversaryyear;
        return this;
    }

    public ContactData withSelectgroup(String selectgroup) {
        this.selectgroup = selectgroup;
        return this;
    }

    public ContactData withReserveaddress(String reserveaddress) {
        this.reserveaddress = reserveaddress;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withSecondhome(String secondhome) {
        this.secondhome = secondhome;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}

