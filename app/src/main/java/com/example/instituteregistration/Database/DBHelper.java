package com.example.instituteregistration.Database;
import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.instituteregistration.Demo.Institute;
import com.example.instituteregistration.Demo.Payement;
import com.example.instituteregistration.Demo.Student;
import com.example.instituteregistration.Demo.Class;
import com.example.instituteregistration.Demo.Teacher;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.example.instituteregistration.Database.UserMaster.Student.TABLE_NAME2;






public class DBHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME="mydb.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1 );
    }





    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateTable="CREATE TABLE "+UserMaster.Student.TABLE_NAME+" (" +
                UserMaster.Student._ID+" INTEGER PRIMARY KEY,"+
                UserMaster.Student.COLUMN_NAME_FNAME+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_LNAME+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_EMAIL+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_ADDRESS+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_PASSWORD+" TEXT);";

        db.execSQL(sqlCreateTable);



       String sqlCLassTable="CREATE TABLE "+ UserMaster.Student.TABLE_NAME2+" (" +
                UserMaster.Student.COLUMN_NAME_CLASSID+" INTEGER PRIMARY KEY,"+
                UserMaster.Student.COLUMN_NAME_CNAME+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_STARTTIME+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_ENDTIME+" TEXT);";
        db.execSQL(sqlCLassTable);



        String sqlCreateTable1="CREATE TABLE "+UserMaster.Student.TABLE_NAME1+" (" +
                UserMaster.Student._ID+" INTEGER PRIMARY KEY,"+
                UserMaster.Student.COLUMN_NAME_CLASSCODE+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_STDMAIL+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_SUBJECT+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_DATE+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_GRADE+" TEXT,"+
                UserMaster.Student.COLUMN_NAME_MONTH+" TEXT);";

        db.execSQL(sqlCreateTable1);


        String sqlCreateIns="CREATE TABLE "+UserMaster.Institute.TABLE_NAME+" (" +
                UserMaster.Institute._ID+" INTEGER PRIMARY KEY,"+
                UserMaster.Institute.COLUMN_NAME_NAME+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_MANAGER+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_PASSWORD+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_ADDRESS+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_WEBSITE+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_EMAIL+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_HOTLINE+" TEXT,"+
                UserMaster.Institute.COLUMN_NAME_DESCRIPTION+" TEXT);";

        db.execSQL(sqlCreateIns);

        String sqlCreateTeacher="CREATE TABLE "+UserMaster.Teacher.TABLE_NAME+" (" +
                UserMaster.Teacher._ID+" INTEGER PRIMARY KEY,"+
                UserMaster.Teacher.COLUMN_NAME_NAME+" TEXT,"+
                UserMaster.Teacher.COLUMN_NAME_SUBJECT+" TEXT,"+
                UserMaster.Teacher.COLUMN_NAME_PASSWORD+" TEXT,"+
                UserMaster.Teacher.COLUMN_NAME_ADDRESS+" TEXT,"+
                UserMaster.Teacher.COLUMN_NAME_EMAIL+" TEXT,"+
                UserMaster.Teacher.COLUMN_NAME_TEL+" TEXT);";

        db.execSQL(sqlCreateTeacher);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ UserMaster.Student.TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+UserMaster.Student.TABLE_NAME);
        onCreate(db);
    }

    public boolean addStudentInfo(Student student1){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UserMaster.Student.COLUMN_NAME_FNAME,student1.getfName());
        values.put(UserMaster.Student.COLUMN_NAME_LNAME,student1.getlName());
        values.put(UserMaster.Student.COLUMN_NAME_EMAIL,student1.getEmail());
        values.put(UserMaster.Student.COLUMN_NAME_ADDRESS,student1.getAddress());
        values.put(UserMaster.Student.COLUMN_NAME_PASSWORD,student1.getPassword());
        //values.put(String.valueOf(UserMaster.Student.COLUMN_NAME_MOBILENUMBER),student1.getMobileNo());

        long result= db.insert(UserMaster.Student.TABLE_NAME,null,values);
        if(result > 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean addInstituteInfo(Institute Ins){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UserMaster.Institute.COLUMN_NAME_NAME,Ins.getName());
        values.put(UserMaster.Institute.COLUMN_NAME_MANAGER,Ins.getManager());
        values.put(UserMaster.Institute.COLUMN_NAME_PASSWORD,Ins.getPassword());
        values.put(UserMaster.Institute.COLUMN_NAME_ADDRESS,Ins.getAddress());
        values.put(UserMaster.Institute.COLUMN_NAME_WEBSITE,Ins.getWebsite());
        values.put(UserMaster.Institute.COLUMN_NAME_EMAIL,Ins.getEmail());
        values.put(UserMaster.Institute.COLUMN_NAME_HOTLINE,Ins.getHotline());
        values.put(UserMaster.Institute.COLUMN_NAME_DESCRIPTION,Ins.getDescription());

        //values.put(String.valueOf(UserMaster.Student.COLUMN_NAME_MOBILENUMBER),student1.getMobileNo());

        long result= db.insert(UserMaster.Institute.TABLE_NAME,null,values);
        if(result>0){
            return true;

        }else{
            return false;
        }

    }

    public boolean addTeacherInfo(Teacher Ins){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UserMaster.Teacher.COLUMN_NAME_NAME,Ins.getFullName());
        values.put(UserMaster.Teacher.COLUMN_NAME_SUBJECT,Ins.getSubject());
        values.put(UserMaster.Teacher.COLUMN_NAME_PASSWORD,Ins.getPassword());
        values.put(UserMaster.Teacher.COLUMN_NAME_ADDRESS,Ins.getAddress());
        values.put(UserMaster.Teacher.COLUMN_NAME_EMAIL,Ins.getEmail());
        values.put(UserMaster.Teacher.COLUMN_NAME_TEL,Ins.getMobileNo());


        //values.put(String.valueOf(UserMaster.Student.COLUMN_NAME_MOBILENUMBER),student1.getMobileNo());

        long result= db.insert(UserMaster.Teacher.TABLE_NAME,null,values);
        if(result>0){
            return true;

        }else{
            return false;
        }

    }

    //////////////////////Login
    public boolean Authenticate(String email,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(UserMaster.Student.TABLE_NAME,
                new String[]{UserMaster.Student.COLUMN_NAME_EMAIL, UserMaster.Student.COLUMN_NAME_PASSWORD},
                UserMaster.Student.COLUMN_NAME_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Student std = new Student(cursor.getString(0), cursor.getString(1));
            System.out.println(std.getPassword());
            if (password.equalsIgnoreCase(std.getPassword())) {
                System.out.println("Hiiiiiiiiiii");
                return true;
            }


        }
        return false;
    }

    public boolean AuthenticateInstitute(String email,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(UserMaster.Institute.TABLE_NAME,
                new String[]{UserMaster.Institute.COLUMN_NAME_EMAIL, UserMaster.Institute.COLUMN_NAME_PASSWORD},
                UserMaster.Institute.COLUMN_NAME_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Institute Ins = new Institute(cursor.getString(0), cursor.getString(1));
            System.out.println(Ins.getPassword());
            if (password.equalsIgnoreCase(Ins.getPassword())) {
                System.out.println("Hiiiiiiiiiii");
                return true;
            }


        }
        return false;
    }

    public boolean AuthenticateTeacher(String email,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(UserMaster.Teacher.TABLE_NAME,
                new String[]{UserMaster.Teacher.COLUMN_NAME_EMAIL, UserMaster.Teacher.COLUMN_NAME_PASSWORD},
                UserMaster.Teacher.COLUMN_NAME_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Teacher Ins = new Teacher(cursor.getString(0), cursor.getString(1));
            System.out.println(Ins.getPassword());
            if (password.equalsIgnoreCase(Ins.getPassword())) {
                System.out.println("Hiiiiiiiiiii");
                return true;
            }


        }
        return false;
    }

    //////////////////Show Profile Details
    public Student showDetails(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(UserMaster.Student.TABLE_NAME,
                new String[]{UserMaster.Student.COLUMN_NAME_FNAME, UserMaster.Student.COLUMN_NAME_LNAME,UserMaster.Student.COLUMN_NAME_EMAIL,UserMaster.Student.COLUMN_NAME_ADDRESS,UserMaster.Student.COLUMN_NAME_PASSWORD},
                UserMaster.Student.COLUMN_NAME_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Student std = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            System.out.println("Worked");
            System.out.println(email);
            return std;
        }
        return null;
    }

    public Institute showInsDetails(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(UserMaster.Institute.TABLE_NAME,
                new String[]{UserMaster.Institute.COLUMN_NAME_NAME, UserMaster.Institute.COLUMN_NAME_MANAGER,UserMaster.Institute.COLUMN_NAME_PASSWORD,UserMaster.Institute.COLUMN_NAME_ADDRESS,UserMaster.Institute.COLUMN_NAME_WEBSITE,UserMaster.Institute.COLUMN_NAME_EMAIL,UserMaster.Institute.COLUMN_NAME_HOTLINE,UserMaster.Institute.COLUMN_NAME_DESCRIPTION},
                UserMaster.Institute.COLUMN_NAME_EMAIL + "=?",
                new String[]{email},
                null, null, null);


        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Institute Ins = new Institute(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));

            System.out.println("Worked");
            System.out.println(email);
            return Ins;
        }
        return null;
    }

    public Teacher showTeacherDetails(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(UserMaster.Teacher.TABLE_NAME,
                new String[]{UserMaster.Teacher.COLUMN_NAME_NAME, UserMaster.Teacher.COLUMN_NAME_SUBJECT,UserMaster.Teacher.COLUMN_NAME_EMAIL,UserMaster.Teacher.COLUMN_NAME_PASSWORD,UserMaster.Teacher.COLUMN_NAME_ADDRESS,UserMaster.Teacher.COLUMN_NAME_TEL},
                UserMaster.Teacher.COLUMN_NAME_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Teacher std = new Teacher(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

            System.out.println("Worked");
            System.out.println(email);
            return std;
        }
        return null;
    }


    public boolean updatestudent(String email,Student student){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues v = new ContentValues();

        v.put(UserMaster.Student.COLUMN_NAME_FNAME,student.getfName());
        v.put(UserMaster.Student.COLUMN_NAME_LNAME,student.getlName());
        v.put(UserMaster.Student.COLUMN_NAME_ADDRESS,student.getAddress());
        v.put(UserMaster.Student.COLUMN_NAME_EMAIL,student.getEmail());
        v.put(UserMaster.Student.COLUMN_NAME_PASSWORD,student.getPassword());

        String select  = UserMaster.Student.COLUMN_NAME_EMAIL+ " Like ?";
        String [] selectionArgs = {email};

        int result = db.update(UserMaster.Student.TABLE_NAME,v,select,selectionArgs);

        if(result>0){
            return  true;
        }else{
            return false;
        }
    }

    public boolean updatesInstitute(String email,Institute Ins){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues v = new ContentValues();

        v.put(UserMaster.Institute.COLUMN_NAME_NAME,Ins.getName());
        v.put(UserMaster.Institute.COLUMN_NAME_MANAGER,Ins.getManager());
        v.put(UserMaster.Institute.COLUMN_NAME_ADDRESS,Ins.getAddress());
        v.put(UserMaster.Institute.COLUMN_NAME_WEBSITE,Ins.getWebsite());
        v.put(UserMaster.Institute.COLUMN_NAME_HOTLINE,Ins.getHotline());
        v.put(UserMaster.Institute.COLUMN_NAME_DESCRIPTION,Ins.getDescription());
        v.put(UserMaster.Institute.COLUMN_NAME_PASSWORD,Ins.getPassword());

        String select  = UserMaster.Institute.COLUMN_NAME_EMAIL+ " Like ?";
        String [] selectionArgs = {email};

        int result = db.update(UserMaster.Institute.TABLE_NAME,v,select,selectionArgs);

        if(result>0){
            return  true;
        }else{
            return false;
        }
    }
    public boolean updatesTeacher(String email,Teacher Ins){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues v = new ContentValues();

        v.put(UserMaster.Teacher.COLUMN_NAME_NAME,Ins.getFullName());
        v.put(UserMaster.Teacher.COLUMN_NAME_SUBJECT,Ins.getSubject());
        v.put(UserMaster.Teacher.COLUMN_NAME_ADDRESS,Ins.getAddress());
        v.put(UserMaster.Teacher.COLUMN_NAME_TEL,Ins.getMobileNo());
        v.put(UserMaster.Teacher.COLUMN_NAME_PASSWORD,Ins.getPassword());
        v.put(UserMaster.Teacher.COLUMN_NAME_EMAIL,Ins.getEmail());

        String select  = UserMaster.Teacher.COLUMN_NAME_EMAIL+ " Like ?";
        String [] selectionArgs = {email};

        int result = db.update(UserMaster.Teacher.TABLE_NAME,v,select,selectionArgs);

        if(result>0){
            return  true;
        }else{
            return false;
        }
    }

    public int deleteStudent(String email){
        SQLiteDatabase db = getReadableDatabase();
        String select  = UserMaster.Student.COLUMN_NAME_EMAIL+ " Like ?";
        String [] selectionArgs = {email};

        int result = db.delete(UserMaster.Student.TABLE_NAME,select,selectionArgs);

        if(result>0){
            return 1;
        }else{
            return -1;
        }



    }

    public int deleteTeacher(String email){
        SQLiteDatabase db = getReadableDatabase();
        String select  = UserMaster.Teacher.COLUMN_NAME_EMAIL+ " Like ?";
        String [] selectionArgs = {email};

        int result = db.delete(UserMaster.Teacher.TABLE_NAME,select,selectionArgs);

        if(result>0){
            return 1;
        }else{
            return -1;
        }



    }


    public int deleteInstitute(String email){
        SQLiteDatabase db = getReadableDatabase();
        String select  = UserMaster.Institute.COLUMN_NAME_EMAIL+ " Like ?";
        String [] selectionArgs = {email};

        int result = db.delete(UserMaster.Institute.TABLE_NAME,select,selectionArgs);

        if(result>0){
            return 1;
        }else{
            return -1;
        }



    }


    public boolean addClassInfo(Class class1){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UserMaster.Student.COLUMN_NAME_CNAME,class1.getClassName());
        values.put(UserMaster.Student.COLUMN_NAME_STARTTIME,class1.getStartTime());
        values.put(UserMaster.Student.COLUMN_NAME_ENDTIME,class1.getEndTime());

        //values.put(String.valueOf(UserMaster.Student.COLUMN_NAME_MOBILENUMBER),student1.getMobileNo());

        long result= db.insert(UserMaster.Student.TABLE_NAME2,null,values);
        if(result>0){
            return true;

        }else{
            return false;
        }

    }
    /*public boolean addClassInfo(Class class1){
        //to idenitify errors if any
        Log.d("DBhelper", "Inserting a class record.");

        SQLiteDatabase db= getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UserMaster.Student.COLUMN_NAME_CNAME,class1.getClassName());
        values.put(UserMaster.Student.COLUMN_NAME_STARTTIME,class1.getStartTime());
        values.put(UserMaster.Student.COLUMN_NAME_ENDTIME,class1.getEndTime());


        long result= db.insert(UserMaster.Student.TABLE_NAME2,null,values);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }*/


    public Cursor readClassinfo(){

        Log.d("DBhelper", "Reading all classes.");

        SQLiteDatabase db = this.getWritableDatabase();

        String selQuery = "SELECT * FROM " + UserMaster.Student.TABLE_NAME2;

        Cursor result = db.rawQuery(selQuery, null);

        return result;}


    public boolean addPayDetails(Payement payement){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UserMaster.Student.COLUMN_NAME_CLASSCODE,payement.getClassCode());
        values.put(UserMaster.Student.COLUMN_NAME_STDMAIL,payement.getStdMail());
        values.put(UserMaster.Student.COLUMN_NAME_MONTH,payement.getMonth());


        long result= db.insert(UserMaster.Student.TABLE_NAME1,null,values);
        if(result>0){
            return true;

        }else{
            return false;
        }

    }


    public ArrayList<Teacher> getAllTeacherData(){

        ArrayList<Teacher> arrayList=new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Teacher",null);

        while(cursor.moveToNext()){


            String name = cursor.getString(1);
            String sub = cursor.getString(2);
            String email = cursor.getString(5);
            String addr = cursor.getString(4);
            String mob = cursor.getString(6);

            Teacher teacher = new Teacher(name,sub,email,addr,mob);

            arrayList.add(teacher);


        }

        return arrayList;



    }

    public ArrayList<Student> getAllStudentData(){

        ArrayList<Student> arrayList=new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Studentttt",null);

        while(cursor.moveToNext()){


            String name = cursor.getString(1);
            String ln = cursor.getString(2);
            String email = cursor.getString(3);
            String addr = cursor.getString(4);


            Student student = new Student(name,ln,email,addr);

            arrayList.add(student);





        }

        return arrayList;



    }

}
