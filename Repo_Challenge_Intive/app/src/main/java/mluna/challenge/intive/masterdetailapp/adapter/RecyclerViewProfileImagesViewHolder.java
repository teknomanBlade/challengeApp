package mluna.challenge.intive.masterdetailapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mluna.challenge.intive.masterdetailapp.R;
import mluna.challenge.intive.masterdetailapp.activities.ProfileDetailsActivity;
import mluna.challenge.intive.masterdetailapp.entities.UserDetails;

public class RecyclerViewProfileImagesViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    public ImageView profileImageThumbnail;
    private Context context;

    public RecyclerViewProfileImagesViewHolder(@NonNull View itemView, final Context context, final ArrayList<UserDetails> userDetails, final TextView lblUserName) {
        super(itemView);
        this.context = context;
        mView = itemView;
        profileImageThumbnail = mView.findViewById(R.id.profileImageThumbnail);
        profileImageThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileDetailsActivity.class);
                intent.putExtra("detailsList", userDetails);
                intent.putExtra("userName", lblUserName.getText());
                context.startActivity(intent);

            }
        });
    }


}
