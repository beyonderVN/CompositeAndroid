package com.pascalwelsch.compositeandroid.blueprints;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.VoiceInteractionService;
import android.service.voice.VoiceInteractionSession;
import android.service.vr.VrListenerService;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

// 25.2.0
@SuppressWarnings("ALL")
public class BlueprintActivity extends AppCompatActivity {

    @Override
    public void addContentView(final View view, final ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    /**
     * Call to set an "override configuration" on this context -- this is
     * a configuration that replies one or more values of the standard
     * configuration that is applied to the context.  See
     * {@link Context#createConfigurationContext(Configuration)} for more
     * information.
     *
     * <p>This method can only be called once, and must be called before any
     * calls to {@link #getResources()} or {@link #getAssets()} are made.
     */
    @Override
    public void applyOverrideConfiguration(final Configuration overrideConfiguration) {
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public boolean bindService(final Intent service, final ServiceConnection conn,
            final int flags) {
        return super.bindService(service, conn, flags);
    }

    @Override
    public int checkCallingOrSelfPermission(final String permission) {
        return super.checkCallingOrSelfPermission(permission);
    }

    @Override
    public int checkCallingOrSelfUriPermission(final Uri uri, final int modeFlags) {
        return super.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    @Override
    public int checkCallingPermission(final String permission) {
        return super.checkCallingPermission(permission);
    }

    @Override
    public int checkCallingUriPermission(final Uri uri, final int modeFlags) {
        return super.checkCallingUriPermission(uri, modeFlags);
    }

    @Override
    public int checkPermission(final String permission, final int pid, final int uid) {
        return super.checkPermission(permission, pid, uid);
    }

    @Override
    public int checkSelfPermission(final String permission) {
        return super.checkSelfPermission(permission);
    }

    @Override
    public int checkUriPermission(final Uri uri, final int pid, final int uid,
            final int modeFlags) {
        return super.checkUriPermission(uri, pid, uid, modeFlags);
    }

    @Override
    public int checkUriPermission(final Uri uri, final String readPermission,
            final String writePermission, final int pid,
            final int uid, final int modeFlags) {
        return super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    @Override
    public void clearWallpaper() throws IOException {
        super.clearWallpaper();
    }

    /**
     * Programmatically closes the most recently opened context menu, if showing.
     */
    @Override
    public void closeContextMenu() {
        super.closeContextMenu();
    }

    /**
     * Progammatically closes the options menu. If the options menu is already
     * closed, this method does nothing.
     */
    @Override
    public void closeOptionsMenu() {
        super.closeOptionsMenu();
    }

    @Override
    public Context createConfigurationContext(final Configuration overrideConfiguration) {
        return super.createConfigurationContext(overrideConfiguration);
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        return super.createDeviceProtectedStorageContext();
    }

    @Override
    public Context createDisplayContext(final Display display) {
        return super.createDisplayContext(display);
    }

    @Override
    public Context createPackageContext(final String packageName, final int flags)
            throws PackageManager.NameNotFoundException {
        return super.createPackageContext(packageName, flags);
    }

    /**
     * Create a new PendingIntent object which you can hand to others
     * for them to use to send result data back to your
     * {@link #onActivityResult} callback.  The created object will be either
     * one-shot (becoming invalid after a result is sent back) or multiple
     * (allowing any number of results to be sent through it).
     *
     * @param requestCode Private request code for the sender that will be
     *                    associated with the result data when it is returned.  The sender can not
     *                    modify this value, allowing you to identify incoming results.
     * @param data        Default data to supply in the result, which may be modified
     *                    by the sender.
     * @param flags       May be {@link PendingIntent#FLAG_ONE_SHOT PendingIntent.FLAG_ONE_SHOT},
     *                    {@link PendingIntent#FLAG_NO_CREATE PendingIntent.FLAG_NO_CREATE},
     *                    {@link PendingIntent#FLAG_CANCEL_CURRENT PendingIntent.FLAG_CANCEL_CURRENT},
     *                    {@link PendingIntent#FLAG_UPDATE_CURRENT PendingIntent.FLAG_UPDATE_CURRENT},
     *                    or any of the flags as supported by
     *                    {@link Intent#fillIn Intent.fillIn()} to control which unspecified parts
     *                    of the intent that can be supplied when the actual send happens.
     * @return Returns an existing or new PendingIntent matching the given
     * parameters.  May return null only if
     * {@link PendingIntent#FLAG_NO_CREATE PendingIntent.FLAG_NO_CREATE} has been
     * supplied.
     * @see PendingIntent
     */
    @Override
    public PendingIntent createPendingResult(final int requestCode, final Intent data,
            final int flags) {
        return super.createPendingResult(requestCode, data, flags);
    }

    @Override
    public String[] databaseList() {
        return super.databaseList();
    }

    @Override
    public boolean deleteDatabase(final String name) {
        return super.deleteDatabase(name);
    }

    @Override
    public boolean deleteFile(final String name) {
        return super.deleteFile(name);
    }

    @Override
    public boolean deleteSharedPreferences(final String name) {
        return super.deleteSharedPreferences(name);
    }

    /**
     * Called to process generic motion events.  You can override this to
     * intercept all generic motion events before they are dispatched to the
     * window.  Be sure to call this implementation for generic motion events
     * that should be handled normally.
     *
     * @param ev The generic motion event.
     * @return boolean Return true if this event was consumed.
     */
    @Override
    public boolean dispatchGenericMotionEvent(final MotionEvent ev) {
        return super.dispatchGenericMotionEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(final KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    /**
     * Called to process a key shortcut event.
     * You can override this to intercept all key shortcut events before they are
     * dispatched to the window.  Be sure to call this implementation for key shortcut
     * events that should be handled normally.
     *
     * @param event The key shortcut event.
     * @return True if this event was consumed.
     */
    @Override
    public boolean dispatchKeyShortcutEvent(final KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    /**
     * Called to process touch screen events.  You can override this to
     * intercept all touch screen events before they are dispatched to the
     * window.  Be sure to call this implementation for touch screen events
     * that should be handled normally.
     *
     * @param ev The touch screen event.
     * @return boolean Return true if this event was consumed.
     */
    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Called to process trackball events.  You can override this to
     * intercept all trackball events before they are dispatched to the
     * window.  Be sure to call this implementation for trackball events
     * that should be handled normally.
     *
     * @param ev The trackball event.
     * @return boolean Return true if this event was consumed.
     */
    @Override
    public boolean dispatchTrackballEvent(final MotionEvent ev) {
        return super.dispatchTrackballEvent(ev);
    }

    /**
     * Print the Activity's state into the given stream.  This gets invoked if
     * you run "adb shell dumpsys activity <activity_component_name>".
     *
     * @param prefix Desired prefix to prepend at each line of output.
     * @param fd     The raw file descriptor that the dump is being sent to.
     * @param writer The PrintWriter to which you should dump your state.  This will be
     *               closed for you after you return.
     * @param args   additional arguments to the dump request.
     */
    @Override
    public void dump(final String prefix, final FileDescriptor fd, final PrintWriter writer,
            final String[] args) {
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public void enforceCallingOrSelfPermission(final String permission, final String message) {
        super.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public void enforceCallingOrSelfUriPermission(final Uri uri, final int modeFlags,
            final String message) {
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceCallingPermission(final String permission, final String message) {
        super.enforceCallingPermission(permission, message);
    }

    @Override
    public void enforceCallingUriPermission(final Uri uri, final int modeFlags,
            final String message) {
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforcePermission(final String permission, final int pid, final int uid,
            final String message) {
        super.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public void enforceUriPermission(final Uri uri, final int pid, final int uid,
            final int modeFlags, final String message) {
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public void enforceUriPermission(final Uri uri, final String readPermission,
            final String writePermission,
            final int pid, final int uid, final int modeFlags, final String message) {
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags,
                message);
    }

    /**
     * Puts the activity in picture-in-picture mode.
     *
     * @see android.R.attr#supportsPictureInPicture
     */
    @Override
    public void enterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    @Override
    public String[] fileList() {
        return super.fileList();
    }

    @Override
    public View findViewById(@IdRes final int id) {
        return super.findViewById(id);
    }

    /**
     * Call this when your activity is done and should be closed.  The
     * ActivityResult is propagated back to whoever launched you via
     * onActivityResult().
     */
    @Override
    public void finish() {
        super.finish();
    }

    /**
     * Force finish another activity that you had previously started with
     * {@link #startActivityForResult}.
     *
     * @param requestCode The request code of the activity that you had
     *                    given to startActivityForResult().  If there are multiple
     *                    activities started with this request code, they
     *                    will all be finished.
     */
    @Override
    public void finishActivity(final int requestCode) {
        super.finishActivity(requestCode);
    }

    /**
     * This is called when a child activity of this one calls its
     * finishActivity().
     *
     * @param child       The activity making the call.
     * @param requestCode Request code that had been used to start the
     */
    @Override
    public void finishActivityFromChild(final Activity child, final int requestCode) {
        super.finishActivityFromChild(child, requestCode);
    }

    /**
     * Finish this activity as well as all activities immediately below it
     * in the current task that have the same affinity.  This is typically
     * used when an application can be launched on to another task (such as
     * from an ACTION_VIEW of a content type it understands) and the user
     * has used the up navigation to switch out of the current task and in
     * to its own task.  In this case, if the user has navigated down into
     * any other activities of the second application, all of those should
     * be removed from the original task as part of the task switch.
     *
     * <p>Note that this finish does <em>not</em> allow you to deliver results
     * to the previous activity, and an exception will be thrown if you are trying
     * to do so.</p>
     */
    @Override
    public void finishAffinity() {
        super.finishAffinity();
    }

    /**
     * Reverses the Activity Scene entry Transition and triggers the calling Activity
     * to reverse its exit Transition. When the exit Transition completes,
     * {@link #finish()} is called. If no entry Transition was used, finish() is called
     * immediately and the Activity exit Transition is run.
     *
     * @see ActivityOptions#makeSceneTransitionAnimation(Activity, Pair[])
     */
    @Override
    public void finishAfterTransition() {
        super.finishAfterTransition();
    }

    /**
     * Call this when your activity is done and should be closed and the task should be completely
     * removed as a part of finishing the root activity of the task.
     */
    @Override
    public void finishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    /**
     * This is called when a child activity of this one calls its
     * {@link #finish} method.  The default implementation simply calls
     * finish() on this activity (the parent), finishing the entire group.
     *
     * @param child The activity making the call.
     * @see #finish
     */
    @Override
    public void finishFromChild(final Activity child) {
        super.finishFromChild(child);
    }

    /**
     * Retrieve a reference to this activity's ActionBar.
     *
     * @return The Activity's ActionBar, or null if it does not have one.
     */
    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        return super.getActionBar();
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return super.getApplicationInfo();
    }

    @Override
    public AssetManager getAssets() {
        return super.getAssets();
    }

    /**
     * @return the base context as set by the constructor or setBaseContext
     */
    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override
    public File getCacheDir() {
        return super.getCacheDir();
    }

    /**
     * Return the name of the activity that invoked this activity.  This is
     * who the data in {@link #setResult setResult()} will be sent to.  You
     * can use this information to validate that the recipient is allowed to
     * receive the data.
     *
     * <p class="note">Note: if the calling activity is not expecting a result (that is it
     * did not use the {@link #startActivityForResult}
     * form that includes a request code), then the calling package will be
     * null.
     *
     * @return The ComponentName of the activity that will receive your
     * reply, or null if none.
     */
    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        return super.getCallingActivity();
    }

    /**
     * Return the name of the package that invoked this activity.  This is who
     * the data in {@link #setResult setResult()} will be sent to.  You can
     * use this information to validate that the recipient is allowed to
     * receive the data.
     *
     * <p class="note">Note: if the calling activity is not expecting a result (that is it
     * did not use the {@link #startActivityForResult}
     * form that includes a request code), then the calling package will be
     * null.</p>
     *
     * <p class="note">Note: prior to {@link Build.VERSION_CODES#JELLY_BEAN_MR2},
     * the result from this method was unstable.  If the process hosting the calling
     * package was no longer running, it would return null instead of the proper package
     * name.  You can use {@link #getCallingActivity()} and retrieve the package name
     * from that instead.</p>
     *
     * @return The package of the activity that will receive your
     * reply, or null if none.
     */
    @Nullable
    @Override
    public String getCallingPackage() {
        return super.getCallingPackage();
    }

    /**
     * If this activity is being destroyed because it can not handle a
     * configuration parameter being changed (and thus its
     * {@link #onConfigurationChanged(Configuration)} method is
     * <em>not</em> being called), then you can use this method to discover
     * the set of changes that have occurred while in the process of being
     * destroyed.  Note that there is no guarantee that these will be
     * accurate (other changes could have happened at any time), so you should
     * only use this as an optimization hint.
     *
     * @return Returns a bit field of the configuration parameters that are
     * changing, as defined by the {@link Configuration}
     * class.
     */
    @Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override
    public ClassLoader getClassLoader() {
        return super.getClassLoader();
    }

    @Override
    public File getCodeCacheDir() {
        return super.getCodeCacheDir();
    }

    /**
     * Returns complete component name of this activity.
     *
     * @return Returns the complete component name for this activity
     */
    @Override
    public ComponentName getComponentName() {
        return super.getComponentName();
    }

    @Override
    public ContentResolver getContentResolver() {
        return super.getContentResolver();
    }

    /**
     * Retrieve the {@link Scene} representing this window's current content.
     * Requires {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * <p>This method will return null if the current content is not represented by a Scene.</p>
     *
     * @return Current Scene being shown or null
     */
    @Override
    public Scene getContentScene() {
        return super.getContentScene();
    }

    /**
     * Retrieve the {@link TransitionManager} responsible for default transitions in this window.
     * Requires {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * <p>This method will return non-null after content has been initialized (e.g. by using
     * {@link #setContentView}) if {@link Window#FEATURE_CONTENT_TRANSITIONS} has been granted.</p>
     *
     * @return This window's content TransitionManager or null if none is set.
     */
    @Override
    public TransitionManager getContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    /**
     * Calls {@link Window#getCurrentFocus} on the
     * Window of this Activity to return the currently focused view.
     *
     * @return View The current View with focus or null.
     * @see #getWindow
     * @see Window#getCurrentFocus
     */
    @Nullable
    @Override
    public View getCurrentFocus() {
        return super.getCurrentFocus();
    }

    @Override
    public File getDataDir() {
        return super.getDataDir();
    }

    @Override
    public File getDatabasePath(final String name) {
        return super.getDatabasePath(name);
    }

    /**
     * @return The {@link AppCompatDelegate} being used by this Activity.
     */
    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return super.getDelegate();
    }

    @Override
    public File getDir(final String name, final int mode) {
        return super.getDir(name, mode);
    }

    @Nullable
    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return super.getDrawerToggleDelegate();
    }

    @Override
    public File getExternalCacheDir() {
        return super.getExternalCacheDir();
    }

    @Override
    public File[] getExternalCacheDirs() {
        return super.getExternalCacheDirs();
    }

    @Override
    public File getExternalFilesDir(final String type) {
        return super.getExternalFilesDir(type);
    }

    @Override
    public File[] getExternalFilesDirs(final String type) {
        return super.getExternalFilesDirs(type);
    }

    @Override
    public File[] getExternalMediaDirs() {
        return super.getExternalMediaDirs();
    }

    /**
     * Retrieves a previously set {@link ExtraData} by class name.
     *
     * @hide
     * @see #putExtraData
     */
    @Override
    public <T extends ExtraData> T getExtraData(final Class<T> extraDataClass) {
        return super.getExtraData(extraDataClass);
    }

    @Override
    public File getFileStreamPath(final String name) {
        return super.getFileStreamPath(name);
    }

    @Override
    public File getFilesDir() {
        return super.getFilesDir();
    }

    /**
     * Return the FragmentManager for interacting with fragments associated
     * with this activity.
     */
    @Override
    public android.app.FragmentManager getFragmentManager() {
        return super.getFragmentManager();
    }

    /**
     * Return the intent that started this activity.
     */
    @Override
    public Intent getIntent() {
        return super.getIntent();
    }

    /**
     * Return the value previously returned from
     * {@link #onRetainCustomNonConfigurationInstance()}.
     */
    @Override
    public Object getLastCustomNonConfigurationInstance() {
        return super.getLastCustomNonConfigurationInstance();
    }

    /**
     * Retrieve the non-configuration instance data that was previously
     * returned by {@link #onRetainNonConfigurationInstance()}.  This will
     * be available from the initial {@link #onCreate} and
     * {@link #onStart} calls to the new instance, allowing you to extract
     * any useful dynamic state from the previous instance.
     *
     * <p>Note that the data you retrieve here should <em>only</em> be used
     * as an optimization for handling configuration changes.  You should always
     * be able to handle getting a null pointer back, and an activity must
     * still be able to restore itself to its previous state (through the
     * normal {@link #onSaveInstanceState(Bundle)} mechanism) even if this
     * function returns null.
     *
     * <p><strong>Note:</strong> For most cases you should use the {@link Fragment} API
     * {@link Fragment#setRetainInstance(boolean)} instead; this is also
     * available on older platforms through the Android support libraries.
     *
     * @return the object previously returned by {@link #onRetainNonConfigurationInstance()}
     */
    @Nullable
    @Override
    public Object getLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    /**
     * Convenience for calling
     * {@link Window#getLayoutInflater}.
     */
    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        return super.getLayoutInflater();
    }

    /**
     * Return the LoaderManager for this activity, creating it if needed.
     */
    @Override
    public android.app.LoaderManager getLoaderManager() {
        return super.getLoaderManager();
    }

    /**
     * Returns class name for this activity with the package prefix removed.
     * This is the default name used to read and write settings.
     *
     * @return The local class name.
     */
    @NonNull
    @Override
    public String getLocalClassName() {
        return super.getLocalClassName();
    }

    @Override
    public Looper getMainLooper() {
        return super.getMainLooper();
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public File getNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }

    @Override
    public File getObbDir() {
        return super.getObbDir();
    }

    @Override
    public File[] getObbDirs() {
        return super.getObbDirs();
    }

    @Override
    public String getPackageCodePath() {
        return super.getPackageCodePath();
    }

    @Override
    public PackageManager getPackageManager() {
        return super.getPackageManager();
    }

    @Override
    public String getPackageName() {
        return super.getPackageName();
    }

    @Override
    public String getPackageResourcePath() {
        return super.getPackageResourcePath();
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity specified by
     * this activity's logical parent. The logical parent is named in the application's manifest
     * by the {@link android.R.attr#parentActivityName parentActivityName} attribute.
     * Activity subclasses may override this method to modify the Intent returned by
     * super.getParentActivityIntent() or to implement a different mechanism of retrieving
     * the parent intent entirely.
     *
     * @return a new Intent targeting the defined parent of this activity or null if
     * there is no valid parent.
     */
    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    /**
     * Retrieve a {@link SharedPreferences} object for accessing preferences
     * that are private to this activity.  This simply calls the underlying
     * {@link #getSharedPreferences(String, int)} method by passing in this activity's
     * class name as the preferences name.
     *
     * @param mode Operating mode.  Use {@link #MODE_PRIVATE} for the default
     *             operation.
     * @return Returns the single SharedPreferences instance that can be used
     * to retrieve and modify the preference values.
     */
    @Override
    public SharedPreferences getPreferences(final int mode) {
        return super.getPreferences(mode);
    }

    /**
     * Return information about who launched this activity.  If the launching Intent
     * contains an {@link Intent#EXTRA_REFERRER Intent.EXTRA_REFERRER},
     * that will be returned as-is; otherwise, if known, an
     * {@link Intent#URI_ANDROID_APP_SCHEME android-app:} referrer URI containing the
     * package name that started the Intent will be returned.  This may return null if no
     * referrer can be identified -- it is neither explicitly specified, nor is it known which
     * application package was involved.
     *
     * <p>If called while inside the handling of {@link #onNewIntent}, this function will
     * return the referrer that submitted that new intent to the activity.  Otherwise, it
     * always returns the referrer of the original Intent.</p>
     *
     * <p>Note that this is <em>not</em> a security feature -- you can not trust the
     * referrer information, applications can spoof it.</p>
     */
    @Nullable
    @Override
    public Uri getReferrer() {
        return super.getReferrer();
    }

    /**
     * Return the current requested orientation of the activity.  This will
     * either be the orientation requested in its component's manifest, or
     * the last requested orientation given to
     * {@link #setRequestedOrientation(int)}.
     *
     * @return Returns an orientation constant as used in
     * {@link ActivityInfo#screenOrientation ActivityInfo.screenOrientation}.
     */
    @Override
    public int getRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    public SharedPreferences getSharedPreferences(final String name, final int mode) {
        return super.getSharedPreferences(name, mode);
    }

    /**
     * Support library version of {@link Activity#getActionBar}.
     *
     * <p>Retrieve a reference to this activity's ActionBar.
     *
     * @return The Activity's ActionBar, or null if it does not have one.
     */
    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    /**
     * Return the FragmentManager for interacting with fragments associated
     * with this activity.
     */
    @Override
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override
    public LoaderManager getSupportLoaderManager() {
        return super.getSupportLoaderManager();
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity
     * specified by sourceActivity's {@link NavUtils#PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest. If the device is running
     * Jellybean or newer, the android:parentActivityName attribute will be preferred
     * if it is present.
     *
     * @return a new Intent targeting the defined parent activity of sourceActivity
     */
    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        return super.getSupportParentActivityIntent();
    }

    @Override
    public Object getSystemService(final String name) {
        return super.getSystemService(name);
    }

    @Override
    public String getSystemServiceName(final Class<?> serviceClass) {
        return super.getSystemServiceName(serviceClass);
    }

    /**
     * Return the identifier of the task this activity is in.  This identifier
     * will remain the same for the lifetime of the activity.
     *
     * @return Task identifier, an opaque integer.
     */
    @Override
    public int getTaskId() {
        return super.getTaskId();
    }

    @Override
    public Resources.Theme getTheme() {
        return super.getTheme();
    }

    /**
     * Retrieve the active {@link VoiceInteractor} that the user is going through to
     * interact with this activity.
     */
    @Override
    public VoiceInteractor getVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    @Override
    public Drawable getWallpaper() {
        return super.getWallpaper();
    }

    @Override
    public int getWallpaperDesiredMinimumHeight() {
        return super.getWallpaperDesiredMinimumHeight();
    }

    @Override
    public int getWallpaperDesiredMinimumWidth() {
        return super.getWallpaperDesiredMinimumWidth();
    }

    /**
     * Retrieve the current {@link Window} for the activity.
     * This can be used to directly access parts of the Window API that
     * are not available through Activity/Screen.
     *
     * @return Window The current window, or null if the activity is not
     * visual.
     */
    @Override
    public Window getWindow() {
        return super.getWindow();
    }

    /**
     * Retrieve the window manager for showing custom windows.
     */
    @Override
    public WindowManager getWindowManager() {
        return super.getWindowManager();
    }

    @Override
    public void grantUriPermission(final String toPackage, final Uri uri, final int modeFlags) {
        super.grantUriPermission(toPackage, uri, modeFlags);
    }

    /**
     * Returns true if this activity's <em>main</em> window currently has window focus.
     * Note that this is not the same as the view itself having focus.
     *
     * @return True if this activity's main window currently has window focus.
     * @see #onWindowAttributesChanged(WindowManager.LayoutParams)
     */
    @Override
    public boolean hasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    /**
     * Check to see whether this activity is in the process of being destroyed in order to be
     * recreated with a new configuration. This is often used in
     * {@link #onStop} to determine whether the state needs to be cleaned up or will be passed
     * on to the next instance of the activity via {@link #onRetainNonConfigurationInstance()}.
     *
     * @return If the activity is being torn down in order to be recreated with a new configuration,
     * returns true; else returns false.
     */
    @Override
    public boolean isChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    /**
     * Returns true if the final {@link #onDestroy()} call has been made
     * on the Activity, so this instance is now dead.
     */
    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        return super.isDeviceProtectedStorage();
    }

    /**
     * Check to see whether this activity is in the process of finishing,
     * either because you called {@link #finish} on it or someone else
     * has requested that it finished.  This is often used in
     * {@link #onPause} to determine whether the activity is simply pausing or
     * completely finishing.
     *
     * @return If the activity is finishing, returns true; else returns false.
     * @see #finish
     */
    @Override
    public boolean isFinishing() {
        return super.isFinishing();
    }

    /**
     * Bit indicating that this activity is "immersive" and should not be
     * interrupted by notifications if possible.
     *
     * This value is initially set by the manifest property
     * <code>android:immersive</code> but may be changed at runtime by
     * {@link #setImmersive}.
     *
     * @see #setImmersive(boolean)
     * @see ActivityInfo#FLAG_IMMERSIVE
     */
    @Override
    public boolean isImmersive() {
        return super.isImmersive();
    }

    /**
     * Returns true if the activity is currently in multi-window mode.
     *
     * @return True if the activity is in multi-window mode.
     * @see android.R.attr#resizeableActivity
     */
    @Override
    public boolean isInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    /**
     * Returns true if the activity is currently in picture-in-picture mode.
     *
     * @return True if the activity is in picture-in-picture mode.
     * @see android.R.attr#supportsPictureInPicture
     */
    @Override
    public boolean isInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    /**
     * Queries whether the currently enabled voice interaction service supports returning
     * a voice interactor for use by the activity. This is valid only for the duration of the
     * activity.
     *
     * @return whether the current voice interaction service supports local voice interaction
     */
    @Override
    public boolean isLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    @Override
    public boolean isRestricted() {
        return super.isRestricted();
    }

    /**
     * Return whether this activity is the root of a task.  The root is the
     * first activity in a task.
     *
     * @return True if this is the root activity, else false.
     */
    @Override
    public boolean isTaskRoot() {
        return super.isTaskRoot();
    }

    /**
     * Check whether this activity is running as part of a voice interaction with the user.
     * If true, it should perform its interaction with the user through the
     * {@link VoiceInteractor} returned by {@link #getVoiceInteractor}.
     */
    @Override
    public boolean isVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    /**
     * Like {@link #isVoiceInteraction}, but only returns true if this is also the root
     * of a voice interaction.  That is, returns true if this activity was directly
     * started by the voice interaction service as the initiation of a voice interaction.
     * Otherwise, for example if it was started by another activity while under voice
     * interaction, returns false.
     */
    @Override
    public boolean isVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    @Override
    public boolean moveDatabaseFrom(final Context sourceContext, final String name) {
        return super.moveDatabaseFrom(sourceContext, name);
    }

    @Override
    public boolean moveSharedPreferencesFrom(final Context sourceContext, final String name) {
        return super.moveSharedPreferencesFrom(sourceContext, name);
    }

    /**
     * Move the task containing this activity to the back of the activity
     * stack.  The activity's order within the task is unchanged.
     *
     * @param nonRoot If false then this only works if the activity is the root
     *                of a task; if true it will work for any activity in
     *                a task.
     * @return If the task was moved (or it was already at the
     * back) true is returned, else false.
     */
    @Override
    public boolean moveTaskToBack(final boolean nonRoot) {
        return super.moveTaskToBack(nonRoot);
    }

    /**
     * Navigate from this activity to the activity specified by upIntent, finishing this activity
     * in the process. If the activity indicated by upIntent already exists in the task's history,
     * this activity and all others before the indicated activity in the history stack will be
     * finished.
     *
     * <p>If the indicated activity does not appear in the history stack, this will finish
     * each activity in this task until the root activity of the task is reached, resulting in
     * an "in-app home" behavior. This can be useful in apps with a complex navigation hierarchy
     * when an activity may be reached by a path not passing through a canonical parent
     * activity.</p>
     *
     * <p>This method should be used when performing up navigation from within the same task
     * as the destination. If up navigation should cross tasks in some cases, see
     * {@link #shouldUpRecreateTask(Intent)}.</p>
     *
     * @param upIntent An intent representing the target destination for up navigation
     * @return true if up navigation successfully reached the activity indicated by upIntent and
     * upIntent was delivered to it. false if an instance of the indicated activity could
     * not be found and this activity was simply finished normally.
     */
    @Override
    public boolean navigateUpTo(final Intent upIntent) {
        return super.navigateUpTo(upIntent);
    }

    /**
     * This is called when a child activity of this one calls its
     * {@link #navigateUpTo} method.  The default implementation simply calls
     * navigateUpTo(upIntent) on this activity (the parent).
     *
     * @param child    The activity making the call.
     * @param upIntent An intent representing the target destination for up navigation
     * @return true if up navigation successfully reached the activity indicated by upIntent and
     * upIntent was delivered to it. false if an instance of the indicated activity could
     * not be found and this activity was simply finished normally.
     */
    @Override
    public boolean navigateUpToFromChild(final Activity child, final Intent upIntent) {
        return super.navigateUpToFromChild(child, upIntent);
    }

    /**
     * Notifies the activity that an action mode has finished.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The action mode that just finished.
     */
    @Override
    public void onActionModeFinished(final android.view.ActionMode mode) {
        super.onActionModeFinished(mode);
    }

    /**
     * Notifies the Activity that an action mode has been started.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The new action mode.
     */
    @Override
    public void onActionModeStarted(final android.view.ActionMode mode) {
        super.onActionModeStarted(mode);
    }

    /**
     * Called when an activity you launched with an activity transition exposes this
     * Activity through a returning activity transition, giving you the resultCode
     * and any additional data from it. This method will only be called if the activity
     * set a result code other than {@link #RESULT_CANCELED} and it supports activity
     * transitions with {@link Window#FEATURE_ACTIVITY_TRANSITIONS}.
     *
     * <p>The purpose of this function is to let the called Activity send a hint about
     * its state so that this underlying Activity can prepare to be exposed. A call to
     * this method does not guarantee that the called Activity has or will be exiting soon.
     * It only indicates that it will expose this Activity's Window and it has
     * some data to pass to prepare it.</p>
     *
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data       An Intent, which can return result data to the caller
     */
    @Override
    public void onActivityReenter(final int resultCode, final Intent data) {
        super.onActivityReenter(resultCode, data);
    }

    /**
     * Called when a fragment is attached to the activity.
     *
     * <p>This is called after the attached fragment's <code>onAttach</code> and before
     * the attached fragment's <code>onCreate</code> if the fragment has not yet had a previous
     * call to <code>onCreate</code>.</p>
     */
    @Override
    public void onAttachFragment(final Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    /**
     * Called when a Fragment is being attached to this activity, immediately
     * after the call to its {@link android.app.Fragment#onAttach Fragment.onAttach()}
     * method and before {@link android.app.Fragment#onCreate Fragment.onCreate()}.
     */
    @Override
    public void onAttachFragment(final android.app.Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    /**
     * Called when the main window associated with the activity has been
     * attached to the window manager.
     * See {@link View#onAttachedToWindow() View.onAttachedToWindow()}
     * for more information.
     *
     * @see View#onAttachedToWindow
     */
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    /**
     * This hook is called whenever an item in a context menu is selected. The
     * default implementation simply returns false to have the normal processing
     * happen (calling the item's Runnable or sending a message to its Handler
     * as appropriate). You can use this method for any items for which you
     * would like to do processing without those other facilities.
     * <p>
     * Use {@link MenuItem#getMenuInfo()} to get extra information set by the
     * View that added this menu item.
     * <p>
     * Derived classes should call through to the base class for it to perform
     * the default menu handling.
     *
     * @param item The context menu item that was selected.
     * @return boolean Return false to allow normal context menu processing to
     * proceed, true to consume it here.
     */
    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        return super.onContextItemSelected(item);
    }

    /**
     * This hook is called whenever the context menu is being closed (either by
     * the user canceling the menu with the back/menu button, or when an item is
     * selected).
     *
     * @param menu The context menu that is being closed.
     */
    @Override
    public void onContextMenuClosed(final Menu menu) {
        super.onContextMenuClosed(menu);
    }

    /**
     * Same as {@link #onCreate(Bundle)} but called for those activities created with
     * the attribute {@link android.R.attr#persistableMode} set to
     * <code>persistAcrossReboots</code>.
     *
     * @param savedInstanceState if the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it
     *                           most
     *                           recently supplied in {@link #onSaveInstanceState}.
     *                           <b><i>Note: Otherwise it is null.</i></b>
     * @param persistentState    if the activity is being re-initialized after
     *                           previously being shut down or powered off then this Bundle
     *                           contains
     *                           the data it most
     *                           recently supplied to outPersistentState in {@link
     *                           #onSaveInstanceState}.
     *                           <b><i>Note: Otherwise it is null.</i></b>
     * @see #onCreate(Bundle)
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    public void onCreate(final Bundle savedInstanceState, final PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * Called when a context menu for the {@code view} is about to be shown.
     * Unlike {@link #onCreateOptionsMenu(Menu)}, this will be called every
     * time the context menu is about to be shown and should be populated for
     * the view (or item inside the view for {@link AdapterView} subclasses,
     * this can be found in the {@code menuInfo})).
     * <p>
     * Use {@link #onContextItemSelected(MenuItem)} to know when an
     * item has been selected.
     * <p>
     * It is not safe to hold onto the context menu after this method returns.
     */
    @Override
    public void onCreateContextMenu(final ContextMenu menu, final View v,
            final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    /**
     * Generate a new description for this activity.  This method is called
     * before pausing the activity and can, if desired, return some textual
     * description of its current state to be displayed to the user.
     *
     * <p>The default implementation returns null, which will cause you to
     * inherit the description from the previous activity.  If all activities
     * return null, generally the label of the top activity will be used as the
     * description.
     *
     * @return A description of what the user is doing.  It should be short and
     * sweet (only a few words).
     * @see #onCreateThumbnail
     * @see #onSaveInstanceState
     * @see #onPause
     */
    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        return super.onCreateDescription();
    }

    /**
     * Define the synthetic task stack that will be generated during Up navigation from
     * a different task.
     *
     * <p>The default implementation of this method adds the parent chain of this activity
     * as specified in the manifest to the supplied {@link TaskStackBuilder}. Applications
     * may choose to override this method to construct the desired task stack in a different
     * way.</p>
     *
     * <p>This method will be invoked by the default implementation of {@link #onNavigateUp()}
     * if {@link #shouldUpRecreateTask(Intent)} returns true when supplied with the intent
     * returned by {@link #getParentActivityIntent()}.</p>
     *
     * <p>Applications that wish to supply extra Intent parameters to the parent stack defined
     * by the manifest should override {@link #onPrepareNavigateUpTaskStack(TaskStackBuilder)}.</p>
     *
     * @param builder An empty TaskStackBuilder - the application should add intents representing
     *                the desired task stack
     */
    @Override
    public void onCreateNavigateUpTaskStack(final TaskStackBuilder builder) {
        super.onCreateNavigateUpTaskStack(builder);
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     *
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     *
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     *
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     *
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Dispatch to Fragment.onCreateOptionsMenu().
     */
    @Override
    public boolean onCreatePanelMenu(final int featureId, final Menu menu) {
        return super.onCreatePanelMenu(featureId, menu);
    }

    /**
     * Default implementation of
     * {@link Window.Callback#onCreatePanelView}
     * for activities. This
     * simply returns null so that all panel sub-windows will have the default
     * menu behavior.
     */
    @Nullable
    @Override
    public View onCreatePanelView(final int featureId) {
        return super.onCreatePanelView(featureId);
    }

    /**
     * Support version of {@link #onCreateNavigateUpTaskStack(TaskStackBuilder)}.
     * This method will be called on all platform versions.
     *
     * Define the synthetic task stack that will be generated during Up navigation from
     * a different task.
     *
     * <p>The default implementation of this method adds the parent chain of this activity
     * as specified in the manifest to the supplied {@link android.support.v4.app.TaskStackBuilder}.
     * Applications
     * may choose to override this method to construct the desired task stack in a different
     * way.</p>
     *
     * <p>This method will be invoked by the default implementation of {@link #onNavigateUp()}
     * if {@link #shouldUpRecreateTask(Intent)} returns true when supplied with the intent
     * returned by {@link #getParentActivityIntent()}.</p>
     *
     * <p>Applications that wish to supply extra Intent parameters to the parent stack defined
     * by the manifest should override
     * {@link #onPrepareSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder)}.</p>
     *
     * @param builder An empty TaskStackBuilder - the application should add intents representing
     *                the desired task stack
     */
    @Override
    public void onCreateSupportNavigateUpTaskStack(
            @NonNull final android.support.v4.app.TaskStackBuilder builder) {
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    /**
     * Generate a new thumbnail for this activity.  This method is called before
     * pausing the activity, and should draw into <var>outBitmap</var> the
     * imagery for the desired thumbnail in the dimensions of that bitmap.  It
     * can use the given <var>canvas</var>, which is configured to draw into the
     * bitmap, for rendering if desired.
     *
     * <p>The default implementation returns fails and does not draw a thumbnail;
     * this will result in the platform creating its own thumbnail if needed.
     *
     * @param outBitmap The bitmap to contain the thumbnail.
     * @param canvas    Can be used to render into the bitmap.
     * @return Return true if you have drawn into the bitmap; otherwise after
     * you return it will be filled with a default thumbnail.
     * @see #onCreateDescription
     * @see #onSaveInstanceState
     * @see #onPause
     */
    @Override
    public boolean onCreateThumbnail(final Bitmap outBitmap, final Canvas canvas) {
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Override
    public View onCreateView(final View parent, final String name, final Context context,
            final AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public View onCreateView(final String name, final Context context, final AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    /**
     * Called when the main window associated with the activity has been
     * detached from the window manager.
     * See {@link View#onDetachedFromWindow() View.onDetachedFromWindow()}
     * for more information.
     *
     * @see View#onDetachedFromWindow
     */
    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /**
     * Activities cannot draw during the period that their windows are animating in. In order
     * to know when it is safe to begin drawing they can override this method which will be
     * called when the entering animation has completed.
     */
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    /**
     * Called when a generic motion event was not handled by any of the
     * views inside of the activity.
     * <p>
     * Generic motion events describe joystick movements, mouse hovers, track pad
     * touches, scroll wheel movements and other input events.  The
     * {@link MotionEvent#getSource() source} of the motion event specifies
     * the class of input that was received.  Implementations of this method
     * must examine the bits in the source before processing the event.
     * The following code example shows how this is done.
     * </p><p>
     * Generic motion events with source class
     * {@link InputDevice#SOURCE_CLASS_POINTER}
     * are delivered to the view under the pointer.  All other generic motion events are
     * delivered to the focused view.
     * </p><p>
     * See {@link View#onGenericMotionEvent(MotionEvent)} for an example of how to
     * handle this event.
     * </p>
     *
     * @param event The generic motion event being processed.
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @Override
    public boolean onGenericMotionEvent(final MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }

    /**
     * Called when a key was pressed down and not handled by any of the views
     * inside of the activity. So, for example, key presses while the cursor
     * is inside a TextView will not trigger the event (unless it is a navigation
     * to another object) because TextView handles its own key presses.
     *
     * <p>If the focused view didn't want this event, this method is called.
     *
     * <p>The default implementation takes care of {@link KeyEvent#KEYCODE_BACK}
     * by calling {@link #onBackPressed()}, though the behavior varies based
     * on the application compatibility mode: for
     * {@link Build.VERSION_CODES#ECLAIR} or later applications,
     * it will set up the dispatch to call {@link #onKeyUp} where the action
     * will be performed; for earlier applications, it will perform the
     * action immediately in on-down, as those versions of the platform
     * behaved.
     *
     * <p>Other additional default key handling may be performed
     * if configured with {@link #setDefaultKeyMode}.
     *
     * @return Return <code>true</code> to prevent this event from being propagated
     * further, or <code>false</code> to indicate that you have not handled
     * this event and it should continue to be propagated.
     * @see #onKeyUp
     * @see KeyEvent
     */
    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
     * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle
     * the event).
     */
    @Override
    public boolean onKeyLongPress(final int keyCode, final KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)
     * KeyEvent.Callback.onKeyMultiple()}: always returns false (doesn't handle
     * the event).
     */
    @Override
    public boolean onKeyMultiple(final int keyCode, final int repeatCount, final KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    /**
     * Called when a key shortcut event is not handled by any of the views in the Activity.
     * Override this method to implement global key shortcuts for the Activity.
     * Key shortcuts can also be implemented by setting the
     * {@link MenuItem#setShortcut(char, char) shortcut} property of menu items.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event   Description of the key event.
     * @return True if the key shortcut was handled.
     */
    @Override
    public boolean onKeyShortcut(final int keyCode, final KeyEvent event) {
        return super.onKeyShortcut(keyCode, event);
    }

    /**
     * Called when a key was released and not handled by any of the views
     * inside of the activity. So, for example, key presses while the cursor
     * is inside a TextView will not trigger the event (unless it is a navigation
     * to another object) because TextView handles its own key presses.
     *
     * <p>The default implementation handles KEYCODE_BACK to stop the activity
     * and go back.
     *
     * @return Return <code>true</code> to prevent this event from being propagated
     * further, or <code>false</code> to indicate that you have not handled
     * this event and it should continue to be propagated.
     * @see #onKeyDown
     * @see KeyEvent
     */
    @Override
    public boolean onKeyUp(final int keyCode, final KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    /**
     * Callback to indicate that {@link #startLocalVoiceInteraction(Bundle)} has resulted in a
     * voice interaction session being started. You can now retrieve a voice interactor using
     * {@link #getVoiceInteractor()}.
     */
    @Override
    public void onLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    /**
     * Callback to indicate that the local voice interaction has stopped either
     * because it was requested through a call to {@link #stopLocalVoiceInteraction()}
     * or because it was canceled by the user. The previously acquired {@link VoiceInteractor}
     * is no longer valid after this.
     */
    @Override
    public void onLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    /**
     * Dispatch onLowMemory() to all fragments.
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * {@inheritDoc}
     *
     * <p>Please note: AppCompat uses it's own feature id for the action bar:
     * {@link AppCompatDelegate#FEATURE_SUPPORT_ACTION_BAR FEATURE_SUPPORT_ACTION_BAR}.</p>
     */
    @Override
    public boolean onMenuOpened(final int featureId, final Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    /**
     * {@inheritDoc}
     *
     * <p><strong>Note:</strong> If you override this method you must call
     * <code>super.onMultiWindowModeChanged</code> to correctly dispatch the event
     * to support fragments attached to this activity.</p>
     *
     * @param isInMultiWindowMode True if the activity is in multi-window mode.
     */
    @Override
    public void onMultiWindowModeChanged(final boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    /**
     * This method is called whenever the user chooses to navigate Up within your application's
     * activity hierarchy from the action bar.
     *
     * <p>If the attribute {@link android.R.attr#parentActivityName parentActivityName}
     * was specified in the manifest for this activity or an activity-alias to it,
     * default Up navigation will be handled automatically. If any activity
     * along the parent chain requires extra Intent arguments, the Activity subclass
     * should override the method {@link #onPrepareNavigateUpTaskStack(TaskStackBuilder)}
     * to supply those arguments.</p>
     *
     * <p>See <a href="{@docRoot}guide/components/tasks-and-back-stack.html">Tasks and Back
     * Stack</a>
     * from the developer guide and <a href="{@docRoot}design/patterns/navigation.html">Navigation</a>
     * from the design guide for more information about navigating within your app.</p>
     *
     * <p>See the {@link TaskStackBuilder} class and the Activity methods
     * {@link #getParentActivityIntent()}, {@link #shouldUpRecreateTask(Intent)}, and
     * {@link #navigateUpTo(Intent)} for help implementing custom Up navigation.
     * The AppNavigation sample application in the Android SDK is also available for reference.</p>
     *
     * @return true if Up navigation completed successfully and this Activity was finished,
     * false otherwise.
     */
    @Override
    public boolean onNavigateUp() {
        return super.onNavigateUp();
    }

    /**
     * This is called when a child activity of this one attempts to navigate up.
     * The default implementation simply calls onNavigateUp() on this activity (the parent).
     *
     * @param child The activity making the call.
     */
    @Override
    public boolean onNavigateUpFromChild(final Activity child) {
        return super.onNavigateUpFromChild(child);
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * This hook is called whenever the options menu is being closed (either by the user canceling
     * the menu with the back/menu button, or when an item is selected).
     *
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     */
    @Override
    public void onOptionsMenuClosed(final Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Please note: AppCompat uses it's own feature id for the action bar:
     * {@link AppCompatDelegate#FEATURE_SUPPORT_ACTION_BAR FEATURE_SUPPORT_ACTION_BAR}.</p>
     */
    @Override
    public void onPanelClosed(final int featureId, final Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    /**
     * {@inheritDoc}
     *
     * <p><strong>Note:</strong> If you override this method you must call
     * <code>super.onPictureInPictureModeChanged</code> to correctly dispatch the event
     * to support fragments attached to this activity.</p>
     *
     * @param isInPictureInPictureMode True if the activity is in picture-in-picture mode.
     */
    @Override
    public void onPictureInPictureModeChanged(final boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    /**
     * This is the same as {@link #onPostCreate(Bundle)} but is called for activities
     * created with the attribute {@link android.R.attr#persistableMode} set to
     * <code>persistAcrossReboots</code>.
     *
     * @param savedInstanceState The data most recently supplied in {@link #onSaveInstanceState}
     * @param persistentState    The data caming from the PersistableBundle first
     *                           saved in {@link #onSaveInstanceState(Bundle, PersistableBundle)}.
     * @see #onCreate
     */
    @Override
    public void onPostCreate(final Bundle savedInstanceState,
            final PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    /**
     * Prepare the synthetic task stack that will be generated during Up navigation
     * from a different task.
     *
     * <p>This method receives the {@link TaskStackBuilder} with the constructed series of
     * Intents as generated by {@link #onCreateNavigateUpTaskStack(TaskStackBuilder)}.
     * If any extra data should be added to these intents before launching the new task,
     * the application should override this method and add that data here.</p>
     *
     * @param builder A TaskStackBuilder that has been populated with Intents by
     *                onCreateNavigateUpTaskStack.
     */
    @Override
    public void onPrepareNavigateUpTaskStack(final TaskStackBuilder builder) {
        super.onPrepareNavigateUpTaskStack(builder);
    }

    /**
     * Prepare the Screen's standard options menu to be displayed.  This is
     * called right before the menu is shown, every time it is shown.  You can
     * use this method to efficiently enable/disable items or otherwise
     * dynamically modify the contents.
     *
     * <p>The default implementation updates the system menu items based on the
     * activity's state.  Deriving classes should always call through to the
     * base class implementation.
     *
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Dispatch onPrepareOptionsMenu() to fragments.
     */
    @Override
    public boolean onPreparePanel(final int featureId, final View view, final Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    /**
     * Support version of {@link #onPrepareNavigateUpTaskStack(TaskStackBuilder)}.
     * This method will be called on all platform versions.
     *
     * Prepare the synthetic task stack that will be generated during Up navigation
     * from a different task.
     *
     * <p>This method receives the {@link android.support.v4.app.TaskStackBuilder} with the
     * constructed series of
     * Intents as generated by {@link #onCreateSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder)}.
     * If any extra data should be added to these intents before launching the new task,
     * the application should override this method and add that data here.</p>
     *
     * @param builder A TaskStackBuilder that has been populated with Intents by
     *                onCreateNavigateUpTaskStack.
     */
    @Override
    public void onPrepareSupportNavigateUpTaskStack(
            @NonNull final android.support.v4.app.TaskStackBuilder builder) {
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    /**
     * This is called when the user is requesting an assist, to provide references
     * to content related to the current activity.  Before being called, the
     * {@code outContent} Intent is filled with the base Intent of the activity (the Intent
     * returned by {@link #getIntent()}).  The Intent's extras are stripped of any types
     * that are not valid for {@link PersistableBundle} or non-framework Parcelables, and
     * the flags {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION} and
     * {@link Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION} are cleared from the Intent.
     *
     * <p>Custom implementation may adjust the content intent to better reflect the top-level
     * context of the activity, and fill in its ClipData with additional content of
     * interest that the user is currently viewing.  For example, an image gallery application
     * that has launched in to an activity allowing the user to swipe through pictures should
     * modify the intent to reference the current image they are looking it; such an
     * application when showing a list of pictures should add a ClipData that has
     * references to all of the pictures currently visible on screen.</p>
     *
     * @param outContent The assist content to return.
     */
    @Override
    public void onProvideAssistContent(final AssistContent outContent) {
        super.onProvideAssistContent(outContent);
    }

    /**
     * This is called when the user is requesting an assist, to build a full
     * {@link Intent#ACTION_ASSIST} Intent with all of the context of the current
     * application.  You can override this method to place into the bundle anything
     * you would like to appear in the {@link Intent#EXTRA_ASSIST_CONTEXT} part
     * of the assist Intent.
     *
     * <p>This function will be called after any global assist callbacks that had
     * been registered with {@link Application#registerOnProvideAssistDataListener
     * Application.registerOnProvideAssistDataListener}.
     */
    @Override
    public void onProvideAssistData(final Bundle data) {
        super.onProvideAssistData(data);
    }

    @Override
    public void onProvideKeyboardShortcuts(final List<KeyboardShortcutGroup> data, final Menu menu,
            final int deviceId) {
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    /**
     * Override to generate the desired referrer for the content currently being shown
     * by the app.  The default implementation returns null, meaning the referrer will simply
     * be the android-app: of the package name of this activity.  Return a non-null Uri to
     * have that supplied as the {@link Intent#EXTRA_REFERRER} of any activities started from it.
     */
    @Override
    public Uri onProvideReferrer() {
        return super.onProvideReferrer();
    }

    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on {@link #requestPermissions(String[], int)}.
     * <p>
     * <strong>Note:</strong> It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     * </p>
     *
     * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link PackageManager#PERMISSION_GRANTED}
     *                     or {@link PackageManager#PERMISSION_DENIED}. Never null.
     * @see #requestPermissions(String[], int)
     */
    @Override
    public void onRequestPermissionsResult(final int requestCode,
            @NonNull final String[] permissions,
            @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * This is the same as {@link #onRestoreInstanceState(Bundle)} but is called for activities
     * created with the attribute {@link android.R.attr#persistableMode} set to
     * <code>persistAcrossReboots</code>. The {@link PersistableBundle} passed
     * came from the restored PersistableBundle first
     * saved in {@link #onSaveInstanceState(Bundle, PersistableBundle)}.
     *
     * <p>This method is called between {@link #onStart} and
     * {@link #onPostCreate}.
     *
     * <p>If this method is called {@link #onRestoreInstanceState(Bundle)} will not be called.
     *
     * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}.
     * @param persistentState    the data most recently supplied in {@link #onSaveInstanceState}.
     * @see #onRestoreInstanceState(Bundle)
     * @see #onCreate
     * @see #onPostCreate
     * @see #onResume
     * @see #onSaveInstanceState
     */
    @Override
    public void onRestoreInstanceState(final Bundle savedInstanceState,
            final PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    /**
     * Use this instead of {@link #onRetainNonConfigurationInstance()}.
     * Retrieve later with {@link #getLastCustomNonConfigurationInstance()}.
     */
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }

    /**
     * This is the same as {@link #onSaveInstanceState} but is called for activities
     * created with the attribute {@link android.R.attr#persistableMode} set to
     * <code>persistAcrossReboots</code>. The {@link PersistableBundle} passed
     * in will be saved and presented in {@link #onCreate(Bundle, PersistableBundle)}
     * the first time that this activity is restarted following the next device reboot.
     *
     * @param outState           Bundle in which to place your saved state.
     * @param outPersistentState State which will be saved across reboots.
     * @see #onSaveInstanceState(Bundle)
     * @see #onCreate
     * @see #onRestoreInstanceState(Bundle, PersistableBundle)
     * @see #onPause
     */
    @Override
    public void onSaveInstanceState(final Bundle outState,
            final PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    /**
     * This hook is called when the user signals the desire to start a search.
     *
     * <p>You can use this function as a simple way to launch the search UI, in response to a
     * menu item, search button, or other widgets within your activity. Unless overidden,
     * calling this function is the same as calling
     * {@link #startSearch startSearch(null, false, null, false)}, which launches
     * search for the current activity as specified in its manifest, see {@link SearchManager}.
     *
     * <p>You can override this function to force global search, e.g. in response to a dedicated
     * search key, or to block search entirely (by simply returning false).
     *
     * <p>Note: when running in a {@link Configuration#UI_MODE_TYPE_TELEVISION}, the default
     * implementation changes to simply return false and you must supply your own custom
     * implementation if you want to support search.</p>
     *
     * @param searchEvent The {@link SearchEvent} that signaled this search.
     * @return Returns {@code true} if search launched, and {@code false} if the activity does
     * not respond to search.  The default implementation always returns {@code true}, except
     * when in {@link Configuration#UI_MODE_TYPE_TELEVISION} mode where it returns false.
     * @see SearchManager
     */
    @Override
    public boolean onSearchRequested(final SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    /**
     * @see #onSearchRequested(SearchEvent)
     */
    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    /**
     * Hook in to note that fragment state is no longer saved.
     */
    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
    }

    /**
     * Notifies the activity that a support action mode has finished.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The action mode that just finished.
     */
    @Override
    public void onSupportActionModeFinished(@NonNull final ActionMode mode) {
        super.onSupportActionModeFinished(mode);
    }

    /**
     * Notifies the Activity that a support action mode has been started.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The new action mode.
     */
    @Override
    public void onSupportActionModeStarted(@NonNull final ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }

    /**
     * @deprecated Use {@link #onContentChanged()} instead.
     */
    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();
    }

    /**
     * This method is called whenever the user chooses to navigate Up within your application's
     * activity hierarchy from the action bar.
     *
     * <p>If a parent was specified in the manifest for this activity or an activity-alias to it,
     * default Up navigation will be handled automatically. See
     * {@link #getSupportParentActivityIntent()} for how to specify the parent. If any activity
     * along the parent chain requires extra Intent arguments, the Activity subclass
     * should override the method {@link #onPrepareSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder)}
     * to supply those arguments.</p>
     *
     * <p>See <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and
     * Back Stack</a> from the developer guide and
     * <a href="{@docRoot}design/patterns/navigation.html">Navigation</a> from the design guide
     * for more information about navigating within your app.</p>
     *
     * <p>See the {@link android.support.v4.app.TaskStackBuilder} class and the Activity methods
     * {@link #getSupportParentActivityIntent()}, {@link #supportShouldUpRecreateTask(Intent)}, and
     * {@link #supportNavigateUpTo(Intent)} for help implementing custom Up navigation.</p>
     *
     * @return true if Up navigation completed successfully and this Activity was finished,
     * false otherwise.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    /**
     * Called when a touch screen event was not handled by any of the views
     * under it.  This is most useful to process touch events that happen
     * outside of your window bounds, where there is no view to receive it.
     *
     * @param event The touch screen event being processed.
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /**
     * Called when the trackball was moved and not handled by any of the
     * views inside of the activity.  So, for example, if the trackball moves
     * while focus is on a button, you will receive a call here because
     * buttons do not normally do anything with trackball events.  The call
     * here happens <em>before</em> trackball movements are converted to
     * DPAD key events, which then get sent back to the view hierarchy, and
     * will be processed at the point for things like focus navigation.
     *
     * @param event The trackball event being processed.
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @Override
    public boolean onTrackballEvent(final MotionEvent event) {
        return super.onTrackballEvent(event);
    }

    @Override
    public void onTrimMemory(final int level) {
        super.onTrimMemory(level);
    }

    /**
     * Called whenever a key, touch, or trackball event is dispatched to the
     * activity.  Implement this method if you wish to know that the user has
     * interacted with the device in some way while your activity is running.
     * This callback and {@link #onUserLeaveHint} are intended to help
     * activities manage status bar notifications intelligently; specifically,
     * for helping activities determine the proper time to cancel a notfication.
     *
     * <p>All calls to your activity's {@link #onUserLeaveHint} callback will
     * be accompanied by calls to {@link #onUserInteraction}.  This
     * ensures that your activity will be told of relevant user activity such
     * as pulling down the notification pane and touching an item there.
     *
     * <p>Note that this callback will be invoked for the touch down action
     * that begins a touch gesture, but may not be invoked for the touch-moved
     * and touch-up actions that follow.
     *
     * @see #onUserLeaveHint()
     */
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
    }

    /**
     * Called when a translucent activity over this activity is becoming opaque or another
     * activity is being launched. Activities that override this method must call
     * <code>super.onVisibleBehindCanceled()</code> or a SuperNotCalledException will be thrown.
     *
     * <p>When this method is called the activity has 500 msec to release any resources it may be
     * using while visible in the background.
     * If the activity has not returned from this method in 500 msec the system will destroy
     * the activity and kill the process in order to recover the resources for another
     * process. Otherwise {@link #onStop()} will be called following return.
     *
     * @see #requestVisibleBehind(boolean)
     */
    @Override
    public void onVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    @Override
    public void onWindowAttributesChanged(final WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
    }

    /**
     * Called when the current {@link Window} of the activity gains or loses
     * focus.  This is the best indicator of whether this activity is visible
     * to the user.  The default implementation clears the key tracking
     * state, so should always be called.
     *
     * <p>Note that this provides information about global focus state, which
     * is managed independently of activity lifecycles.  As such, while focus
     * changes will generally have some relation to lifecycle changes (an
     * activity that is stopped will not generally get window focus), you
     * should not rely on any particular order between the callbacks here and
     * those in the other lifecycle methods such as {@link #onResume}.
     *
     * <p>As a general rule, however, a resumed activity will have window
     * focus...  unless it has displayed other dialogs or popups that take
     * input focus, in which case the activity itself will not have focus
     * when the other windows have it.  Likewise, the system may display
     * system-level windows (such as the status bar notification panel or
     * a system alert) which will temporarily take window input focus without
     * pausing the foreground activity.
     *
     * @param hasFocus Whether the window of this activity has focus.
     * @see #hasWindowFocus()
     * @see #onResume
     * @see View#onWindowFocusChanged(boolean)
     */
    @Override
    public void onWindowFocusChanged(final boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    /**
     * Give the Activity a chance to control the UI for an action mode requested
     * by the system.
     *
     * <p>Note: If you are looking for a notification callback that an action mode
     * has been started for this activity, see {@link #onActionModeStarted(android.view.ActionMode)}.</p>
     *
     * @param callback The callback that should control the new action mode
     * @return The new action mode, or <code>null</code> if the activity does not want to
     * provide special handling for this action mode. (It will be handled by the system.)
     */
    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(
            final android.view.ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(
            final android.view.ActionMode.Callback callback, final int type) {
        return super.onWindowStartingActionMode(callback, type);
    }

    /**
     * Called when a support action mode is being started for this window. Gives the
     * callback an opportunity to handle the action mode in its own unique and
     * beautiful way. If this method returns null the system can choose a way
     * to present the mode or choose not to start the mode at all.
     *
     * @param callback Callback to control the lifecycle of this action mode
     * @return The ActionMode that was started, or null if the system should present it
     */
    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(
            @NonNull final ActionMode.Callback callback) {
        return super.onWindowStartingSupportActionMode(callback);
    }

    /**
     * Programmatically opens the context menu for a particular {@code view}.
     * The {@code view} should have been added via
     * {@link #registerForContextMenu(View)}.
     *
     * @param view The view to show the context menu for.
     */
    @Override
    public void openContextMenu(final View view) {
        super.openContextMenu(view);
    }

    @Override
    public FileInputStream openFileInput(final String name) throws FileNotFoundException {
        return super.openFileInput(name);
    }

    @Override
    public FileOutputStream openFileOutput(final String name, final int mode)
            throws FileNotFoundException {
        return super.openFileOutput(name, mode);
    }

    /**
     * Programmatically opens the options menu. If the options menu is already
     * open, this method does nothing.
     */
    @Override
    public void openOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(final String name, final int mode,
            final SQLiteDatabase.CursorFactory factory) {
        return super.openOrCreateDatabase(name, mode, factory);
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(final String name, final int mode,
            final SQLiteDatabase.CursorFactory factory, final DatabaseErrorHandler errorHandler) {
        return super.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    /**
     * Call immediately after one of the flavors of {@link #startActivity(Intent)}
     * or {@link #finish} to specify an explicit transition animation to
     * perform next.
     *
     * <p>As of {@link Build.VERSION_CODES#JELLY_BEAN} an alternative
     * to using this with starting activities is to supply the desired animation
     * information through a {@link ActivityOptions} bundle to
     * {@link #startActivity(Intent, Bundle)} or a related function.  This allows
     * you to specify a custom animation even when starting an activity from
     * outside the context of the current top activity.
     *
     * @param enterAnim A resource ID of the animation resource to use for
     *                  the incoming activity.  Use 0 for no animation.
     * @param exitAnim  A resource ID of the animation resource to use for
     */
    @Override
    public void overridePendingTransition(final int enterAnim, final int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    public Drawable peekWallpaper() {
        return super.peekWallpaper();
    }

    /**
     * Postpone the entering activity transition when Activity was started with
     * {@link ActivityOptions#makeSceneTransitionAnimation(Activity,
     * Pair[])}.
     * <p>This method gives the Activity the ability to delay starting the entering and
     * shared element transitions until all data is loaded. Until then, the Activity won't
     * draw into its window, leaving the window transparent. This may also cause the
     * returning animation to be delayed until data is ready. This method should be
     * called in {@link #onCreate(Bundle)} or in
     * {@link #onActivityReenter(int, Intent)}.
     * {@link #startPostponedEnterTransition()} must be called to allow the Activity to
     * start the transitions. If the Activity did not use
     * {@link ActivityOptions#makeSceneTransitionAnimation(Activity,
     * Pair[])}, then this method does nothing.</p>
     */
    @Override
    public void postponeEnterTransition() {
        super.postponeEnterTransition();
    }

    /**
     * Store an instance of {@link ExtraData} for later retrieval by class name
     * via {@link #getExtraData}.
     *
     * <p>Note that these objects are not retained across configuration changes</p>
     *
     * @hide
     * @see #getExtraData
     */
    @Override
    public void putExtraData(final ExtraData extraData) {
        super.putExtraData(extraData);
    }

    /**
     * Cause this Activity to be recreated with a new instance.  This results
     * in essentially the same flow as when the Activity is created due to
     * a configuration change -- the current instance will go through its
     * lifecycle to {@link #onDestroy} and a new instance then created after it.
     */
    @Override
    public void recreate() {
        super.recreate();
    }

    /**
     * Add a new {@link ComponentCallbacks} to the base application of the
     * Context, which will be called at the same times as the ComponentCallbacks
     * methods of activities and other components are called.  Note that you
     * <em>must</em> be sure to use {@link #unregisterComponentCallbacks} when
     * appropriate in the future; this will not be removed for you.
     *
     * @param callback The interface to call.  This can be either a
     *                 {@link ComponentCallbacks} or {@link ComponentCallbacks2} interface.
     */
    @Override
    public void registerComponentCallbacks(final ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }

    /**
     * Registers a context menu to be shown for the given view (multiple views
     * can show the context menu). This method will set the
     * {@link OnCreateContextMenuListener} on the view to this activity, so
     * {@link #onCreateContextMenu(ContextMenu, View, ContextMenuInfo)} will be
     * called when it is time to show the context menu.
     *
     * @param view The view that should show a context menu.
     * @see #unregisterForContextMenu(View)
     */
    @Override
    public void registerForContextMenu(final View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public Intent registerReceiver(final BroadcastReceiver receiver, final IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }

    @Override
    public Intent registerReceiver(final BroadcastReceiver receiver, final IntentFilter filter,
            final String broadcastPermission, final Handler scheduler) {
        return super.registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    /**
     * Ask that the local app instance of this activity be released to free up its memory.
     * This is asking for the activity to be destroyed, but does <b>not</b> finish the activity --
     * a new instance of the activity will later be re-created if needed due to the user
     * navigating back to it.
     *
     * @return Returns true if the activity was in a state that it has started the process
     * of destroying its current instance; returns false if for any reason this could not
     * be done: it is currently visible to the user, it is already being destroyed, it is
     * being finished, it hasn't yet saved its state, etc.
     */
    @Override
    public boolean releaseInstance() {
        return super.releaseInstance();
    }

    @Override
    public void removeStickyBroadcast(final Intent intent) {
        super.removeStickyBroadcast(intent);
    }

    @Override
    public void removeStickyBroadcastAsUser(final Intent intent, final UserHandle user) {
        super.removeStickyBroadcastAsUser(intent, user);
    }

    /**
     * Report to the system that your app is now fully drawn, purely for diagnostic
     * purposes (calling it does not impact the visible behavior of the activity).
     * This is only used to help instrument application launch times, so that the
     * app can report when it is fully in a usable state; without this, the only thing
     * the system itself can determine is the point at which the activity's window
     * is <em>first</em> drawn and displayed.  To participate in app launch time
     * measurement, you should always call this method after first launch (when
     * {@link #onCreate(Bundle)} is called), at the point where you have
     * entirely drawn your UI and populated with all of the significant data.  You
     * can safely call this method any time after first launch as well, in which case
     * it will simply be ignored.
     */
    @Override
    public void reportFullyDrawn() {
        super.reportFullyDrawn();
    }

    /**
     * Create {@link DragAndDropPermissions} object bound to this activity and controlling the
     * access permissions for content URIs associated with the {@link DragEvent}.
     *
     * @param event Drag event
     * @return The {@link DragAndDropPermissions} object used to control access to the content URIs.
     * Null if no content URIs are associated with the event or if permissions could not be
     * granted.
     */
    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(final DragEvent event) {
        return super.requestDragAndDropPermissions(event);
    }

    /**
     * Activities that want to remain visible behind a translucent activity above them must call
     * this method anytime between the start of {@link #onResume()} and the return from
     * {@link #onPause()}. If this call is successful then the activity will remain visible after
     * {@link #onPause()} is called, and is allowed to continue playing media in the background.
     *
     * <p>The actions of this call are reset each time that this activity is brought to the
     * front. That is, every time {@link #onResume()} is called the activity will be assumed
     * to not have requested visible behind. Therefore, if you want this activity to continue to
     * be visible in the background you must call this method again.
     *
     * <p>Only fullscreen opaque activities may make this call. I.e. this call is a nop
     * for dialog and translucent activities.
     *
     * <p>Under all circumstances, the activity must stop playing and release resources prior to or
     * within a call to {@link #onVisibleBehindCanceled()} or if this call returns false.
     *
     * <p>False will be returned any time this method is called between the return of onPause and
     * the next call to onResume.
     *
     * @param visible true to notify the system that the activity wishes to be visible behind other
     *                translucent activities, false to indicate otherwise. Resources must be
     *                released when passing false to this method.
     * @return the resulting visibiity state. If true the activity will remain visible beyond
     * {@link #onPause()} if the next activity is translucent or not fullscreen. If false
     * then the activity may not count on being visible behind other translucent activities,
     * and must stop any media playback and release resources.
     * Returning false may occur in lieu of a call to {@link #onVisibleBehindCanceled()} so
     * the return value must be checked.
     * @see #onVisibleBehindCanceled()
     */
    @Override
    public boolean requestVisibleBehind(final boolean visible) {
        return super.requestVisibleBehind(visible);
    }

    @Override
    public void revokeUriPermission(final Uri uri, final int modeFlags) {
        super.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public void sendBroadcast(final Intent intent) {
        super.sendBroadcast(intent);
    }

    @Override
    public void sendBroadcast(final Intent intent, final String receiverPermission) {
        super.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendBroadcastAsUser(final Intent intent, final UserHandle user) {
        super.sendBroadcastAsUser(intent, user);
    }

    @Override
    public void sendBroadcastAsUser(final Intent intent, final UserHandle user,
            final String receiverPermission) {
        super.sendBroadcastAsUser(intent, user, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(final Intent intent, final String receiverPermission) {
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(final Intent intent, final String receiverPermission,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras) {
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler,
                initialCode, initialData, initialExtras);
    }

    @Override
    public void sendOrderedBroadcastAsUser(final Intent intent, final UserHandle user,
            final String receiverPermission, final BroadcastReceiver resultReceiver,
            final Handler scheduler,
            final int initialCode, final String initialData, final Bundle initialExtras) {
        super.sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver,
                scheduler, initialCode, initialData, initialExtras);
    }

    @Override
    public void sendStickyBroadcast(final Intent intent) {
        super.sendStickyBroadcast(intent);
    }

    @Override
    public void sendStickyBroadcastAsUser(final Intent intent, final UserHandle user) {
        super.sendStickyBroadcastAsUser(intent, user);
    }

    @Override
    public void sendStickyOrderedBroadcast(final Intent intent,
            final BroadcastReceiver resultReceiver,
            final Handler scheduler, final int initialCode, final String initialData,
            final Bundle initialExtras) {
        super.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
    }

    @Override
    public void sendStickyOrderedBroadcastAsUser(final Intent intent, final UserHandle user,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras) {
        super.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
    }

    /**
     * Set a {@link Toolbar Toolbar} to act as the {@link ActionBar} for this
     * Activity window.
     *
     * <p>When set to a non-null value the {@link #getActionBar()} method will return
     * an {@link ActionBar} object that can be used to control the given toolbar as if it were
     * a traditional window decor action bar. The toolbar's menu will be populated with the
     * Activity's options menu and the navigation button will be wired through the standard
     * {@link android.R.id#home home} menu select action.</p>
     *
     * <p>In order to use a Toolbar within the Activity's window content the application
     * must not request the window feature {@link Window#FEATURE_ACTION_BAR
     * FEATURE_ACTION_BAR}.</p>
     *
     * @param toolbar Toolbar to set as the Activity's action bar, or {@code null} to clear it
     */
    @Override
    public void setActionBar(final Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    /**
     * Set the {@link TransitionManager} to use for default transitions in this window.
     * Requires {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * @param tm The TransitionManager to use for scene changes.
     */
    @Override
    public void setContentTransitionManager(final TransitionManager tm) {
        super.setContentTransitionManager(tm);
    }

    @Override
    public void setContentView(@LayoutRes final int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(final View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(final View view, final ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    /**
     * When {@link ActivityOptions#makeSceneTransitionAnimation(Activity,
     * View, String)} was used to start an Activity, <var>callback</var>
     * will be called to handle shared elements on the <i>launched</i> Activity. This requires
     * {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * @param callback Used to manipulate shared element transitions on the launched Activity.
     */
    @Override
    public void setEnterSharedElementCallback(final SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }

    /**
     * When {@link ActivityOptions#makeSceneTransitionAnimation(Activity,
     * View, String)} was used to start an Activity, <var>callback</var>
     * will be called to handle shared elements on the <i>launched</i> Activity. This requires
     * {@link Window#FEATURE_ACTIVITY_TRANSITIONS}.
     *
     * @param callback Used to manipulate shared element transitions on the launched Activity.
     */
    @Override
    public void setEnterSharedElementCallback(final android.app.SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }

    /**
     * When {@link ActivityOptions#makeSceneTransitionAnimation(Activity,
     * View, String)} was used to start an Activity, <var>listener</var>
     * will be called to handle shared elements on the <i>launching</i> Activity. Most
     * calls will only come when returning from the started Activity.
     * This requires {@link Window#FEATURE_CONTENT_TRANSITIONS}.
     *
     * @param listener Used to manipulate shared element transitions on the launching Activity.
     */
    @Override
    public void setExitSharedElementCallback(final SharedElementCallback listener) {
        super.setExitSharedElementCallback(listener);
    }

    /**
     * When {@link ActivityOptions#makeSceneTransitionAnimation(Activity,
     * View, String)} was used to start an Activity, <var>callback</var>
     * will be called to handle shared elements on the <i>launching</i> Activity. Most
     * calls will only come when returning from the started Activity.
     * This requires {@link Window#FEATURE_ACTIVITY_TRANSITIONS}.
     *
     * @param callback Used to manipulate shared element transitions on the launching Activity.
     */
    @Override
    public void setExitSharedElementCallback(final android.app.SharedElementCallback callback) {
        super.setExitSharedElementCallback(callback);
    }

    /**
     * Sets whether this activity is finished when touched outside its window's
     * bounds.
     */
    @Override
    public void setFinishOnTouchOutside(final boolean finish) {
        super.setFinishOnTouchOutside(finish);
    }

    /**
     * Adjust the current immersive mode setting.
     *
     * Note that changing this value will have no effect on the activity's
     * {@link ActivityInfo} structure; that is, if
     * <code>android:immersive</code> is set to <code>true</code>
     * in the application's manifest entry for this activity, the {@link
     * ActivityInfo#flags ActivityInfo.flags} member will
     * always have its {@link ActivityInfo#FLAG_IMMERSIVE
     * FLAG_IMMERSIVE} bit set.
     *
     * @see #isImmersive()
     * @see ActivityInfo#FLAG_IMMERSIVE
     */
    @Override
    public void setImmersive(final boolean i) {
        super.setImmersive(i);
    }

    /**
     * Change the intent returned by {@link #getIntent}.  This holds a
     * reference to the given intent; it does not copy it.  Often used in
     * conjunction with {@link #onNewIntent}.
     *
     * @param newIntent The new Intent object to return from getIntent
     * @see #getIntent
     * @see #onNewIntent
     */
    @Override
    public void setIntent(final Intent newIntent) {
        super.setIntent(newIntent);
    }

    /**
     * Change the desired orientation of this activity.  If the activity
     * is currently in the foreground or otherwise impacting the screen
     * orientation, the screen will immediately be changed (possibly causing
     * the activity to be restarted). Otherwise, this will be used the next
     * time the activity is visible.
     *
     * @param requestedOrientation An orientation constant as used in
     *                             {@link ActivityInfo#screenOrientation ActivityInfo.screenOrientation}.
     */
    @Override
    public void setRequestedOrientation(final int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
    }

    /**
     * Set a {@link Toolbar Toolbar} to act as the
     * {@link ActionBar} for this Activity window.
     *
     * <p>When set to a non-null value the {@link #getActionBar()} method will return
     * an {@link ActionBar} object that can be used to control the given
     * toolbar as if it were a traditional window decor action bar. The toolbar's menu will be
     * populated with the Activity's options menu and the navigation button will be wired through
     * the standard {@link android.R.id#home home} menu select action.</p>
     *
     * <p>In order to use a Toolbar within the Activity's window content the application
     * must not request the window feature
     * {@link Window#FEATURE_ACTION_BAR FEATURE_SUPPORT_ACTION_BAR}.</p>
     *
     * @param toolbar Toolbar to set as the Activity's action bar, or {@code null} to clear it
     */
    @Override
    public void setSupportActionBar(@Nullable final android.support.v7.widget.Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    /**
     * @deprecated Progress bars are no longer provided in AppCompat.
     */
    @Override
    public void setSupportProgress(final int progress) {
        super.setSupportProgress(progress);
    }

    /**
     * @deprecated Progress bars are no longer provided in AppCompat.
     */
    @Override
    public void setSupportProgressBarIndeterminate(final boolean indeterminate) {
        super.setSupportProgressBarIndeterminate(indeterminate);
    }

    /**
     * @deprecated Progress bars are no longer provided in AppCompat.
     */
    @Override
    public void setSupportProgressBarIndeterminateVisibility(final boolean visible) {
        super.setSupportProgressBarIndeterminateVisibility(visible);
    }

    /**
     * @deprecated Progress bars are no longer provided in AppCompat.
     */
    @Override
    public void setSupportProgressBarVisibility(final boolean visible) {
        super.setSupportProgressBarVisibility(visible);
    }

    /**
     * Sets information describing the task with this activity for presentation inside the Recents
     * System UI. When {@link ActivityManager#getRecentTasks} is called, the activities of each
     * task
     * are traversed in order from the topmost activity to the bottommost. The traversal continues
     * for each property until a suitable value is found. For each task the taskDescription will be
     * returned in {@link ActivityManager.TaskDescription}.
     *
     * @param taskDescription The TaskDescription properties that describe the task with this
     *                        activity
     * @see ActivityManager#getRecentTasks
     * @see ActivityManager.TaskDescription
     */
    @Override
    public void setTaskDescription(final ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override
    public void setTheme(@StyleRes final int resid) {
        super.setTheme(resid);
    }

    /**
     * Change the title associated with this activity.  If this is a
     * top-level activity, the title for its window will change.  If it
     * is an embedded activity, the parent can do whatever it wants
     * with it.
     */
    @Override
    public void setTitle(final CharSequence title) {
        super.setTitle(title);
    }

    /**
     * Change the title associated with this activity.  If this is a
     * top-level activity, the title for its window will change.  If it
     * is an embedded activity, the parent can do whatever it wants
     * with it.
     */
    @Override
    public void setTitle(final int titleId) {
        super.setTitle(titleId);
    }

    /**
     * Change the color of the title associated with this activity.
     * <p>
     * This method is deprecated starting in API Level 11 and replaced by action
     * bar styles. For information on styling the Action Bar, read the <a
     * href="{@docRoot} guide/topics/ui/actionbar.html">Action Bar</a> developer
     * guide.
     *
     * @deprecated Use action bar styles instead.
     */
    @Override
    public void setTitleColor(final int textColor) {
        super.setTitleColor(textColor);
    }

    /**
     * Control whether this activity's main window is visible.  This is intended
     * only for the special case of an activity that is not going to show a
     * UI itself, but can't just finish prior to onResume() because it needs
     * to wait for a service binding or such.  Setting this to false allows
     * you to prevent your UI from being shown during that time.
     *
     * <p>The default value for this is taken from the
     * {@link android.R.attr#windowNoDisplay} attribute of the activity's theme.
     */
    @Override
    public void setVisible(final boolean visible) {
        super.setVisible(visible);
    }

    /**
     * Enable or disable virtual reality (VR) mode for this Activity.
     *
     * <p>VR mode is a hint to Android system to switch to a mode optimized for VR applications
     * while this Activity has user focus.</p>
     *
     * <p>It is recommended that applications additionally declare
     * {@link android.R.attr#enableVrMode} in their manifest to allow for smooth activity
     * transitions when switching between VR activities.</p>
     *
     * <p>If the requested {@link VrListenerService} component is not available,
     * VR mode will not be started.  Developers can handle this case as follows:</p>
     *
     * <pre>
     * String servicePackage = "com.whatever.app";
     * String serviceClass = "com.whatever.app.MyVrListenerService";
     *
     * // Name of the component of the VrListenerService to start.
     * ComponentName serviceComponent = new ComponentName(servicePackage, serviceClass);
     *
     * try {
     *    setVrModeEnabled(true, myComponentName);
     * } catch (PackageManager.NameNotFoundException e) {
     *        List&lt;ApplicationInfo> installed = getPackageManager().getInstalledApplications(0);
     *        boolean isInstalled = false;
     *        for (ApplicationInfo app : installed) {
     *            if (app.packageName.equals(servicePackage)) {
     *                isInstalled = true;
     *                break;
     *            }
     *        }
     *        if (isInstalled) {
     *            // Package is installed, but not enabled in Settings.  Let user enable it.
     *            startActivity(new Intent(Settings.ACTION_VR_LISTENER_SETTINGS));
     *        } else {
     *            // Package is not installed.  Send an intent to download this.
     *            sentIntentToLaunchAppStore(servicePackage);
     *        }
     * }
     * </pre>
     *
     * @param enabled            {@code true} to enable this mode.
     * @param requestedComponent the name of the component to use as a
     *                           {@link VrListenerService} while VR mode is enabled.
     * @throws PackageManager.NameNotFoundException if the given component
     *                                              to run as a {@link VrListenerService} is not
     *                                              installed, or has
     *                                              not been enabled in user settings.
     * @see PackageManager#FEATURE_VR_MODE
     * @see PackageManager#FEATURE_VR_MODE_HIGH_PERFORMANCE
     * @see VrListenerService
     * @see Settings#ACTION_VR_LISTENER_SETTINGS
     * @see android.R.attr#enableVrMode
     */
    @Override
    public void setVrModeEnabled(final boolean enabled, final ComponentName requestedComponent)
            throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @Override
    public void setWallpaper(final Bitmap bitmap) throws IOException {
        super.setWallpaper(bitmap);
    }

    @Override
    public void setWallpaper(final InputStream data) throws IOException {
        super.setWallpaper(data);
    }

    /**
     * Gets whether you should show UI with rationale for requesting a permission.
     * You should do this only if you do not have the permission and the context in
     * which the permission is requested does not clearly communicate to the user
     * what would be the benefit from granting this permission.
     * <p>
     * For example, if you write a camera app, requesting the camera permission
     * would be expected by the user and no rationale for why it is requested is
     * needed. If however, the app needs location for tagging photos then a non-tech
     * savvy user may wonder how location is related to taking photos. In this case
     * you may choose to show UI with rationale of requesting this permission.
     * </p>
     *
     * @param permission A permission your app wants to request.
     * @return Whether you can show permission rationale UI.
     * @see #checkSelfPermission(String)
     * @see #requestPermissions(String[], int)
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    @Override
    public boolean shouldShowRequestPermissionRationale(final String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }

    /**
     * Returns true if the app should recreate the task when navigating 'up' from this activity
     * by using targetIntent.
     *
     * <p>If this method returns false the app can trivially call
     * {@link #navigateUpTo(Intent)} using the same parameters to correctly perform
     * up navigation. If this method returns false, the app should synthesize a new task stack
     * by using {@link TaskStackBuilder} or another similar mechanism to perform up navigation.</p>
     *
     * @param targetIntent An intent representing the target destination for up navigation
     * @return true if navigating up should recreate a new task stack, false if the same task
     * should be used for the destination
     */
    @Override
    public boolean shouldUpRecreateTask(final Intent targetIntent) {
        return super.shouldUpRecreateTask(targetIntent);
    }

    /**
     * Ask to have the current assistant shown to the user.  This only works if the calling
     * activity is the current foreground activity.  It is the same as calling
     * {@link VoiceInteractionService#showSession
     * VoiceInteractionService.showSession} and requesting all of the possible context.
     * The receiver will always see
     * {@link VoiceInteractionSession#SHOW_SOURCE_APPLICATION} set.
     *
     * @return Returns true if the assistant was successfully invoked, else false.  For example
     * false will be returned if the caller is not the current top activity.
     */
    @Override
    public boolean showAssist(final Bundle args) {
        return super.showAssist(args);
    }

    /**
     * Shows the user the system defined message for telling the user how to exit
     * lock task mode. The task containing this activity must be in lock task mode at the time
     * of this call for the message to be displayed.
     */
    @Override
    public void showLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    /**
     * Start an action mode of the default type {@link android.view.ActionMode#TYPE_PRIMARY}.
     *
     * @param callback Callback that will manage lifecycle events for this action mode
     * @return The ActionMode that was started, or null if it was canceled
     * @see android.view.ActionMode
     */
    @Nullable
    @Override
    public android.view.ActionMode startActionMode(
            final android.view.ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    /**
     * Start an action mode of the given type.
     *
     * @param callback Callback that will manage lifecycle events for this action mode
     * @param type     One of {@link android.view.ActionMode#TYPE_PRIMARY} or {@link
     *                 android.view.ActionMode#TYPE_FLOATING}.
     * @return The ActionMode that was started, or null if it was canceled
     * @see android.view.ActionMode
     */
    @Nullable
    @Override
    public android.view.ActionMode startActionMode(final android.view.ActionMode.Callback callback,
            final int type) {
        return super.startActionMode(callback, type);
    }

    /**
     * Same as {@link #startActivities(Intent[], Bundle)} with no options
     * specified.
     *
     * @param intents The intents to start.
     * @see #startActivities(Intent[], Bundle)
     * @see #startActivityForResult
     */
    @Override
    public void startActivities(final Intent[] intents) {
        super.startActivities(intents);
    }

    /**
     * Launch a new activity.  You will not receive any information about when
     * the activity exits.  This implementation overrides the base version,
     * providing information about
     * the activity performing the launch.  Because of this additional
     * information, the {@link Intent#FLAG_ACTIVITY_NEW_TASK} launch flag is not
     * required; if not specified, the new activity will be added to the
     * task of the caller.
     *
     * <p>This method throws {@link ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     *
     * @param intents The intents to start.
     * @param options Additional options for how the Activity should be started.
     *                See {@link Context#startActivity(Intent, Bundle)
     *                Context.startActivity(Intent, Bundle)} for more details.
     * @see #startActivities(Intent[])
     * @see #startActivityForResult
     */
    @Override
    public void startActivities(final Intent[] intents, final Bundle options) {
        super.startActivities(intents, options);
    }

    /**
     * Same as {@link #startActivity(Intent, Bundle)} with no options
     * specified.
     *
     * @param intent The intent to start.
     * @see #startActivity(Intent, Bundle)
     * @see #startActivityForResult
     */
    @Override
    public void startActivity(final Intent intent) {
        super.startActivity(intent);
    }

    /**
     * Launch a new activity.  You will not receive any information about when
     * the activity exits.  This implementation overrides the base version,
     * providing information about
     * the activity performing the launch.  Because of this additional
     * information, the {@link Intent#FLAG_ACTIVITY_NEW_TASK} launch flag is not
     * required; if not specified, the new activity will be added to the
     * task of the caller.
     *
     * <p>This method throws {@link ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     *
     * @param intent  The intent to start.
     * @param options Additional options for how the Activity should be started.
     *                See {@link Context#startActivity(Intent, Bundle)
     *                Context.startActivity(Intent, Bundle)} for more details.
     * @see #startActivity(Intent)
     * @see #startActivityForResult
     */
    @Override
    public void startActivity(final Intent intent, final Bundle options) {
        super.startActivity(intent, options);
    }

    /**
     * Modifies the standard behavior to allow results to be delivered to fragments.
     * This imposes a restriction that requestCode be <= 0xffff.
     */
    @Override
    public void startActivityForResult(final Intent intent, final int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(final Intent intent, final int requestCode,
            @Nullable final Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }

    /**
     * Same as calling {@link #startActivityFromChild(Activity, Intent, int, Bundle)}
     * with no options.
     *
     * @param child       The activity making the call.
     * @param intent      The intent to start.
     * @param requestCode Reply request code.  < 0 if reply is not requested.
     * @see #startActivity
     * @see #startActivityForResult
     */
    @Override
    public void startActivityFromChild(final Activity child, final Intent intent,
            final int requestCode) {
        super.startActivityFromChild(child, intent, requestCode);
    }

    /**
     * This is called when a child activity of this one calls its
     * {@link #startActivity} or {@link #startActivityForResult} method.
     *
     * <p>This method throws {@link ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     *
     * @param child       The activity making the call.
     * @param intent      The intent to start.
     * @param requestCode Reply request code.  < 0 if reply is not requested.
     * @param options     Additional options for how the Activity should be started.
     *                    See {@link Context#startActivity(Intent, Bundle)
     *                    Context.startActivity(Intent, Bundle)} for more details.
     * @see #startActivity
     * @see #startActivityForResult
     */
    @Override
    public void startActivityFromChild(final Activity child, final Intent intent,
            final int requestCode,
            final Bundle options) {
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    /**
     * Called by Fragment.startActivityForResult() to implement its behavior.
     */
    @Override
    public void startActivityFromFragment(final Fragment fragment, final Intent intent,
            final int requestCode) {
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    /**
     * Called by Fragment.startActivityForResult() to implement its behavior.
     */
    @Override
    public void startActivityFromFragment(final Fragment fragment, final Intent intent,
            final int requestCode,
            @Nullable final Bundle options) {
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    /**
     * Same as calling {@link #startActivityFromFragment(android.app.Fragment, Intent, int,
     * Bundle)}
     * with no options.
     *
     * @param fragment    The fragment making the call.
     * @param intent      The intent to start.
     * @param requestCode Reply request code.  < 0 if reply is not requested.
     * @see android.app.Fragment#startActivity
     * @see android.app.Fragment#startActivityForResult
     */
    @Override
    public void startActivityFromFragment(final android.app.Fragment fragment, final Intent intent,
            final int requestCode) {
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    /**
     * This is called when a Fragment in this activity calls its
     * {@link android.app.Fragment#startActivity} or {@link android.app.Fragment#startActivityForResult}
     * method.
     *
     * <p>This method throws {@link ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     *
     * @param fragment    The fragment making the call.
     * @param intent      The intent to start.
     * @param requestCode Reply request code.  < 0 if reply is not requested.
     * @param options     Additional options for how the Activity should be started.
     *                    See {@link Context#startActivity(Intent, Bundle)
     *                    Context.startActivity(Intent, Bundle)} for more details.
     * @see android.app.Fragment#startActivity
     * @see android.app.Fragment#startActivityForResult
     */
    @Override
    public void startActivityFromFragment(final android.app.Fragment fragment, final Intent intent,
            final int requestCode,
            final Bundle options) {
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    /**
     * Same as calling {@link #startActivityIfNeeded(Intent, int, Bundle)}
     * with no options.
     *
     * @param intent      The intent to start.
     * @param requestCode If >= 0, this code will be returned in
     *                    onActivityResult() when the activity exits, as described in
     *                    {@link #startActivityForResult}.
     * @return If a new activity was launched then true is returned; otherwise
     * false is returned and you must handle the Intent yourself.
     * @see #startActivity
     * @see #startActivityForResult
     */
    @Override
    public boolean startActivityIfNeeded(final Intent intent, final int requestCode) {
        return super.startActivityIfNeeded(intent, requestCode);
    }

    /**
     * A special variation to launch an activity only if a new activity
     * instance is needed to handle the given Intent.  In other words, this is
     * just like {@link #startActivityForResult(Intent, int)} except: if you are
     * using the {@link Intent#FLAG_ACTIVITY_SINGLE_TOP} flag, or
     * singleTask or singleTop
     * {@link android.R.styleable#AndroidManifestActivity_launchMode launchMode},
     * and the activity
     * that handles <var>intent</var> is the same as your currently running
     * activity, then a new instance is not needed.  In this case, instead of
     * the normal behavior of calling {@link #onNewIntent} this function will
     * return and you can handle the Intent yourself.
     *
     * <p>This function can only be called from a top-level activity; if it is
     * called from a child activity, a runtime exception will be thrown.
     *
     * @param intent      The intent to start.
     * @param requestCode If >= 0, this code will be returned in
     *                    onActivityResult() when the activity exits, as described in
     *                    {@link #startActivityForResult}.
     * @param options     Additional options for how the Activity should be started.
     *                    See {@link Context#startActivity(Intent, Bundle)
     *                    Context.startActivity(Intent, Bundle)} for more details.
     * @return If a new activity was launched then true is returned; otherwise
     * false is returned and you must handle the Intent yourself.
     * @see #startActivity
     * @see #startActivityForResult
     */
    @Override
    public boolean startActivityIfNeeded(final Intent intent, final int requestCode,
            final Bundle options) {
        return super.startActivityIfNeeded(intent, requestCode, options);
    }

    @Override
    public boolean startInstrumentation(final ComponentName className, final String profileFile,
            final Bundle arguments) {
        return super.startInstrumentation(className, profileFile, arguments);
    }

    /**
     * Same as calling {@link #startIntentSender(IntentSender, Intent, int, int, int, Bundle)}
     * with no options.
     *
     * @param intent       The IntentSender to launch.
     * @param fillInIntent If non-null, this will be provided as the
     *                     intent parameter to {@link IntentSender#sendIntent}.
     * @param flagsMask    Intent flags in the original IntentSender that you
     *                     would like to change.
     * @param flagsValues  Desired values for any bits set in
     *                     <var>flagsMask</var>
     * @param extraFlags   Always set to 0.
     */
    @Override
    public void startIntentSender(final IntentSender intent, final Intent fillInIntent,
            final int flagsMask,
            final int flagsValues, final int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    /**
     * Like {@link #startActivity(Intent, Bundle)}, but taking a IntentSender
     * to start; see
     * {@link #startIntentSenderForResult(IntentSender, int, Intent, int, int, int, Bundle)}
     * for more information.
     *
     * @param intent       The IntentSender to launch.
     * @param fillInIntent If non-null, this will be provided as the
     *                     intent parameter to {@link IntentSender#sendIntent}.
     * @param flagsMask    Intent flags in the original IntentSender that you
     *                     would like to change.
     * @param flagsValues  Desired values for any bits set in
     *                     <var>flagsMask</var>
     * @param extraFlags   Always set to 0.
     * @param options      Additional options for how the Activity should be started.
     *                     See {@link Context#startActivity(Intent, Bundle)
     *                     Context.startActivity(Intent, Bundle)} for more details.  If options
     *                     have also been supplied by the IntentSender, options given here will
     */
    @Override
    public void startIntentSender(final IntentSender intent, final Intent fillInIntent,
            final int flagsMask,
            final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException {
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags,
            final Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues,
                extraFlags, options);
    }

    @Override
    public void startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags)
            throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues,
                extraFlags);
    }

    /**
     * Same as calling {@link #startIntentSenderFromChild(Activity, IntentSender,
     * int, Intent, int, int, int, Bundle)} with no options.
     */
    @Override
    public void startIntentSenderFromChild(final Activity child, final IntentSender intent,
            final int requestCode,
            final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags)
            throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask,
                flagsValues, extraFlags);
    }

    /**
     * Like {@link #startActivityFromChild(Activity, Intent, int)}, but
     * taking a IntentSender; see
     * {@link #startIntentSenderForResult(IntentSender, int, Intent, int, int, int)}
     * for more information.
     */
    @Override
    public void startIntentSenderFromChild(final Activity child, final IntentSender intent,
            final int requestCode,
            final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask,
                flagsValues, extraFlags, options);
    }

    /**
     * Called by Fragment.startIntentSenderForResult() to implement its behavior.
     */
    @Override
    public void startIntentSenderFromFragment(final Fragment fragment, final IntentSender intent,
            final int requestCode, @Nullable final Intent fillInIntent, final int flagsMask,
            final int flagsValues,
            final int extraFlags, final Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask,
                flagsValues, extraFlags, options);
    }

    /**
     * Starts a local voice interaction session. When ready,
     * {@link #onLocalVoiceInteractionStarted()} is called. You can pass a bundle of private
     * options
     * to the registered voice interaction service.
     *
     * @param privateOptions a Bundle of private arguments to the current voice interaction service
     */
    @Override
    public void startLocalVoiceInteraction(final Bundle privateOptions) {
        super.startLocalVoiceInteraction(privateOptions);
    }

    /**
     * Request to put this Activity in a mode where the user is locked to the
     * current task.
     *
     * This will prevent the user from launching other apps, going to settings, or reaching the
     * home screen. This does not include those apps whose {@link android.R.attr#lockTaskMode}
     * values permit launching while locked.
     *
     * If {@link DevicePolicyManager#isLockTaskPermitted(String)} returns true or
     * lockTaskMode=lockTaskModeAlways for this component then the app will go directly into
     * Lock Task mode. The user will not be able to exit this mode until
     * {@link Activity#stopLockTask()} is called.
     *
     * If {@link DevicePolicyManager#isLockTaskPermitted(String)} returns false
     * then the system will prompt the user with a dialog requesting permission to enter
     * this mode.  When entered through this method the user can exit at any time through
     * an action described by the request dialog.  Calling stopLockTask will also exit the
     * mode.
     *
     * @see android.R.attr#lockTaskMode
     */
    @Override
    public void startLockTask() {
        super.startLockTask();
    }

    /**
     * This method allows the activity to take care of managing the given
     * {@link Cursor}'s lifecycle for you based on the activity's lifecycle.
     * That is, when the activity is stopped it will automatically call
     * {@link Cursor#deactivate} on the given Cursor, and when it is later restarted
     * it will call {@link Cursor#requery} for you.  When the activity is
     * destroyed, all managed Cursors will be closed automatically.
     *
     * <em>If you are targeting {@link Build.VERSION_CODES#HONEYCOMB}
     * or later, consider instead using {@link LoaderManager} instead, available
     * via {@link #getLoaderManager()}.</em>
     *
     * <p><strong>Warning:</strong> Do not call {@link Cursor#close()} on cursor obtained from
     * {@link #managedQuery}, because the activity will do that for you at the appropriate time.
     * However, if you call {@link #stopManagingCursor} on a cursor from a managed query, the
     * system
     * <em>will not</em> automatically close the cursor and, in that case, you must call
     * {@link Cursor#close()}.</p>
     *
     * @param c The Cursor to be managed.
     * @see #managedQuery(Uri, String[], String, String[], String)
     * @see #stopManagingCursor
     * @deprecated Use the new {@link CursorLoader} class with
     * {@link LoaderManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @Override
    public void startManagingCursor(final Cursor c) {
        super.startManagingCursor(c);
    }

    /**
     * Same as calling {@link #startNextMatchingActivity(Intent, Bundle)} with
     * no options.
     *
     * @param intent The intent to dispatch to the next activity.  For
     *               correct behavior, this must be the same as the Intent that started
     *               your own activity; the only changes you can make are to the extras
     *               inside of it.
     * @return Returns a boolean indicating whether there was another Activity
     * to start: true if there was a next activity to start, false if there
     * wasn't.  In general, if true is returned you will then want to call
     * finish() on yourself.
     */
    @Override
    public boolean startNextMatchingActivity(final Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    /**
     * Special version of starting an activity, for use when you are replacing
     * other activity components.  You can use this to hand the Intent off
     * to the next Activity that can handle it.  You typically call this in
     * {@link #onCreate} with the Intent returned by {@link #getIntent}.
     *
     * @param intent  The intent to dispatch to the next activity.  For
     *                correct behavior, this must be the same as the Intent that started
     *                your own activity; the only changes you can make are to the extras
     *                inside of it.
     * @param options Additional options for how the Activity should be started.
     *                See {@link Context#startActivity(Intent, Bundle)
     *                Context.startActivity(Intent, Bundle)} for more details.
     * @return Returns a boolean indicating whether there was another Activity
     * to start: true if there was a next activity to start, false if there
     * wasn't.  In general, if true is returned you will then want to call
     * finish() on yourself.
     */
    @Override
    public boolean startNextMatchingActivity(final Intent intent, final Bundle options) {
        return super.startNextMatchingActivity(intent, options);
    }

    /**
     * Begin postponed transitions after {@link #postponeEnterTransition()} was called.
     * If postponeEnterTransition() was called, you must call startPostponedEnterTransition()
     * to have your Activity start drawing.
     */
    @Override
    public void startPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    /**
     * This hook is called to launch the search UI.
     *
     * <p>It is typically called from onSearchRequested(), either directly from
     * Activity.onSearchRequested() or from an overridden version in any given
     * Activity.  If your goal is simply to activate search, it is preferred to call
     * onSearchRequested(), which may have been overridden elsewhere in your Activity.  If your
     * goal
     * is to inject specific data such as context data, it is preferred to <i>override</i>
     * onSearchRequested(), so that any callers to it will benefit from the override.
     *
     * @param initialQuery       Any non-null non-empty string will be inserted as
     *                           pre-entered text in the search query box.
     * @param selectInitialQuery If true, the initial query will be preselected, which means that
     *                           any further typing will replace it.  This is useful for cases
     *                           where
     *                           an entire pre-formed
     *                           query is being inserted.  If false, the selection point will be
     *                           placed at the end of the
     *                           inserted query.  This is useful when the inserted query is text
     *                           that the user entered,
     *                           and the user would expect to be able to keep typing.  <i>This
     *                           parameter is only meaningful
     *                           if initialQuery is a non-empty string.</i>
     * @param appSearchData      An application can insert application-specific
     *                           context here, in order to improve quality or specificity of its
     *                           own
     *                           searches.  This data will be returned with SEARCH intent(s).  Null
     *                           if
     *                           no extra data is required.
     * @param globalSearch       If false, this will only launch the search that has been
     *                           specifically
     *                           defined by the application (which is usually defined as a local
     *                           search).  If no default
     *                           search is defined in the current application or activity, global
     *                           search will be launched.
     *                           If true, this will always launch a platform-global (e.g.
     *                           web-based)
     *                           search instead.
     * @see SearchManager
     * @see #onSearchRequested
     */
    @Override
    public void startSearch(final String initialQuery, final boolean selectInitialQuery,
            final Bundle appSearchData,
            final boolean globalSearch) {
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @Override
    public ComponentName startService(final Intent service) {
        return super.startService(service);
    }

    /**
     * Start an action mode.
     *
     * @param callback Callback that will manage lifecycle events for this context mode
     * @return The ContextMode that was started, or null if it was canceled
     */
    @Nullable
    @Override
    public ActionMode startSupportActionMode(@NonNull final ActionMode.Callback callback) {
        return super.startSupportActionMode(callback);
    }

    /**
     * Request to terminate the current voice interaction that was previously started
     * using {@link #startLocalVoiceInteraction(Bundle)}. When the interaction is
     * terminated, {@link #onLocalVoiceInteractionStopped()} will be called.
     */
    @Override
    public void stopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    /**
     * Allow the user to switch away from the current task.
     *
     * Called to end the mode started by {@link Activity#startLockTask}. This
     * can only be called by activities that have successfully called
     * startLockTask previously.
     *
     * This will allow the user to exit this app and move onto other activities.
     * <p>Note: This method should only be called when the activity is user-facing. That is,
     * between onResume() and onPause().
     * <p>Note: If there are other tasks below this one that are also locked then calling this
     * method will immediately finish this task and resume the previous locked one, remaining in
     * lockTask mode.
     *
     * @see android.R.attr#lockTaskMode
     * @see ActivityManager#getLockTaskModeState()
     */
    @Override
    public void stopLockTask() {
        super.stopLockTask();
    }

    /**
     * Given a Cursor that was previously given to
     * {@link #startManagingCursor}, stop the activity's management of that
     * cursor.
     *
     * <p><strong>Warning:</strong> After calling this method on a cursor from a managed query,
     * the system <em>will not</em> automatically close the cursor and you must call
     * {@link Cursor#close()}.</p>
     *
     * @param c The Cursor that was being managed.
     * @see #startManagingCursor
     * @deprecated Use the new {@link CursorLoader} class with
     * {@link LoaderManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @Override
    public void stopManagingCursor(final Cursor c) {
        super.stopManagingCursor(c);
    }

    @Override
    public boolean stopService(final Intent name) {
        return super.stopService(name);
    }

    /**
     * Reverses the Activity Scene entry Transition and triggers the calling Activity
     * to reverse its exit Transition. When the exit Transition completes,
     * {@link #finish()} is called. If no entry Transition was used, finish() is called
     * immediately and the Activity exit Transition is run.
     *
     * <p>On Android 4.4 or lower, this method only finishes the Activity with no
     * special exit transition.</p>
     */
    @Override
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
    }

    /**
     * Navigate from sourceActivity to the activity specified by upIntent, finishing sourceActivity
     * in the process. upIntent will have the flag {@link Intent#FLAG_ACTIVITY_CLEAR_TOP} set
     * by this method, along with any others required for proper up navigation as outlined
     * in the Android Design Guide.
     *
     * <p>This method should be used when performing up navigation from within the same task
     * as the destination. If up navigation should cross tasks in some cases, see
     * {@link #supportShouldUpRecreateTask(Intent)}.</p>
     *
     * @param upIntent An intent representing the target destination for up navigation
     */
    @Override
    public void supportNavigateUpTo(@NonNull final Intent upIntent) {
        super.supportNavigateUpTo(upIntent);
    }

    /**
     * Support library version of {@link Activity#postponeEnterTransition()} that works
     * only on API 21 and later.
     */
    @Override
    public void supportPostponeEnterTransition() {
        super.supportPostponeEnterTransition();
    }

    /**
     * Enable extended support library window features.
     * <p>
     * This is a convenience for calling
     * {@link Window#requestFeature getWindow().requestFeature()}.
     * </p>
     *
     * @param featureId The desired feature as defined in
     *                  {@link Window} or {@link WindowCompat}.
     * @return Returns true if the requested feature is supported and now enabled.
     * @see Activity#requestWindowFeature
     * @see Window#requestFeature
     */
    @Override
    public boolean supportRequestWindowFeature(final int featureId) {
        return super.supportRequestWindowFeature(featureId);
    }

    /**
     * Returns true if sourceActivity should recreate the task when navigating 'up'
     * by using targetIntent.
     *
     * <p>If this method returns false the app can trivially call
     * {@link #supportNavigateUpTo(Intent)} using the same parameters to correctly perform
     * up navigation. If this method returns false, the app should synthesize a new task stack
     * by using {@link android.support.v4.app.TaskStackBuilder} or another similar mechanism to
     * perform up navigation.</p>
     *
     * @param targetIntent An intent representing the target destination for up navigation
     * @return true if navigating up should recreate a new task stack, false if the same task
     * should be used for the destination
     */
    @Override
    public boolean supportShouldUpRecreateTask(@NonNull final Intent targetIntent) {
        return super.supportShouldUpRecreateTask(targetIntent);
    }

    /**
     * Support library version of {@link Activity#startPostponedEnterTransition()}
     * that only works with API 21 and later.
     */
    @Override
    public void supportStartPostponedEnterTransition() {
        super.supportStartPostponedEnterTransition();
    }

    /**
     * Request that key events come to this activity. Use this if your
     * activity has no views with focus, but the activity still wants
     * a chance to process key events.
     *
     * @see Window#takeKeyEvents
     */
    @Override
    public void takeKeyEvents(final boolean get) {
        super.takeKeyEvents(get);
    }

    /**
     * Similar to {@link #startSearch}, but actually fires off the search query after invoking
     * the search dialog.  Made available for testing purposes.
     *
     * @param query         The query to trigger.  If empty, the request will be ignored.
     * @param appSearchData An application can insert application-specific
     *                      context here, in order to improve quality or specificity of its own
     *                      searches.  This data will be returned with SEARCH intent(s).  Null if
     */
    @Override
    public void triggerSearch(final String query, final Bundle appSearchData) {
        super.triggerSearch(query, appSearchData);
    }

    @Override
    public void unbindService(final ServiceConnection conn) {
        super.unbindService(conn);
    }

    /**
     * Remove a {@link ComponentCallbacks} object that was previously registered
     * with {@link #registerComponentCallbacks(ComponentCallbacks)}.
     */
    @Override
    public void unregisterComponentCallbacks(final ComponentCallbacks callback) {
        super.unregisterComponentCallbacks(callback);
    }

    /**
     * Prevents a context menu to be shown for the given view. This method will remove the
     * {@link OnCreateContextMenuListener} on the view.
     *
     * @param view The view that should stop showing a context menu.
     * @see #registerForContextMenu(View)
     */
    @Override
    public void unregisterForContextMenu(final View view) {
        super.unregisterForContextMenu(view);
    }

    @Override
    public void unregisterReceiver(final BroadcastReceiver receiver) {
        super.unregisterReceiver(receiver);
    }

    @Override
    protected void attachBaseContext(final Context newBase) {
        super.attachBaseContext(newBase);
    }

    /**
     * Dispatch incoming result to the correct fragment.
     */
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode,
            final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onApplyThemeResource(final Resources.Theme theme, final int resid,
            final boolean first) {
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    protected void onChildTitleChanged(final Activity childActivity, final CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * @deprecated Old no-arguments version of {@link #onCreateDialog(int, Bundle)}.
     */
    @Override
    protected Dialog onCreateDialog(final int id) {
        return super.onCreateDialog(id);
    }

    /**
     * Callback for creating dialogs that are managed (saved and restored) for you
     * by the activity.  The default implementation calls through to
     * {@link #onCreateDialog(int)} for compatibility.
     *
     * <em>If you are targeting {@link Build.VERSION_CODES#HONEYCOMB}
     * or later, consider instead using a {@link DialogFragment} instead.</em>
     *
     * <p>If you use {@link #showDialog(int)}, the activity will call through to
     * this method the first time, and hang onto it thereafter.  Any dialog
     * that is created by this method will automatically be saved and restored
     * for you, including whether it is showing.
     *
     * <p>If you would like the activity to manage saving and restoring dialogs
     * for you, you should override this method and handle any ids that are
     * passed to {@link #showDialog}.
     *
     * <p>If you would like an opportunity to prepare your dialog before it is shown,
     * override {@link #onPrepareDialog(int, Dialog, Bundle)}.
     *
     * @param id   The id of the dialog.
     * @param args The dialog arguments provided to {@link #showDialog(int, Bundle)}.
     * @return The dialog.  If you return null, the dialog will not be created.
     * @see #onPrepareDialog(int, Dialog, Bundle)
     * @see #showDialog(int, Bundle)
     * @see #dismissDialog(int)
     * @see #removeDialog(int)
     * @deprecated Use the new {@link DialogFragment} class with
     * {@link FragmentManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @Nullable
    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args) {
        return super.onCreateDialog(id, args);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Handle onNewIntent() to inform the fragment manager that the
     * state is not saved.  If you are handling new intents and may be
     * making changes to the fragment state, you want to be sure to call
     * through to the super-class here first.  Otherwise, if your state
     * is saved but the activity is not stopped, you could get an
     * onNewIntent() call which happens before onResume() and trying to
     * perform fragment operations at that point will throw IllegalStateException
     * because the fragment manager thinks the state is still saved.
     */
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    /**
     * @deprecated Old no-arguments version of
     * {@link #onPrepareDialog(int, Dialog, Bundle)}.
     */
    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }

    /**
     * Provides an opportunity to prepare a managed dialog before it is being
     * shown.  The default implementation calls through to
     * {@link #onPrepareDialog(int, Dialog)} for compatibility.
     *
     * <p>
     * Override this if you need to update a managed dialog based on the state
     * of the application each time it is shown. For example, a time picker
     * dialog might want to be updated with the current time. You should call
     * through to the superclass's implementation. The default implementation
     * will set this Activity as the owner activity on the Dialog.
     *
     * @param id     The id of the managed dialog.
     * @param dialog The dialog.
     * @param args   The dialog arguments provided to {@link #showDialog(int, Bundle)}.
     * @see #onCreateDialog(int, Bundle)
     * @see #showDialog(int)
     * @see #dismissDialog(int)
     * @see #removeDialog(int)
     * @deprecated Use the new {@link DialogFragment} class with
     * {@link FragmentManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog, final Bundle args) {
        super.onPrepareDialog(id, dialog, args);
    }

    /**
     * @hide
     */
    @Override
    protected boolean onPrepareOptionsPanel(final View view, final Menu menu) {
        return super.onPrepareOptionsPanel(view, menu);
    }

    /**
     * Called after {@link #onStop} when the current activity is being
     * re-displayed to the user (the user has navigated back to it).  It will
     * be followed by {@link #onStart} and then {@link #onResume}.
     *
     * <p>For activities that are using raw {@link Cursor} objects (instead of
     * creating them through
     * {@link #managedQuery(Uri, String[], String, String[], String)},
     * this is usually the place
     * where the cursor should be requeried (because you had deactivated it in
     * {@link #onStop}.
     *
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onStop
     * @see #onStart
     * @see #onResume
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * This method is called after {@link #onStart} when the activity is
     * being re-initialized from a previously saved state, given here in
     * <var>savedInstanceState</var>.  Most implementations will simply use {@link #onCreate}
     * to restore their state, but it is sometimes convenient to do it here
     * after all of the initialization has been done or to allow subclasses to
     * decide whether to use your default implementation.  The default
     * implementation of this method performs a restore of any view state that
     * had previously been frozen by {@link #onSaveInstanceState}.
     *
     * <p>This method is called between {@link #onStart} and
     * {@link #onPostCreate}.
     *
     * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}.
     * @see #onCreate
     * @see #onPostCreate
     * @see #onResume
     * @see #onSaveInstanceState
     */
    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * This is the fragment-orientated version of {@link #onResume()} that you
     * can override to perform operations in the Activity at the same point
     * where its fragments are resumed.  Be sure to always call through to
     * the super-class.
     */
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onTitleChanged(final CharSequence title, final int color) {
        super.onTitleChanged(title, color);
    }

    /**
     * Called as part of the activity lifecycle when an activity is about to go
     * into the background as the result of user choice.  For example, when the
     * user presses the Home key, {@link #onUserLeaveHint} will be called, but
     * when an incoming phone call causes the in-call Activity to be automatically
     * brought to the foreground, {@link #onUserLeaveHint} will not be called on
     * the activity being interrupted.  In cases when it is invoked, this method
     * is called right before the activity's {@link #onPause} callback.
     *
     * <p>This callback and {@link #onUserInteraction} are intended to help
     * activities manage status bar notifications intelligently; specifically,
     * for helping activities determine the proper time to cancel a notfication.
     *
     * @see #onUserInteraction()
     */
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }
}
