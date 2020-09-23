package com.example.testsystemui;

import android.app.Activity;
import android.app.DirectAction;
import android.app.TaskStackBuilder;
import android.app.assist.AssistContent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;

import java.util.List;
import java.util.function.Consumer;

public class ColorfulMainActivity extends Activity {
    private static final String TAG_CLASS_NAME = "ColorfulActivity";

    /**********lifecycle begin**********/
    /////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyLog.output(TAG_CLASS_NAME, "onCreate", "");
        init();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyLog.output(TAG_CLASS_NAME, "onCreate2", "");
        init();
    }

    private void init() {
        getWindow().setStatusBarColor(Color.RED);
        getWindow().setNavigationBarColor(Color.GREEN);
        setContentView(R.layout.activity_colorful_main);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        MyLog.output(TAG_CLASS_NAME, "onPostCreate", "");
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        MyLog.output(TAG_CLASS_NAME, "onPostCreate2", "");
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLog.output(TAG_CLASS_NAME, "onStart", "");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MyLog.output(TAG_CLASS_NAME, "onRestart", "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyLog.output(TAG_CLASS_NAME, "onResume", "");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MyLog.output(TAG_CLASS_NAME, "onPostResume", "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLog.output(TAG_CLASS_NAME, "onPause", "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyLog.output(TAG_CLASS_NAME, "onStop", "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLog.output(TAG_CLASS_NAME, "onDestroy", "");
    }
    ///////////////////////////////////
    /**********lifecycle end**********/

    /**********input begin**********/
    //////////////////////////////////
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onKeyDown", "");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onKeyLongPress", "");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onKeyUp", "");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onKeyMultiple", "");
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MyLog.output(TAG_CLASS_NAME, "onBackPressed", "");
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onKeyShortcut", "");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onTouchEvent", "");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onTrackballEvent", "");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        MyLog.output(TAG_CLASS_NAME, "onGenericMotionEvent", "");
        return super.onGenericMotionEvent(event);
    }
    ///////////////////////////////////
    /**********input end**********/

    /**********config begin**********/
    //////////////////////////////////
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MyLog.output(TAG_CLASS_NAME, "onConfigurationChanged", "");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MyLog.output(TAG_CLASS_NAME, "onNewIntent", "");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MyLog.output(TAG_CLASS_NAME, "onActivityResult", "");
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        MyLog.output(TAG_CLASS_NAME, "onActivityReenter", "");
    }

    @Override
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);
        MyLog.output(TAG_CLASS_NAME, "onTopResumedActivityChanged", "");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MyLog.output(TAG_CLASS_NAME, "onAttachedToWindow", "");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MyLog.output(TAG_CLASS_NAME, "onDetachedFromWindow", "");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        MyLog.output(TAG_CLASS_NAME, "onWindowFocusChanged", "");
    }

    @Override
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
        MyLog.output(TAG_CLASS_NAME, "onWindowAttributesChanged", "");
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        MyLog.output(TAG_CLASS_NAME, "onMultiWindowModeChanged", "");
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        MyLog.output(TAG_CLASS_NAME, "onPictureInPictureModeChanged", "");
    }

    @Override
    public boolean onPictureInPictureRequested() {
        MyLog.output(TAG_CLASS_NAME, "onPictureInPictureRequested", "");
        return super.onPictureInPictureRequested();
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
        MyLog.output(TAG_CLASS_NAME, "onApplyThemeResource", "");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MyLog.output(TAG_CLASS_NAME, "onRequestPermissionsResult", "");
    }
    ///////////////////////////////////
    /**********config end**********/

    /**********data begin**********/
    //////////////////////////////////
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MyLog.output(TAG_CLASS_NAME, "onSaveInstanceState", "");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        MyLog.output(TAG_CLASS_NAME, "onSaveInstanceState2", "");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MyLog.output(TAG_CLASS_NAME, "onRestoreInstanceState", "");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        MyLog.output(TAG_CLASS_NAME, "onRestoreInstanceState2", "");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        MyLog.output(TAG_CLASS_NAME, "onLowMemory", "");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MyLog.output(TAG_CLASS_NAME, "onTrimMemory", "");
    }
    //////////////////////////////////
    /**********data end**********/

    /**********others begin**********/
    //////////////////////////////////
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        MyLog.output(TAG_CLASS_NAME, "onEnterAnimationComplete", "");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        MyLog.output(TAG_CLASS_NAME, "onContentChanged", "");
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        MyLog.output(TAG_CLASS_NAME, "onTitleChanged", "");
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
        MyLog.output(TAG_CLASS_NAME, "onChildTitleChanged", "");
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        MyLog.output(TAG_CLASS_NAME, "onCreateView", "");
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        MyLog.output(TAG_CLASS_NAME, "onCreateView", "");
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public CharSequence onCreateDescription() {
        MyLog.output(TAG_CLASS_NAME, "onCreateDescription", "");
        return super.onCreateDescription();
    }

    @Override
    public View onCreatePanelView(int featureId) {
        MyLog.output(TAG_CLASS_NAME, "onCreatePanelView", "");
        return super.onCreatePanelView(featureId);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        MyLog.output(TAG_CLASS_NAME, "onCreatePanelMenu", "");
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        MyLog.output(TAG_CLASS_NAME, "onPreparePanel", "");
        return super.onPreparePanel(featureId, view, menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        MyLog.output(TAG_CLASS_NAME, "onMenuOpened", "");
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        MyLog.output(TAG_CLASS_NAME, "onMenuItemSelected", "");
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
        MyLog.output(TAG_CLASS_NAME, "onPanelClosed", "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MyLog.output(TAG_CLASS_NAME, "onCreateOptionsMenu", "");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MyLog.output(TAG_CLASS_NAME, "onPrepareOptionsMenu", "");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MyLog.output(TAG_CLASS_NAME, "onOptionsItemSelected", "");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        MyLog.output(TAG_CLASS_NAME, "onOptionsMenuClosed", "");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MyLog.output(TAG_CLASS_NAME, "onCreateContextMenu", "");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        MyLog.output(TAG_CLASS_NAME, "onContextItemSelected", "");
        return super.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        MyLog.output(TAG_CLASS_NAME, "onContextMenuClosed", "");
    }

    @Override
    public boolean onNavigateUp() {
        MyLog.output(TAG_CLASS_NAME, "onNavigateUp", "");
        return super.onNavigateUp();
    }

    @Override
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onCreateNavigateUpTaskStack(builder);
        MyLog.output(TAG_CLASS_NAME, "onCreateNavigateUpTaskStack", "");
    }

    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onPrepareNavigateUpTaskStack(builder);
        MyLog.output(TAG_CLASS_NAME, "onPrepareNavigateUpTaskStack", "");
    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        MyLog.output(TAG_CLASS_NAME, "onSearchRequested", "");
        return super.onSearchRequested(searchEvent);
    }

    @Override
    public boolean onSearchRequested() {
        MyLog.output(TAG_CLASS_NAME, "onSearchRequested", "");
        return super.onSearchRequested();
    }

    @Override
    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        MyLog.output(TAG_CLASS_NAME, "onWindowStartingActionMode", "");
        return super.onWindowStartingActionMode(callback);
    }

    @Override
    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        MyLog.output(TAG_CLASS_NAME, "onWindowStartingActionMode", "");
        return super.onWindowStartingActionMode(callback, type);
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
        MyLog.output(TAG_CLASS_NAME, "onActionModeStarted", "");
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        MyLog.output(TAG_CLASS_NAME, "onActionModeFinished", "");
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
        MyLog.output(TAG_CLASS_NAME, "onProvideKeyboardShortcuts", "");
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);
        MyLog.output(TAG_CLASS_NAME, "onProvideAssistData", "");
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
        MyLog.output(TAG_CLASS_NAME, "onProvideAssistContent", "");
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        MyLog.output(TAG_CLASS_NAME, "onUserInteraction", "");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        MyLog.output(TAG_CLASS_NAME, "onUserLeaveHint", "");
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
        MyLog.output(TAG_CLASS_NAME, "onLocalVoiceInteractionStarted", "");
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
        MyLog.output(TAG_CLASS_NAME, "onLocalVoiceInteractionStopped", "");
    }

    @Override
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> callback) {
        super.onGetDirectActions(cancellationSignal, callback);
        MyLog.output(TAG_CLASS_NAME, "onGetDirectActions", "");
    }

    @Override
    public void onPerformDirectAction(String actionId, Bundle arguments, CancellationSignal cancellationSignal, Consumer<Bundle> resultListener) {
        super.onPerformDirectAction(actionId, arguments, cancellationSignal, resultListener);
        MyLog.output(TAG_CLASS_NAME, "onPerformDirectAction", "");
    }
    //////////////////////////////////
    /**********others end**********/

    public void onClick(View view) {
        MyLog.output(TAG_CLASS_NAME, "onClick", "");
        startActivity(new Intent(this, FullscreenActivity.class));
    }
}