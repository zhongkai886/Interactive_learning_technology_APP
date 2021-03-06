package com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.DataSearch.SearchFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.interactive_learning_technology_app.R;


public class Edit_DetectDataFragment extends Fragment {
    private String mId;
    private String mNumber;
    private String mName;
    private String mTimeDate;
    private String mFeedBackWay;
    private String mFeedBackCount;
    private String mAttentionHigh;
    private String mAttentionLow;
    private String mRelaxationHigh;
    private String mRelaxationLow;
    private String mAttentionMax;
    private String mAttentionMin;
    private String mRelaxationMax;
    private String mRelaxationMin;
    private String mFeedBackSecondsGap;
    private String mFeedBackPassSeconds;
    private String mAverageAttention;
    private String mAverageRelaxation;
    private String mData;

    public Edit_DetectDataFragment(String Id ,String Number ,String Name, String TimeDate , String FeedBackWay, String FeedBackCount,String AttentionHigh,
                                   String AttentionLow, String RelaxationHigh, String RelaxationLow,
                                   String AttentionMax, String AttentionMin, String RelaxationMax,
                                   String RelaxationMin, String FeedBackSecondsGap, String FeedBackPassSeconds,
                                   String AverageAttention, String AverageRelaxation, String Data) {
        this.mId=Id;
        this.mNumber=Number;
        this.mName=Name;
        this.mTimeDate=TimeDate;
        this.mFeedBackWay=FeedBackWay;
        this.mFeedBackCount=FeedBackCount;
        this.mAttentionHigh=AttentionHigh;
        this.mAttentionLow=AttentionLow;
        this.mRelaxationHigh=RelaxationHigh;
        this.mRelaxationLow=RelaxationLow;
        this.mAttentionMax=AttentionMax;
        this.mAttentionMin =AttentionMin;
        this.mRelaxationMax=RelaxationMax;
        this.mRelaxationMin=RelaxationMin;
        this.mFeedBackSecondsGap=FeedBackSecondsGap;
        this.mFeedBackPassSeconds=FeedBackPassSeconds;
        this.mAverageAttention=AverageAttention;
        this.mAverageRelaxation=AverageRelaxation;
        this.mData=Data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit__detect_data, container, false);
//        final TextView TvId = (TextView) view.findViewById(R.id.id);
        Log.d("question2",""+mFeedBackSecondsGap+mFeedBackPassSeconds);

        final TextView TvNumber = (TextView) view.findViewById(R.id.number);
        final TextView TvTimeDate =(TextView) view.findViewById(R.id.timeDate);
        final TextView TvFeedBackWay = (TextView) view.findViewById(R.id.feedBackWay);
        final TextView TvFeedBackCount =(TextView) view.findViewById(R.id.feedBackCount);
        final TextView TvAttentionHigh =(TextView) view.findViewById(R.id.attentionHigh);
        final TextView TvAttentionLow =(TextView) view.findViewById(R.id.attentionLow);
        final TextView TvRelaxationHigh =(TextView) view.findViewById(R.id.relaxationHigh);
        final TextView TvRelaxationLow =(TextView) view.findViewById(R.id.relaxationLow);
        final TextView TvAttentionMax =(TextView) view.findViewById(R.id.attentionMax);
        final TextView TvAttentionMin =(TextView) view.findViewById(R.id.attentionMin);
        final TextView TvRelaxationMax =(TextView) view.findViewById(R.id.relaxationMax);
        final TextView TvRelaxationMin =(TextView) view.findViewById(R.id.relaxationMin);
        final TextView TvFeedBackSecondsGap =(TextView) view.findViewById(R.id.feedBackSecondsGap);
        final TextView TvFeedBackPassSeconds =(TextView) view.findViewById(R.id.feedBackPassSeconds);
        final TextView TvAverageAttention =(TextView) view.findViewById(R.id.averageAttention);
        final TextView TvAverageRelaxation =(TextView) view.findViewById(R.id.averageRelaxation);
        final TextView TvData =(TextView) view.findViewById(R.id.data);

        TvNumber.setText(mNumber);
        TvTimeDate.setText(mTimeDate);
        TvFeedBackWay.setText(mFeedBackWay);
        TvFeedBackCount.setText(mFeedBackCount);
        TvAttentionHigh.setText(mAttentionHigh);
        TvAttentionLow.setText(mAttentionLow);
        TvRelaxationHigh.setText(mRelaxationHigh);
        Log.d("taggggg", "onCreateView: "+mRelaxationMax);
        TvRelaxationLow.setText(mRelaxationLow);
        TvAttentionMax.setText(mAttentionMax);
        TvAttentionMin.setText(mAttentionMin);
        TvRelaxationMax.setText(mRelaxationMax);

        TvRelaxationMin.setText(mRelaxationMin);
        TvFeedBackSecondsGap.setText(mFeedBackSecondsGap); //間隔

        TvFeedBackPassSeconds.setText(mFeedBackPassSeconds); //開始忽略的秒數
        Log.d("lololololooooo",""+mFeedBackPassSeconds);
        TvAverageAttention.setText(mAverageAttention);
        TvAverageRelaxation.setText(mAverageRelaxation);
        TvData.setText(mData);





        return  view;
    }
}
