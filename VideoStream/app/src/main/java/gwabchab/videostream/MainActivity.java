package gwabchab.videostream;

import android.media.MediaRecorder;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        String hostname = "example.com";
        int port = 1234;

       try{
           Socket socket = new Socket(InetAddress.getByName(hostname), port);
           ParcelFileDescriptor pfd = ParcelFileDescriptor.fromSocket(socket);

           MediaRecorder recorder = new MediaRecorder();
           recorder.setOutputFile(pfd.getFileDescriptor());
           recorder.prepare();
           recorder.start();
       }
       catch(UnknownHostException e1){
           Log.d("James Error", e1.getLocalizedMessage())
       }catch (Exception e2){

       }



    }


}
