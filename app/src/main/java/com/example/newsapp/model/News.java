package com.example.newsapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import javax.annotation.Generated;


import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class News extends BaseObservable implements Parcelable {

   public final static Parcelable.Creator<News> CREATOR=new Creator<News>() {
       @Override
       public News createFromParcel(Parcel parcel) {
           return new News(parcel);
       }

       @Override
       public News[] newArray(int size) {
           return (new News[size]);
       }
   };


    public News() {
    }
//in contructor and write to parcel thinngs should be in same order  in both of the meth
    public News(Parcel in) {
        //  this.source = ((Source) in.readValue((Integer.class.getClassLoader())));
        this.content =  ((String) in.readValue((String.class.getClassLoader())));
        this.publishedAt =  ((String) in.readValue((String.class.getClassLoader())));
        this.url =  ((String) in.readValue((String.class.getClassLoader())));
        this.urlToImage = ((String) in.readValue((String.class.getClassLoader())));
        this.description =  ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.author =((String) in.readValue((String.class.getClassLoader())));
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        //  parcel.writeValue(source);
        parcel.writeValue(content);
        parcel.writeValue(publishedAt);
        parcel.writeValue(url);
        parcel.writeValue(urlToImage);
        parcel.writeValue(description);
        parcel.writeValue(title);
        parcel.writeValue(author);
    }

    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;

    //using glide to load image

    @BindingAdapter("urlToImage")
    public static void loadImage(ImageView imageView, String imageURL){
        String imagePath=imageURL;
        Glide.with(imageView.getContext())
                .load(imagePath)
                .into(imageView);
    }

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("content")
    @Expose
    private String content;

@Bindable
    public Source getSource() {
       return  source;
    }

    public void setSource(Source source) {
     this.source=source;
notifyPropertyChanged(BR.source);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(BR.author);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
        notifyPropertyChanged(BR.urlToImage);
    }

    @Bindable
    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
        notifyPropertyChanged(BR.publishedAt);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }



}
