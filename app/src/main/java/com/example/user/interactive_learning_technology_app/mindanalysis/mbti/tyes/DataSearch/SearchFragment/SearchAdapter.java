package com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.DataSearch.SearchFragment;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.user.interactive_learning_technology_app.R;
import com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.Experiment_Setting.FeeBackFrameSetting.Edit_FeedbackWay;
import com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.Experiment_Setting.FeeBackFrameSetting.FeedbackData;
import com.example.user.interactive_learning_technology_app.mindanalysis.mbti.tyes.Experiment_Setting.FeeBackFrameSetting.FeedbackFrameSettingsFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private ArrayList<DetectData> mDetectDataList;
    FeedbackFrameSettingsFragment feedbackFrameSettingsActivity;
    public ArrayList<String> mCheckBoxDataList = new ArrayList<String>();
    private Context mContext;
    private Cursor mCursor;

    public SearchAdapter(ArrayList<DetectData> detectData,
                          FeedbackFrameSettingsFragment feedbackFrameSettingsActivity){
        this.mDetectDataList =  detectData;
        this.feedbackFrameSettingsActivity = feedbackFrameSettingsActivity;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        public CheckBox mCheckbox;
        public TextView mId;
        public TextView mItem;
        public TextView mCount;
        public TextView mTimeDate;
        public Button mButton;


        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            mCheckbox = itemView.findViewById(R.id.settingCheckbox);
            mId = itemView.findViewById(R.id.settingId);
            mItem = itemView.findViewById(R.id.settingItem);
            mCount = itemView.findViewById(R.id.count);
            mTimeDate = itemView.findViewById(R.id.TimeDate);
            mButton = itemView.findViewById(R.id.settingButton);
        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_feedback_setting,parent,false);
        final SearchViewHolder holder = new SearchViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchViewHolder holder, final int position) {

        final DetectData mDetectData = this.mDetectDataList.get(position);

        holder.mId.setText(mDetectDataList.get(position).getId());
        holder.mItem.setText(mDetectDataList.get(position).getItem());
        holder.mCheckbox.setTag(position);
        holder.mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Object position1 = compoundButton.getTag();

                if (holder.mCheckbox.isChecked()){
                    mCheckBoxDataList.add(mDetectData.getId());
                    Log.d("yoyo",""+position1);
                    Log.d("yoyoCheck",""+mCheckBoxDataList);
                } else{
                    mCheckBoxDataList.remove(position1.toString());
                    Log.d("yoyo",""+position1);
                    Log.d("yoyoCheck",""+mCheckBoxDataList);

                }
            }
        });


//        holder.mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fragmentManager = feedbackFrameSettingsActivity.getActivity().getSupportFragmentManager();
//                Edit_FeedbackWay edit_FeedbackWay = new Edit_FeedbackWay(
//                        mFeedbackData.getId(),
//                        mFeedbackData.getName(),
//                        mFeedbackData.getItem(),
//                        mFeedbackData.getAttentionHigh(),
//                        mFeedbackData.getAttentionLow(),
//                        mFeedbackData.getAttentionWay(),
//                        mFeedbackData.getRelaxationHigh(),
//                        mFeedbackData.getRelaxationLow(),
//                        mFeedbackData.getRelaxationWay(),
//                        mFeedbackData.getWaySecond(),
//                        mFeedbackData.getWayStopTipSecond());
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.center, edit_FeedbackWay);
//                fragmentTransaction.commit();
//            }
//        }
//        );
    }
    public ArrayList<String> getId(){
        return  mCheckBoxDataList;
    }

    @Override
    public int getItemCount() {
        return mDetectDataList.size();

    }

    public void removeItem(int position){
        mDetectDataList.remove(position);
        notifyItemRemoved(position);
    }
}