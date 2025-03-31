package virta.viivainen.contact_info;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ContactStorage contactStorage;
    private RecyclerView recyclerView;
    public static ContactListAdapter adapter;

    private Button sortAlphabeticallyButton, sortByGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        contactStorage = ContactStorage.getInstance();

        recyclerView = findViewById(R.id.ListContactsRV);
        sortAlphabeticallyButton = findViewById(R.id.SortAlphabeticallyButton);
        sortByGroupButton = findViewById(R.id.SortByGroupButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactListAdapter(getApplicationContext(), contactStorage.getContacts());
        recyclerView.setAdapter(adapter);

        sortAlphabeticallyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactStorage.sortAlphabetically();
                adapter.setContacts(contactStorage.getContacts());
                adapter.notifyDataSetChanged();
            }
        });

        sortByGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactStorage.sortByGroup();
                adapter.setContacts(contactStorage.getContacts());
                adapter.notifyDataSetChanged();
            }
        });

    }

    protected void onStart() {
        super.onStart();
        Log.d("täällä main activityssä", "starttia kutsuttu");
        adapter.setContacts(contactStorage.getContacts());
    }

    public void switchToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }
}