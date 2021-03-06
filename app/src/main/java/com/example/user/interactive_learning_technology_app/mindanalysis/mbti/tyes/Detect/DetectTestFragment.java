package com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.Detect;

import android.app.Service;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.interactive_learning_technology_app.R;
import com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.Experiment_Setting.FeeBackFrameSetting.FeedbackData;
import com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract;
import com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBHelper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static android.content.Context.MODE_PRIVATE;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_AttentionFeedBackWay;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_AttentionMp3Uri;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_FeedBackWaySecond;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_FeedBackWayStopTipSecond;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_HoldSecond;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_RelaxationFeedBackWay;
import static com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.database.SettingDBContract.SettingDataEntry.COLUMN_RelaxationMp3Uri;

public class DetectTestFragment extends Fragment {
    private ImageButton testButton;
    private Button againButton;
    private Button detectButton;
    private TextView detectIdTextView;
    static boolean isPlay = false;
    private TimeUnit timeUnit ;
    public SQLiteDatabase sqLiteDatabase;
    public ArrayList<FeedbackData> feedbackDataList = new ArrayList<FeedbackData>();
    public MediaPlayer mediaPlayer = new MediaPlayer();
    Handler handler = new Handler();
    boolean onClickBoolean = false;
    public DetectTestFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detect_test, container, false);
        testButton = view.findViewById(R.id.testButton);
        againButton = (Button) view.findViewById(R.id.againTestButton);
        detectIdTextView = (TextView) view.findViewById(R.id.detectId);
        detectButton = (Button) view.findViewById(R.id.fragment_detect_start);
        SettingDBHelper dbHelper = new SettingDBHelper(getActivity());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final DetectFragment detectFragment = new DetectFragment();

        LoadData();

        String loginId = getActivity().getSharedPreferences("detectId", MODE_PRIVATE)
                .getString("USER", "");
        String fb_way = getActivity().getSharedPreferences("selectId", MODE_PRIVATE)
                .getString("USER", "");
        String fb_Way = getActivity().getSharedPreferences("selectAttentionWay", MODE_PRIVATE)
                .getString("USER", "");
        detectIdTextView.setText(loginId);
        Log.d("wayway", "onCreateView: "+fb_Way);
        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fb_Way.equals("0")){
                    if (onClickBoolean==false){
                        onClickBoolean=true;
                        handler.postDelayed(updateDevice,1000);
                    }else{
                        handler.removeCallbacks(updateDevice);
                        onClickBoolean=false;
                        testButton.setBackgroundColor(testButton.getContext().getResources().getColor(R.color.white));
                        testButton.setBackgroundResource(R.drawable.shape_mainfragment);
                    }
                }
                else if (fb_Way.equals("1")){
                    setVibrate(1000);
                }else if (fb_Way.equals("2")){
                    playBeep();
                    Log.d("222222222222", "onClick: 可以吧");
                }
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fb_Way.equals("0")){
                    if (onClickBoolean==false){
                        onClickBoolean=true;
                        handler.postDelayed(updateDevice,1000);
                    }else{
                        handler.removeCallbacks(updateDevice);
                        onClickBoolean=false;
                        testButton.setBackgroundColor(testButton.getContext().getResources().getColor(R.color.white));
                        testButton.setBackgroundResource(R.drawable.shape_mainfragment);

                    }
                }
                else if (fb_Way.equals("1")){
                    setVibrate(1000);

                }else if (fb_Way.equals("2")){
                    playBeep();
                    Log.d("222222222", "onClick: 可以吧"+fb_Way);
                }

            }
        });
        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.center, detectFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
    public void setVibrate(int time){
        Vibrator vibrator =(Vibrator) getActivity().getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(time);
    }

    Boolean na = true;
    private Runnable updateDevice = new Runnable() {
        public void run() {
            if (na==true){
//                testButton.setBackgroundColor(testButton.getContext().getResources().getColor(R.color.colorPrimaryDark));
//                testButton.setBackgroundResource(testButton.getContext().getResources().getDrawable(R.id.testButton,R.drawable.shape_mainfragment));
                testButton.setBackgroundResource(R.drawable.shape_mainfragment);
                na=false;
            }else{
//                testButton.setBackgroundColor(testButton.getContext().getResources().getColor(R.color.white));
                testButton.setBackgroundResource(R.drawable.shape_oval1);
                na=true;

            }
            handler.postDelayed(this, 1000);
        }
    };
    public void LoadData() {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM settingDataList", null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_Name));
            String item = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_Item));
            String attentionHigh = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_AttentionHigh));
            String attentionLow = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_AttentionLow));
            String attentionFeedBackWay = cursor.getString(cursor.getColumnIndex(COLUMN_AttentionFeedBackWay));
            String attentionMp3Uri = cursor.getString(cursor.getColumnIndex(COLUMN_AttentionMp3Uri));
            String relaxationHigh = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_RelaxationHigh));
            String relaxationLow = cursor.getString(cursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_RelaxationLow));
            String relaxationFeedBackWay = cursor.getString(cursor.getColumnIndex(COLUMN_RelaxationFeedBackWay));
            String relaxationMp3Uri = cursor.getString(cursor.getColumnIndex(COLUMN_RelaxationMp3Uri));
            String feedBackWaySecond = cursor.getString(cursor.getColumnIndex(COLUMN_FeedBackWaySecond));
            String feedBackWayHoldSecond = cursor.getString(cursor.getColumnIndex(COLUMN_HoldSecond));
            String feedBackWayStopTipSecond = cursor.getString(cursor.getColumnIndex(COLUMN_FeedBackWayStopTipSecond));
            FeedbackData feedbackData = new FeedbackData(id, name, item, attentionHigh, attentionLow, attentionFeedBackWay,attentionMp3Uri,
                    relaxationHigh, relaxationLow, relaxationFeedBackWay,relaxationMp3Uri,feedBackWaySecond,feedBackWayHoldSecond, feedBackWayStopTipSecond);
            feedbackDataList.add(feedbackData);
            Log.d("刷新",""+feedbackData);
        }
        cursor.close();
    }
    public void playBeep() {
            try {
                mediaPlayer.reset();
                AssetFileDescriptor descriptor = getActivity().getAssets().openFd("voice.mp3");
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }else{

                    mediaPlayer.prepare();
//                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("error",e+"");
            }
            isPlay=true;


    }
}