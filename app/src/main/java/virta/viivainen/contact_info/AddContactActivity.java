package virta.viivainen.contact_info;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);

    }

    public void addContact(View view) {
        EditText firstName = findViewById(R.id.FirstNameEdit);
        EditText lastName = findViewById(R.id.LastNameEdit);
        EditText phoneNumber = findViewById(R.id.PhoneNumberEdit);
        RadioGroup contactType = findViewById(R.id.ContactTypeRadioGroup);

        int selectedId = contactType.getCheckedRadioButtonId();
        String contactGroup;

        if(selectedId == R.id.PersonalRadioButton) {
            contactGroup = getString(R.string.contact_group_personal);
        } else {
            contactGroup = getString(R.string.contact_group_work);
        }

        ContactStorage.getInstance().addContact(new Contact(firstName.getText().toString(),
                lastName.getText().toString(), phoneNumber.getText().toString(), contactGroup));
        MainActivity.adapter.setContacts(ContactStorage.getInstance().getContacts());
        Log.d("AddContactActivity", "Contact added: " + firstName + " " + lastName);
    }


}