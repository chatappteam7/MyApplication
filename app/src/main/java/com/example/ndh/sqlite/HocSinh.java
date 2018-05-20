package com.example.ndh.sqlite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by NDH on 9/15/2017.
 */

public class HocSinh implements Parcelable {
    private  int Id;
    private String hoTen;
    private int namSinh;
    private String diaChi;


    protected HocSinh(Parcel in) {
        Id = in.readInt();
        hoTen = in.readString();
        namSinh = in.readInt();
        diaChi = in.readString();
    }

    public static final Creator<HocSinh> CREATOR = new Creator<HocSinh>() {
        @Override
        public HocSinh createFromParcel(Parcel in) {
            return new HocSinh(in);
        }

        @Override
        public HocSinh[] newArray(int size) {
            return new HocSinh[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public HocSinh(int id, String hoTen, int namSinh, String diaChi) {

        Id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(hoTen);
        dest.writeInt(namSinh);
        dest.writeString(diaChi);
    }
}
