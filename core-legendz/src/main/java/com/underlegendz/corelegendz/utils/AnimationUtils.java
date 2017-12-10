package com.underlegendz.corelegendz.utils;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/** Class containing animations to show/hide views and startUrl activities. */
public class AnimationUtils {

  public static Animation scale(long duration, float from, float to) {
    Animation scaleUp = new ScaleAnimation(from, to, from, to, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    scaleUp.setDuration(duration);
    scaleUp.setInterpolator(new AccelerateInterpolator());
    scaleUp.setFillAfter(true);
    return scaleUp;
  }

  /**
   * Sets an animation that scales up a view in 500 milliseconds. Calls {@link #scaleUp(long)}.
   * You must set visibility to {@link android.view.View#VISIBLE} before starting the animation.
   *
   * @return An {@code Animation} set to scale up a view.
   */
  public static Animation scaleUp() {
    return scaleUp(500);
  }

  /**
   * Sets an animation that scales up a view in {@code duration} milliseconds.
   * You must set visibility to {@link android.view.View#VISIBLE} before starting the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to scale up a view.
   */
  public static Animation scaleUp(long duration) {
    Animation scaleUp = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
    scaleUp.setDuration(duration);
    scaleUp.setInterpolator(new AccelerateInterpolator());
    return scaleUp;
  }

  /**
   * Sets an animation that scales down a view in 500 milliseconds.
   * Calls {@link #scaleDown(long)}. You must set this view to {@link android.view.View#GONE} or
   * {@link android.view.View#INVISIBLE} after the animation has finished.
   *
   * @return An {@code Animation} set to scale down a view.
   */
  public static Animation scaleDown() {
    return scaleDown(500);
  }

  /**
   * Sets an animation that scales down a view in {@code duration} milliseconds. You must set this
   * view to
   * {@link android.view.View#GONE} or {@link android.view.View#INVISIBLE} after the animation
   * has finished.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to scale down a view.
   */
  public static Animation scaleDown(long duration) {
    Animation scaleDown = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f);
    scaleDown.setDuration(duration);
    scaleDown.setInterpolator(new AccelerateInterpolator());
    return scaleDown;
  }

  /**
   * Sets an animation to fade in a view in 500 milliseconds. Calls {@link #fadeIn(long)}. You
   * must set the view's visibility to {@link android.view.View#VISIBLE} before starting the
   * animation.
   *
   * @return An {@code Animation} set to fade in a view.
   */
  public static Animation fadeIn() {
    return fadeIn(500);
  }

  /**
   * Sets an animation to fade in a view in {@code duration} milliseconds. Calls
   * {@link #fadeIn(long)}. You must set the view's visibility to
   * {@link android.view.View#VISIBLE} before starting the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to fade in a view.
   */
  public static Animation fadeIn(long duration) {
    Animation fadeIn = new AlphaAnimation(0, 1);
    fadeIn.setInterpolator(new AccelerateInterpolator());
    fadeIn.setDuration(duration);
    return fadeIn;
  }

  /**
   * Sets an animation to fade out a view in 500 milliseconds. Calls {@link #fadeOut(long)}.
   * You must set the view's visibility to {@link android.view.View#GONE} or
   * {@link android.view.View#INVISIBLE} after the animation ends.
   *
   * @return An {@code Animation} set to fade out a view.
   */
  public static Animation fadeOut() {
    return fadeOut(500);
  }

  /**
   * Sets an animation to fade out a view in {@code duration} milliseconds. You must set the
   * view's visibility to {@link android.view.View#GONE} or {@link android.view.View#INVISIBLE}
   * after the animation ends.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to fade out a view.
   */
  public static Animation fadeOut(long duration) {
    Animation fadeOut = new AlphaAnimation(1, 0);
    fadeOut.setInterpolator(new DecelerateInterpolator());
    fadeOut.setDuration(duration);
    fadeOut.setFillAfter(true);
    return fadeOut;
  }

