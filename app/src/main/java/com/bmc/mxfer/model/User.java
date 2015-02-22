package com.bmc.mxfer.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Parcelable, Serializable {

    private String name;
    private String gravatarEmail;
    private String twitterName;

    private User() {
        // Use builder yo
    }

    private User(Parcel in) {
        readFromParcel(in);
    }

    /**
     * Get the user's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the user's gravatar email address for image retrieval
     * @return gravatarEmail
     */
    public String getGravatarEmail() {
        return gravatarEmail;
    }

    /**
     * Get the user's Twitter username
     * @return twitterUserName
     */
    public String getTwitterName() {
        return twitterName;
    }

    @Override
    public String toString() {
        return "User: " + " name=" + name + "\n"
                + "gravatarEmail=" + gravatarEmail + "\n"
                + "twitterName=" + twitterName;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(gravatarEmail);
        out.writeString(twitterName);
    }

    public void readFromParcel(Parcel in) {
        name = in.readString();
        gravatarEmail = in.readString();
        twitterName = in.readString();
    }

    public static class Builder {
        private String name;
        private String gravatarEmail;
        private String twitterName;

        public Builder setName(String userName) {
            name = userName;
            return this;
        }

        public Builder setGravatarEmail(String email) {
            gravatarEmail = email;
            return this;
        }

        public Builder setTwitterName(String twitter) {
            twitterName = twitter;
            return this;
        }

        public User build() {
            User user = new User();
            user.name = name;
            user.gravatarEmail = gravatarEmail;
            user.twitterName = twitterName;

            return user;
        }
    }
}
