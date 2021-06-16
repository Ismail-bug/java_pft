package ru.stqa.pft.addressbook.model;

public class ContactData {
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

    public ContactData(String firstname, String middlename, String lastname, String nick, String title, String company, String address, String homeaddress, String mobilenumber, String worknumber, String fax, String mail, String reservemail, String extramail, String domen, String birthday, String birthdaymonth, String birthdayyear, String anniversaryday, String anniversarymonth, String anniversaryyear, String selectgroup, String reserveaddress, String notes, String secondhome) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nick = nick;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homeaddress = homeaddress;
        this.mobilenumber = mobilenumber;
        this.worknumber = worknumber;
        this.fax = fax;
        this.mail = mail;
        this.reservemail = reservemail;
        this.extramail = extramail;
        this.domen = domen;
        this.birthday = birthday;
        this.birthdaymonth = birthdaymonth;
        this.birthdayyear = birthdayyear;
        this.anniversaryday = anniversaryday;
        this.anniversarymonth = anniversarymonth;
        this.anniversaryyear = anniversaryyear;
        this.selectgroup = selectgroup;
        this.reserveaddress = reserveaddress;
        this.notes = notes;
        this.secondhome = secondhome;
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
}

