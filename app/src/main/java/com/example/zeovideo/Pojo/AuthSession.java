package com.example.zeovideo.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AuthSession implements Parcelable {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public AuthSession(String userName, String callId) {
        this.userName = userName;
        this.callId = callId;
    }

    private String callId;

    protected AuthSession(Parcel in) {
        userName = in.readString();
        callId = in.readString();
    }

    public static final Creator<AuthSession> CREATOR = new Creator<AuthSession>() {
        @Override
        public AuthSession createFromParcel(Parcel in) {
            return new AuthSession(in);
        }

        @Override
        public AuthSession[] newArray(int size) {
            return new AuthSession[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(callId);
    }
}
