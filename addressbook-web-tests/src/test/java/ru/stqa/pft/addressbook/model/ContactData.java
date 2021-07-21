package ru.stqa.pft.addressbook.model;


import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name="addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name="id")
    public int id = Integer.MAX_VALUE;
    @Expose
    @Column(name="firstname")
    public String firstname;
    @Expose
    @Column(name="middlename")
    public String middlename;
    @Expose
    @Column(name="lastname")
    public String lastname;
    @Expose
    @Column(name="nickname")
    public String nick;
    @Expose
    @Column(name="title")
    public String title;
    @Expose
    @Column(name="company")
    public String company;
    @Expose
    @Column(name="address")
    @Type(type = "text")
    public String address;
    @Expose
    @Column(name="home")
    @Type(type="text")
    public String homeaddress;
    @Expose
    @Column(name="mobile")
    @Type(type="text")
    public String mobilenumber;
    @Expose
    @Column(name="work")
    @Type(type="text")
    public String worknumber;
    @Expose
    @Column(name="fax")
    @Type(type="text")
    public String fax;
    @Expose
    @Column(name="email")
    @Type(type="text")
    public String mail;
    @Expose
    @Column(name="email2")
    @Type(type="text")
    public String reservemail;
    @Expose
    @Column(name="email3")
    @Type(type="text")
    public String extramail;
    @Expose
    @Column(name="homepage")
    @Type(type="text")
    public String domen;
    @Expose
    @Column(name="bday")
    @Transient
    public String birthday;
    @Expose
    @Column(name="bmonth")
    public String birthdaymonth;
    @Expose
    @Column(name="byear")
    public String birthdayyear;
    @Expose
    @Column(name="aday")
    @Transient
    public String anniversaryday;
    @Expose
    @Column(name="amonth")
    public String anniversarymonth;
    @Expose
    @Column(name="ayear")
    public String anniversaryyear;
    @Expose
    @Column(name="address2")
    @Type(type="text")
    public String reserveaddress;
    @Expose
    @Column(name="notes")
    @Type(type="text")
    public String notes;
    @Expose
    @Column(name="phone2")
    @Type(type="text")
    public String secondhome;
    @Transient
    public String allPhones;
    @Transient
    public String allMails;
    @Column(name="photo")
    @Type(type="text")
    @Transient
    public String photo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData>groups = new HashSet<GroupData>();


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

    public String getReserveaddress() {
        return reserveaddress;
    }

    public String getNotes() {
        return notes;
    }

    public String getSecondhome() {
        return secondhome;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllMails() {
        return allMails;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public Groups getGroups() {
        return new Groups(groups);
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

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllMails(String allMails) {
        this.allMails = allMails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename) && Objects.equals(lastname, that.lastname) && Objects.equals(nick, that.nick) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(address, that.address) && Objects.equals(homeaddress, that.homeaddress) && Objects.equals(mobilenumber, that.mobilenumber) && Objects.equals(worknumber, that.worknumber) && Objects.equals(fax, that.fax) && Objects.equals(mail, that.mail) && Objects.equals(reservemail, that.reservemail) && Objects.equals(extramail, that.extramail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, nick, title, company, address, homeaddress, mobilenumber, worknumber, fax, mail, reservemail, extramail);
    }
}

