package virta.viivainen.contact_info;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ContactViewHolder extends RecyclerView.ViewHolder{
    ImageView profileImage, removeButton, detailsButton;
    TextView name, phoneNumber, contactGroup;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        profileImage = itemView.findViewById(R.id.ProfilePicView);
        name = itemView.findViewById(R.id.ContactNameText);
        phoneNumber = itemView.findViewById(R.id.ContactNumberText);
        contactGroup = itemView.findViewById(R.id.ContactGroupText);
        removeButton = itemView.findViewById(R.id.ContactDeleteButton);
        detailsButton = itemView.findViewById(R.id.ContactDetailsButton);
    }
}
