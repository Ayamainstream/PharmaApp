package com.example.pharmacy.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;
import com.example.pharmacy.R;


/**
 * <h1>IntroActivity</h1>
 * <p>Using AppIntro:5.1.0 library.</p>
 */
public class IntroActivity extends AppIntro {
    /**
     * <h1>IntroActivity</h1>
     * <p>Using AppIntro:5.1.0 library.</p>
     * This is onCreate for the intro
     * doesn't need activity.xml!
     * <br>
     * Just need too add an object of SliderPage class
     * to addSlide() function to represent your intro slid!
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("Аптека");
        sliderPage.setDescription("Закажите в нашей аптеке в несколько кликов");
        sliderPage.setImageDrawable(R.drawable.logo);
        sliderPage.setBgColor(getResources().getColor(R.color.intro_bg_1));
        addSlide(AppIntroFragment.newInstance(sliderPage));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Бесплатная доставка");
        sliderPage2.setDescription("Ваш заказ будет доставлен бесплатно ;)");
        sliderPage2.setImageDrawable(R.drawable.deliveryman);
        sliderPage2.setBgColor(getResources().getColor(R.color.intro_bg_2));
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("Оплата по прибытии");
        sliderPage3.setDescription("Вам не нужен какой-либо способ оплаты для заказа, мы возьмем сумму, когда заказ прибудет к вам домой :)");
        sliderPage3.setImageDrawable(R.drawable.pay);
        sliderPage3.setBgColor(getResources().getColor(R.color.intro_bg_3));
        addSlide(AppIntroFragment.newInstance(sliderPage3));

        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle("Трекинг ваших заказов");
        sliderPage4.setDescription("Наше приложение позволяет вам видеть статус вашего заказа и историю заказов!");
        sliderPage4.setImageDrawable(R.drawable.order);
        sliderPage4.setBgColor(getResources().getColor(R.color.intro_bg_4));
        addSlide(AppIntroFragment.newInstance(sliderPage4));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(10);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    /**
     * Finish the intro when press on done
     *
     * @param currentFragment the fragment is currently appear for user.
     */
    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
