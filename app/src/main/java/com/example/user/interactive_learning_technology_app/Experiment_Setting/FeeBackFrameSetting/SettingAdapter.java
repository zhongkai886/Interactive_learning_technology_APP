package com.example.user.interactive_learning_technology_app.Experiment_Setting.FeeBackFrameSetting;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.user.interactive_learning_technology_app.R;

import java.util.ArrayList;


public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.SettingViewHolder> {
    private ArrayList<FeedbackData> mFeedbackData;
    FeedbackFrameSettingsActivity feedbackFrameSettingsActivity;
    public ArrayList<String> mCheckBoxDataList = new ArrayList<String>();
    private Context mContext;
    private Cursor mCursor;

    public SettingAdapter(ArrayList<FeedbackData> feedbackData,
                          FeedbackFrameSettingsActivity feedbackFrameSettingsActivity){
        this.mFeedbackData =  feedbackData;
        this.feedbackFrameSettingsActivity = feedbackFrameSettingsActivity;
    }

    public class SettingViewHolder extends RecyclerView.ViewHolder{
        public CheckBox mCheckbox;
        public TextView mId;
        public TextView mItem;
        public Button mButton;


        public SettingViewHolder(@NonNull View itemView) {
            super(itemView);
            mCheckbox = itemView.findViewById(R.id.settingCheckbox);
            mId = itemView.findViewById(R.id.settingId);
            mItem = itemView.findViewById(R.id.settingItem);
            mButton = itemView.findViewById(R.id.settingButton);
        }
    }

    @NonNull
    @Override
    public SettingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_feedback_setting,parent,false);
        final SettingViewHolder holder = new SettingViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SettingViewHolder holder, final int position) {
//        if(!mCursor.move(position)){
//            return;
//        }
        final FeedbackData mFeedbackData1 = this.mFeedbackData.get(position);
        holder.mId.setText(mFeedbackData.get(position).getId());
        holder.mItem.setText(mFeedbackData.get(position).getItem());
        holder.mCheckbox.setTag(position);
        holder.mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Object position1 = compoundButton.getTag();
                Log.d("yoyo",""+position1);
            }
        });

        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = feedbackFrameSettingsActivity.getActivity().getSupportFragmentManager();
                Edit_FeedbackWay edit_FeedbackWay = new Edit_FeedbackWay(
                        mFeedbackData1.getId(),
                        mFeedbackData1.getName(),
                        mFeedbackData1.getItem(),
                        mFeedbackData1.getAttentionHigh(),
                        mFeedbackData1.getAttentionLow(),
                        mFeedbackData1.getAttentionWay(),
                        mFeedbackData1.getRelaxationHigh(),
                        mFeedbackData1.getRelaxationLow(),
                        mFeedbackData1.getRelaxationWay(),
                        mFeedbackData1.getWaySecond(),
                        mFeedbackData1.getWayStopTipSecond());

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.center, edit_FeedbackWay);
                fragmentTransaction.commit();
            }
        }
        );
//
//        String mId = mCursor.getString(mCursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_ID));
//        String mItem = mCursor.getString(mCursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_Item));
//        String mButton = mCursor.getString(mCursor.getColumnIndex(SettingDBContract.SettingDataEntry.COLUMN_ID));

//        holder.mId.setText(mId);
//        holder.mItem.setText(mItem);


    }

    @Override
    public int getItemCount() {
        return mFeedbackData.size();

    }

//    public void swapCursor (Cursor newCursor ){
//        if (mCursor!=null){
//            mCursor.close();
//        }
//        mCursor = newCursor;
//        if (newCursor!=null){
//            notifyDataSetChanged();
//        }

//    }

}
