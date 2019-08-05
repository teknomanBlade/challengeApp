package mluna.challenge.intive.masterdetailapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import mluna.challenge.intive.masterdetailapp.R;
import mluna.challenge.intive.masterdetailapp.entities.UserDetails;

public class ProfileDetailsActivity extends AppCompatActivity{

    private ImageView imageViewLarge;
    private TextView txtFirstName;
    private TextView txtUserName;
    private TextView txtLastName;
    private TextView txtEmail;
    private List<UserDetails> usersDetails = new ArrayList<UserDetails>();
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_details_activity);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        imageViewLarge = findViewById(R.id.imgProfileLarge);

        usersDetails = ((List<UserDetails>) getIntent().getExtras().getSerializable("detailsList"));
        userName = getIntent().getStringExtra("userName");

        UserDetails userProfile = getUserProfile(usersDetails, userName);

        Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
        builder.downloader(new OkHttp3Downloader(getApplicationContext()));
        builder.build().load(userProfile.getPictureLarge())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(imageViewLarge);

        txtUserName.setText(userProfile.getUserName());
        txtFirstName.setText(userProfile.getFirst());
        txtLastName.setText(userProfile.getLast());
        txtEmail.setText(userProfile.getEmail());

    }

    private UserDetails getUserProfile(List<UserDetails> detailsList, String userName){

        for ( UserDetails userProfile : detailsList) {
            if(userProfile.getUserName().equals(userName)){
                return userProfile;
            }
        }
        return null;
    }



}
