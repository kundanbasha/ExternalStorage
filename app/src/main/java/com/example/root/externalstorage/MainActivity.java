package com.example.root.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText data;
    Button read,write;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data=(EditText)findViewById(R.id.inputdata);
        read=(Button)findViewById(R.id.read);
        write=(Button)findViewById(R.id.write);
        output=(TextView)findViewById(R.id.readdata);
        output.setVisibility(View.GONE);

    }
    public void readMethod(View view){

        Toast.makeText(getApplicationContext(),"read",Toast.LENGTH_SHORT).show();


        //String state = Environment.getExternalStorageState();
        //Toast.makeText(getApplicationContext(),state,Toast.LENGTH_SHORT).show();
       // if (Environment.MEDIA_MOUNTED.equals(state)) {

            //Toast.makeText(getApplicationContext(),"read1",Toast.LENGTH_SHORT).show();

                    /*File path = Environment.getExternalStorageDirectory();
                    File mydir = new File(path.getAbsolutePath() + "/ExternalStorage");
                    File textfile = new File(mydir, "message.txt");
                    String message;

                    try {
                        FileInputStream fileInputStream = new FileInputStream(textfile);
                        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((message = bufferedReader.readLine()) != null) {

                            stringBuffer.append(message + "\n");
                        }
                        output.setText(stringBuffer.toString());
                        output.setVisibility(View.VISIBLE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/


       // }
        //else{

          //  Toast.makeText(getApplicationContext(),"external storage is not availale",Toast.LENGTH_SHORT).show();

                    try {
                        FileInputStream fileInputStream=openFileInput("internal_file");
                        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                        StringBuffer stringBuffer=new StringBuffer();
                        String mess;
                        while((mess=bufferedReader.readLine())!=null){

                            stringBuffer.append(mess+"\n");

                        }
                        output.setText(stringBuffer.toString());
                        output.setVisibility(View.VISIBLE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


      //  }
    }

    public void writeMethod(View view){

        Toast.makeText(getApplicationContext(),"write",Toast.LENGTH_SHORT).show();


       // String state= Environment.getExternalStorageState();
        //Toast.makeText(getApplicationContext(),state,Toast.LENGTH_SHORT).show();
        /*if(Environment.MEDIA_MOUNTED.equals(state)){

                    /*File path=Environment.getExternalStorageDirectory();
                    File mydir=new File(path.getAbsolutePath()+"/ExternalStorage");
                    if(!mydir.exists()){
                        mydir.mkdir();
                    }
                    File textfile=new File(mydir,"message.txt");
                    String message=data.getText().toString();
                    try{

                        FileOutputStream fos=new FileOutputStream(textfile);
                        fos.write(message.getBytes());
                        fos.close();
                        data.setText("");
                        Toast.makeText(getApplicationContext(),"data write successfully",Toast.LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/


        //}
        //else{

        //    Toast.makeText(getApplicationContext(),"external storage is not availale",Toast.LENGTH_SHORT).show();

                    String mess=data.getText().toString();
                    String file_name="internal_file";

                    try {
                        FileOutputStream fileOutputStream=openFileOutput(file_name,MODE_PRIVATE);
                        fileOutputStream.write(mess.getBytes());
                        fileOutputStream.close();
                        data.setText("");
                        Toast.makeText(getApplicationContext(),"saved in internal storage",Toast.LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

      //  }
    }
}
