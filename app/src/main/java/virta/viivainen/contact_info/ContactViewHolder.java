package virta.viivainen.contact_info;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ContactViewHolder extends RecyclerView.ViewHolder{
    ImageView profileImage, ContactDeleteButton, ContactDetailsButton;
    TextView ContactNameText, ContactNumberText, ContactGroupText;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        profileImage = itemView.findViewById(R.id.ProfilePicView);
        ContactNameText = itemView.findViewById(R.id.ContactNameText);
        ContactNumberText = itemView.findViewById(R.id.ContactNumberText);
        ContactGroupText = itemView.findViewById(R.id.ContactGroupText);
        ContactDeleteButton = itemView.findViewById(R.id.ContactDeleteButton);
        ContactDetailsButton = itemView.findViewById(R.id.ContactDetailsButton);
    }
}
