package virta.viivainen.contact_info;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Log.d("ContactListAdapter", "onBindViewHolder() called for position: " + position);
        holder.profileImage.setImageResource(R.drawable.profile);
        holder.ContactNameText.setText(String.format("%s %s", contacts.get(position).getFirstName(), contacts.get(position).getLastName()));
        holder.ContactNumberText.setText(contacts.get(position).getNumber());
        holder.ContactGroupText.setText(contacts.get(position).getContactGroup());
        holder.ContactDetailsButton.setImageResource(R.drawable.info_image);
        holder.ContactDeleteButton.setImageResource(R.drawable.delete_image);

        holder.ContactDeleteButton.setOnClickListener(view -> {
           int pos = holder.getAdapterPosition();
           ContactStorage.getInstance().removeContact(pos);
           notifyItemRemoved(pos);
        });

        holder.ContactDetailsButton.setOnClickListener(view -> {
            if(holder.ContactNumberText.getVisibility() == View.VISIBLE) {
                holder.ContactNumberText.setVisibility(View.GONE);
                holder.ContactGroupText.setVisibility(View.GONE);
            } else {
                holder.ContactNumberText.setVisibility(View.VISIBLE);
                holder.ContactGroupText.setVisibility(View.VISIBLE);
            }
        });
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
