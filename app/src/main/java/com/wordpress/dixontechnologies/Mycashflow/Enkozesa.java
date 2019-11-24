package com.wordpress.dixontechnologies.Mycashflow;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.ISlideBackgroundColorHolder;
import com.github.paolorotolo.appintro.model.SliderPage;

public class Enkozesa extends AppIntro implements CurrencySlide.OnFragmentInteractionListener

{

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int slide1color = getResources().getColor(R.color.primaryLightColor);



        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("Hello,\nWelcome");
        sliderPage1.setBgColor(slide1color);
        sliderPage1.setDescription("Nusu is a financial record keeping assistant that runs a simple cash flow report.");
     sliderPage1.setImageDrawable(R.drawable.slide1_);
/*
        sliderPage1.setBgColor(slide1color);
*/
        addSlide(AppIntroFragment.newInstance(sliderPage1));


        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("Why Use Nusu ?");
        sliderPage.setBgColor(slide1color);
        sliderPage.setDescription("Keep track of things like cash going in and out of the business or at a personal level.");
        sliderPage.setImageDrawable(R.drawable.slider1);

        addSlide(AppIntroFragment.newInstance(sliderPage));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("How It Works");
        sliderPage2.setBgColor(slide1color);
        sliderPage2.setDescription("It classifies items as Expenses and Cash items. Expenses like rent, mortgage, in monthly loan-payments, and in payments for taxes and other accounts payable.");

        sliderPage2.setImageDrawable(R.drawable.classification_slide);
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        addSlide(new CurrencySlide());

       showSeparator(false);
        setProgressButtonEnabled(true);
        setBarColor(Color.parseColor("#3f51B5"));
        showSkipButton(false);
        setDoneText("Done");
        setFadeAnimation();
      //  setFlowAnimation();


        setBarColor(slide1color);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enkozesa.this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setVisibility(View.VISIBLE);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {
            uri.getFragment();
    }
}
