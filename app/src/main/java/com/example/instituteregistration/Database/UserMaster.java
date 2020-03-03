package com.example.instituteregistration.Database;

import android.provider.BaseColumns;



public final class UserMaster {
    private UserMaster() {
    }


    protected static class Student implements BaseColumns{
        protected static final String TABLE_NAME="Studentttt";
        protected static final String COLUMN_NAME_FNAME="fName";
        protected static final String COLUMN_NAME_LNAME="lName";
        protected static final String COLUMN_NAME_EMAIL="email";
         protected static final String COLUMN_NAME_ADDRESS="address";
        protected static final String COLUMN_NAME_PASSWORD="password";
        protected static final String TABLE_NAME1="Payment";
        protected static final String COLUMN_NAME_CLASSCODE="classCode";
        protected static final String COLUMN_NAME_STDMAIL="stdMail";
        protected static final String COLUMN_NAME_MONTH="month";
        public static final String TABLE_NAME2="Class";
        public static final String COLUMN_NAME_CLASSID = "ClassID";
        public static final String COLUMN_NAME_CNAME="ClassName";
        public static final String COLUMN_NAME_STARTTIME="StartTime";
        public static final String COLUMN_NAME_ENDTIME="EndTime";
        public static final String COLUMN_NAME_SUBJECT="Subject";
        public static final String COLUMN_NAME_GRADE="grade";
        public static final String COLUMN_NAME_DATE="date";


    }

    /*public static class Class implements BaseColumns{

    }*/

    protected static class Institute implements BaseColumns{
        protected static final String TABLE_NAME = "Institute";
        protected static final String COLUMN_NAME_NAME = "name";
        protected static final String COLUMN_NAME_MANAGER = "manager";
        protected static final String COLUMN_NAME_PASSWORD = "password";
        protected static final String COLUMN_NAME_ADDRESS = "address";
        protected static final String COLUMN_NAME_WEBSITE = "website";
        protected static final String COLUMN_NAME_EMAIL = "email";
        protected static final String COLUMN_NAME_HOTLINE = "hotline";
        protected static final String COLUMN_NAME_DESCRIPTION = "description";


    }

    protected static class Teacher implements BaseColumns{
        protected static final String TABLE_NAME = "Teacher";
        protected static final String COLUMN_NAME_NAME = "name";
        protected static final String COLUMN_NAME_SUBJECT = "subject";
        protected static final String COLUMN_NAME_PASSWORD = "password";
        protected static final String COLUMN_NAME_ADDRESS = "address";
        protected static final String COLUMN_NAME_EMAIL = "email";
        protected static final String COLUMN_NAME_TEL = "tel";


    }


}