  /**
   * Sets an animation to slide in a view from the right side of its parent view in 500
   * milliseconds. Calls {@link #inFromRight(long)}. Remember your view must be
   * {@link android.view.View#VISIBLE}.
   *
   * @return An {@code Animation} set to make a view enter from the right.
   */
  public static Animation inFromRight() {
    return inFromRight(500);
  }

  /**
   * Sets an animation to slide in a view from the right side of its parent view in
   * {@code duration} milliseconds. Remember your view must be {@link android.view.View#VISIBLE}.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to make a view enter from the right.
   */
  public static Animation inFromRight(long duration) {
    Animation inFromRight =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, +1.0f, Animation.RELATIVE_TO_PARENT,
            0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    inFromRight.setDuration(duration);
    inFromRight.setInterpolator(new DecelerateInterpolator());
    return inFromRight;
  }

  /**
   * Sets an animation to slide out a view towards the right side of its parent view in 500
   * milliseconds. Calls {@link #outToLeft(long)}. There's no need to set your view's visibility
   * to {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the
   * animation.
   *
   * @return An {@code Animation} set to slide out a view towards the right.
   */
  public static Animation outToRight() {
    return outToRight(500);
  }

  /**
   * Sets an animation to slide out a view towards the right side of its parent view in
   * {@code duration} milliseconds. There's no need to set your view's visibility to
   * {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to slide out a view towards the right.
   */
  public static Animation outToRight(long duration) {
    Animation outToRight =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
            +1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    outToRight.setDuration(duration);
    outToRight.setInterpolator(new AccelerateInterpolator());
    return outToRight;
  }

  /**
   * Sets an animation to slide in a view from the left side of its parent view in 500
   * milliseconds. Calls {@link #inFromLeft(long)}. Remember your view must be visible.
   *
   * @return An {@code Animation} set to make a view enter from the left.
   */
  public static Animation inFromLeft() {
    return inFromLeft(500);
  }

  /**
   * Sets an animation to slide in a view from the left side of its parent view in
   * {@code duration} milliseconds. Remember your view must be visible.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to make a view enter from the left.
   */
  public static Animation inFromLeft(long duration) {
    Animation inFromLeft =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT,
            0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    inFromLeft.setDuration(duration);
    inFromLeft.setInterpolator(new AccelerateInterpolator());
    return inFromLeft;
  }

  /**
   * Sets an animation to slide out a view towards the left side of its parent view in 500
   * milliseconds. Calls {@link #outToLeft(long)}. There's no need to set your view's visibility
   * to {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the animation.
   *
   * @return An {@code Animation} set to slide out a view towards the left.
   */
  public static Animation outToLeft() {
    return outToLeft(500);
  }

  /**
   * Sets an animation to slide out a view towards the left side of its parent view in
   * {@code duration} milliseconds. There's no need to set your view's visibility to
   * {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to slide out a view towards the left.
   */
  public static Animation outToLeft(long duration) {
    Animation outToLeft =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
            -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    outToLeft.setDuration(duration);
    outToLeft.setInterpolator(new AccelerateInterpolator());
    return outToLeft;
  }

  /**
   * Sets an animation to slide in a view from the bottom of its parent view in 500 milliseconds.
   * Calls {@link #inFromBottom(long)}. Your view must be visible. before starting the animation.
   *
   * @return An {@code Animation} set to make a view enter from the bottom.
   */
  public static Animation inFromBottom() {
    return inFromBottom(500);
  }

  /**
   * Sets an animation to slide in a view from the bottom of its parent view in {@code duration}
   * milliseconds. Your view must be visible before the animation starts.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to make a view enter from the bottom.
   */
  public static Animation inFromBottom(long duration) {
    Animation inFromBottom =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
            0.0f, Animation.RELATIVE_TO_PARENT, +1.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    inFromBottom.setDuration(duration);
    inFromBottom.setFillAfter(true);
    inFromBottom.setInterpolator(new DecelerateInterpolator());
    return inFromBottom;
  }

