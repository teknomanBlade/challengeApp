package mluna.challenge.intive.masterdetailapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mluna.challenge.intive.masterdetailapp.R;
import mluna.challenge.intive.masterdetailapp.entities.Login;
import mluna.challenge.intive.masterdetailapp.entities.Name;
import mluna.challenge.intive.masterdetailapp.entities.Picture;
import mluna.challenge.intive.masterdetailapp.entities.Result;
import mluna.challenge.intive.masterdetailapp.entities.UserDetails;

public class RecyclerViewProfileImagesAdapter extends RecyclerView.Adapter<RecyclerViewProfileImagesViewHolder> {

    private Context context;
    private ArrayList<Result> dataList;
    private ArrayList<UserDetails> detailsList;
    private TextView _lblUserName;
    private Picasso.Builder builder;
    Result result;
    Picture picture;
    String thumbnail = null;
    String large = null;
    Login login;
    Name name;
    String email;


    public RecyclerViewProfileImagesAdapter(Context context, ArrayList<Result> dataList){
        this.context = context;
        this.dataList = dataList;
        detailsList = new ArrayList<UserDetails>();
        builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
    }


    @NonNull
    @Override
    public RecyclerViewProfileImagesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.custom_profile_images, viewGroup, false);
        _lblUserName = view.findViewById(R.id.lblUserName);

        return new RecyclerViewProfileImagesViewHolder(view, context, detailsList,_lblUserName);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewProfileImagesViewHolder holder, int position) {
        result = dataList.get(position);
        picture = result.getPicture();
        large = picture.getLarge();
        login = result.getLogin();
        name = result.getName();
        email = result.getEmail();
        thumbnail = picture.getThumbnail();

        setUserDetails();
        if(dataList.size() > 0){
            builder.build().load(picture.getThumbnail())
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.profileImageThumbnail);
            _lblUserName.setText(login.getUsername());
        }else{
            holder.profileImageThumbnail.setVisibility(View.GONE);
        }


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void setUserDetails(){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName(login.getUsername());
        userDetails.setFirst(name.getFirst());
        userDetails.setLast(name.getLast());
        userDetails.setPictureLarge(picture.getLarge());
        userDetails.setPictureThumbnail(picture.getThumbnail());
        userDetails.setEmail(email);

        detailsList.add(userDetails);
    }

    public ArrayList<UserDetails> getDetailsList(){
        return detailsList;
    }
}
