package com.example.day03donghua;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private ImageView mImage2;
    private RotateAnimation mRotateAnimation;
    private TranslateAnimation mTranslateAnimation;
    private ScaleAnimation mScaleAnimation;
    private AlphaAnimation mAlphaAnimation;
    private AnimationSet mAnimationSet;
    private ImageView mImage3;
    private ImageView mImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        //帧动画
        mImage = (ImageView) findViewById(R.id.image);
        mImage.setImageResource(R.drawable.frame_anim);
        AnimationDrawable animationDrawable1 = (AnimationDrawable) mImage.getDrawable();
        animationDrawable1.start();


        //补间动画
        mImage2 = (ImageView) findViewById(R.id.image2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.an_item);
        mImage2.startAnimation(animation);


        //java实现补间动画
        mImage3 = (ImageView) findViewById(R.id.image3);
        mRotateAnimation = new RotateAnimation(0, -720, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setDuration(2000);

        mTranslateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f);
        mTranslateAnimation.setDuration(2000);

        mScaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, ScaleAnimation.RELATIVE_TO_SELF,
                0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        mScaleAnimation.setDuration(2000);

        mAlphaAnimation = new AlphaAnimation(0, 1);
        mAlphaAnimation.setDuration(2000);


        mAnimationSet = new AnimationSet(true);
        mAnimationSet.addAnimation(mRotateAnimation);
        mAnimationSet.addAnimation(mTranslateAnimation);
        mAnimationSet.addAnimation(mScaleAnimation);
        mAnimationSet.addAnimation(mAlphaAnimation);
        //展示时间
        mAnimationSet.setDuration(4000);
        mAnimationSet.setFillAfter(true);

        mImage3.startAnimation(mAnimationSet);

        //属性动画
        mImage4 = (ImageView) findViewById(R.id.image4);
        RotateAnimation();
    }
    private void RotateAnimation() {
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mImage4, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(mImage4, "scaleX", 0.0f, 1.0f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(mImage4, "scaleY", 0.0f, 2.0f);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mImage4, "rotation", 0, 360);
        ObjectAnimator transXAnim = ObjectAnimator.ofFloat(mImage4, "translationX", 100, 400);
        ObjectAnimator transYAnim = ObjectAnimator.ofFloat(mImage4, "translationY", 100, 750);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
//                set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
        set.setDuration(3000);
        set.start();
    }
}
