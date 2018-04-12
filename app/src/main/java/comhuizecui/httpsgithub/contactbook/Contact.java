package comhuizecui.httpsgithub.contactbook;

/**
 * Created by h.cui on 4/5/2018.
 */

public class Contact {
    private String name;
    private String phone;
    private String e_mail;

    private Contact()
    {
        name = "";
        phone = "";
        e_mail = "";
    }

    private Contact( String nameInput, String phoneInput, String emailInput)
    {
        name = nameInput;
        phone = phoneInput;
        e_mail = emailInput;
    }

    private String getName()
    {
        return name;
    }

    private String getPhone()
    {
        return phone;
    }

    private String getEmail() { return e_mail; }

}
