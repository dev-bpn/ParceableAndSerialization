package parceableandserialization.bpn.com.parceableandserialization;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dipesh on 6/28/16.
 */
public class Student implements Parcelable {

    String mSName;
    String mSAddress;
    String mSCourse;

    /**
     * A constructor that initializes the Student object
     **/
    public Student(String sName){
        this.mSName = sName;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Storing the Student data to Parcel object
     **/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSName);
        dest.writeString(mSAddress);
        dest.writeString(mSCourse);
    }


    /**
     * Retrieving Student data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     **/
    protected Student(Parcel in) {
        this.mSName = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
