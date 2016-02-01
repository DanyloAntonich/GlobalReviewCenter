package com.globalreviewcenter.view.fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.globalreviewcenter.R;
import com.globalreviewcenter.controller.Utilities.UIUtility;
import com.globalreviewcenter.view.HomeActivity;

import org.w3c.dom.Text;


public class MainFragment extends Fragment implements OnClickListener{

    private HomeActivity homeActivity;
    private EditText etFirstName, etLastName, etCompanyName, etCity, etCountry;
    private TextView tvVideo, tvAudio, tvText;
    private RelativeLayout rlpurchasePhoto, rlVideo, rlAudio, rlText;
    private ImageView[] ivStars;
    private ImageView ivCheck;
    private Button btnSubmit;
    private LinearLayout llVideoContainer, llPhotoContainer;

    String firstname, lastname, email, company, city, country, message, photoPath, audioPath;
    int rate;
    boolean isAgree;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initVariables();
        initUI(view);

        return view;
    }

    private void submit() {

    }
    private void capturePhoto() {

    }
    private void captureVideo() {

    }
    private void recordAudio() {

    }
    private void writeText() {

    }

    @Override
    public void onClick(View v) {
        if (!(v instanceof EditText) && UIUtility.keyboardShown(homeActivity)) {
            UIUtility.hideSoftKeyboard(homeActivity);
        }
        if (v == rlpurchasePhoto) {
            if (llVideoContainer.getChildCount() > 0) {
                llVideoContainer.removeAllViews();
            }
            llVideoContainer.setVisibility(View.GONE);
            llPhotoContainer.setVisibility(View.VISIBLE);

            rlVideo.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvVideo.setTextColor(getResources().getColor(R.color.grey));
            tvVideo.setTypeface(null, Typeface.NORMAL);

            rlAudio.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvAudio.setTextColor(getResources().getColor(R.color.grey));
            tvAudio.setTypeface(null, Typeface.NORMAL);

            rlText.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvText.setTextColor(getResources().getColor(R.color.grey));
            tvText.setTypeface(null, Typeface.NORMAL);


            capturePhoto();
        }
        if (v == rlVideo) {
            if (llPhotoContainer.getChildCount() > 0) {
                llPhotoContainer.removeAllViews();
            }
            llPhotoContainer.setVisibility(View.GONE);
            llVideoContainer.setVisibility(View.VISIBLE);


            rlVideo.setBackground(getResources().getDrawable(R.drawable.round_corner_strong_grey));
            tvVideo.setTextColor(getResources().getColor(R.color.dark));
            tvVideo.setTypeface(null, Typeface.BOLD);

            rlAudio.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvAudio.setTextColor(getResources().getColor(R.color.grey));
            tvAudio.setTypeface(null, Typeface.NORMAL);

            rlText.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvText.setTextColor(getResources().getColor(R.color.grey));
            tvText.setTypeface(null, Typeface.NORMAL);

            captureVideo();
        }
        if (v == rlAudio) {
            rlVideo.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvVideo.setTextColor(getResources().getColor(R.color.grey));
            tvVideo.setTypeface(null, Typeface.NORMAL);

            rlAudio.setBackground(getResources().getDrawable(R.drawable.round_corner_strong_grey));
            tvAudio.setTextColor(getResources().getColor(R.color.dark));
            tvAudio.setTypeface(null, Typeface.BOLD);

            rlText.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvText.setTextColor(getResources().getColor(R.color.grey));
            tvText.setTypeface(null, Typeface.NORMAL);
            recordAudio();
        }
        if (v == rlText) {
            rlVideo.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvVideo.setTextColor(getResources().getColor(R.color.grey));
            tvVideo.setTypeface(null, Typeface.NORMAL);

            rlAudio.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
            tvAudio.setTextColor(getResources().getColor(R.color.grey));
            tvAudio.setTypeface(null, Typeface.NORMAL);

            rlText.setBackground(getResources().getDrawable(R.drawable.round_corner_strong_grey));
            tvText.setTextColor(getResources().getColor(R.color.dark));
            tvText.setTypeface(null, Typeface.BOLD);

            writeText();
        }
        if (v == ivCheck) {
            if (isAgree) {
                isAgree = false;
                ivCheck.setImageDrawable(getResources().getDrawable(R.drawable.uncheck));
            } else {
                isAgree = true;
                ivCheck.setImageDrawable(getResources().getDrawable(R.drawable.checked));
            }
        }
        if (v == btnSubmit) {
            submit();
        }
        if (v == ivStars[0]) {
            fillStar(1);
        }
        if (v == ivStars[1]) {
            fillStar(2);
        }
        if (v == ivStars[2]) {
            fillStar(3);
        }
        if (v == ivStars[3]) {
            fillStar(4);
        }
        if (v == ivStars[4]) {
            fillStar(5);
        }

    }
    //////////////////input data
    private void fillStar(int mark) {
        for (int i = 0; i < 5; i ++ ) {
            if (i < mark) {
                ivStars[i].setImageDrawable(getResources().getDrawable(R.drawable.rating_star_on));
            } else {
                ivStars[i].setImageDrawable(getResources().getDrawable(R.drawable.rating_star_off));
            }
        }
    }
    //////////////  check values
    private boolean checkField() {
        return true;
    }
    private void initVariables() {
        firstname = "";
        lastname = "";
        email = "";
        company = "";
        city = "";
        country = "";
        message = "";
        photoPath = "";
        audioPath = "";
        rate = 0;
        isAgree = false;

    }

    private void initUI(View view) {
        etFirstName = (EditText)view.findViewById(R.id.et_main_firstname);
        etLastName = (EditText)view.findViewById(R.id.et_main_lastname);
        etCompanyName = (EditText)view.findViewById(R.id.et_main_company_name);
        etCity = (EditText)view.findViewById(R.id.et_main_city);
        etCountry = (EditText)view.findViewById(R.id.et_main_country);

        tvVideo = (TextView)view.findViewById(R.id.tv_main_video);
        tvAudio = (TextView)view.findViewById(R.id.tv_main_audio);
        tvText = (TextView)view.findViewById(R.id.tv_main_text);

        rlpurchasePhoto = (RelativeLayout)view.findViewById(R.id.prl_main_purchase_photo);
        rlpurchasePhoto.setOnClickListener(this);
        rlVideo = (RelativeLayout)view.findViewById(R.id.rl_main_video);
        rlVideo.setOnClickListener(this);
        rlAudio = (RelativeLayout)view.findViewById(R.id.rl_main_audio);
        rlAudio.setOnClickListener(this);
        rlText = (RelativeLayout)view.findViewById(R.id.rl_main_text);
        rlText.setOnClickListener(this);

        ivStars = new ImageView[5];
        ivStars[0] = (ImageView)view.findViewById(R.id.iv_main_star_0);
        ivStars[1] = (ImageView)view.findViewById(R.id.iv_main_star_1);
        ivStars[2] = (ImageView)view.findViewById(R.id.iv_main_star_2);
        ivStars[3] = (ImageView)view.findViewById(R.id.iv_main_star_3);
        ivStars[4] = (ImageView)view.findViewById(R.id.iv_main_star_4);

        ivStars[0].setOnClickListener(this);
        ivStars[1].setOnClickListener(this);
        ivStars[2].setOnClickListener(this);
        ivStars[3].setOnClickListener(this);
        ivStars[4].setOnClickListener(this);

        ivCheck = (ImageView)view.findViewById(R.id.iv_main_check);
        ivCheck.setOnClickListener(this);

        btnSubmit = (Button)view.findViewById(R.id.btn_main_submit);
        btnSubmit.setOnClickListener(this);

        llVideoContainer = (LinearLayout)view.findViewById(R.id.ll_main_container);
        llPhotoContainer = (LinearLayout)view.findViewById(R.id.ll_main_container0);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
       homeActivity = (HomeActivity)activity;
    }



}