  /**
   * Sets an animation to slide out a view towards the bottom of its parent view in 500
   * milliseconds. Calls {@link #outToBottom(long)}. There's no need to set your view's visibility
   * to {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the
   * animation.
   *
   * @return An {@code Animation} set to slide out a view towards the bottom.
   */
  public static Animation outToBottom() {
    return outToBottom(500);
  }

  /**
   * Sets an animation to slide out a view towards the bottom of its parent view in
   * {@code duration} milliseconds. There's no need to set your view's visibility to
   * {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to slide out a view towards the bottom.
   */
  public static Animation outToBottom(long duration) {
    Animation outToBottom =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
            0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, +1.0f);
    outToBottom.setDuration(duration);
    outToBottom.setFillAfter(true);
    outToBottom.setInterpolator(new DecelerateInterpolator());
    return outToBottom;
  }

  /**
   * Sets an animation to slide in a view from the top of its parent view in 500 milliseconds.
   * Calls {@link #inFromTop(long)}.Remember your view must be visible before starting the
   * animation.
   *
   * @return An {@code Animation} set to slide in a view from the top.
   */
  public static Animation inFromTop() {
    return inFromTop(500);
  }

  /**
   * Sets an animation to slide in a view from the top of its parent view in {@code duration}
   * milliseconds. Remember your view must be visible before starting the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to slide in from the top.
   */
  public static Animation inFromTop(long duration) {
    Animation inFromTop =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
            0.0f, Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    inFromTop.setDuration(duration);
    inFromTop.setFillAfter(true);
    inFromTop.setInterpolator(new DecelerateInterpolator());
    return inFromTop;
  }

  /**
   * Sets an animation to slide out a view towards the top of its parent view in 500 milliseconds.
   * There's no need to set your view's visibility to
   * {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the animation.
   *
   * @return An {@code Animation} set to slide out a view towards the top.
   */
  public static Animation outToTop() {
    return outToTop(500);
  }

  /**
   * Sets an animation to slide out a view towards the top side of its parent view in
   * {@code duration} milliseconds. There's no need to set your view's visibility to
   * {@link android.view.View#INVISIBLE} nor {@link android.view.View#GONE} after the animation.
   *
   * @param duration The duration of the animation in milliseconds.
   * @return An {@code Animation} set to slide out a view towards the top.
   */
  public static Animation outToTop(long duration) {
    Animation outToTop =
        new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
            0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f);
    outToTop.setDuration(duration);
    outToTop.setFillAfter(true);
    outToTop.setInterpolator(new DecelerateInterpolator());
    return outToTop;
  }

  public static Animation rotate(float startDegrees, float endDegrees) {
    Animation rotate =
        new RotateAnimation(startDegrees, endDegrees, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(250);
    rotate.setFillAfter(true);
    rotate.setInterpolator(new DecelerateInterpolator());
    return rotate;
  }

  /**
   * A custom listener that implements {@code AnimationListener} and overrides
   * {@code onAnimationStart()} and {@code onAnimationRepeat()} leaving their bodies empty. It can
   * be used in place of {@code AnimationListener} if you only need to override
   * {@code onAnimationEnd()}, avoiding thus having to add pointless boilerplate code to your
   * class.
   * <br/><br/>
   * Whenever you need to do something after the animation is over but not when it starts nor
   * while the animation is in progress, you can add an {@code AnimationEndListener} to your
   * {@code Animation} like this:
   *
   * <pre>
   * animation.setAnimationListener(new AnimationEndListener() {
   *      {@literal@}Override
   *      public void onAnimationEnd(Animation animation) {
   *          //Code to be executed when animation ends.
   *      }
   * });</pre>
   */
  public static abstract class AnimationEndListener implements Animation.AnimationListener {

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
  }
}