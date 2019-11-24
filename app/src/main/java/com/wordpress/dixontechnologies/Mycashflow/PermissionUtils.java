package com.wordpress.dixontechnologies.Mycashflow;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;



abstract class PermissionUtils {

        static void requestPermission(AppCompatActivity activity, int request_id,
                                      String permission, boolean finishActivity){

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,  permission)){
                //display dialog
                PermissionUtils.RationaleDialog.newInstance(request_id,
                        finishActivity).show(activity.getSupportFragmentManager(),"dialog");
            } else {
                //permission not granted
                ActivityCompat.requestPermissions(activity, new String[]{permission}, request_id);
            }
        }


        public static boolean isPermissionGranted(String[] grantPermissions, int[] grantResults,
                                                  String permission){
            for (int i = 0; i < grantPermissions.length; i++){
                if (permission.equals(grantPermissions[i])){
                    return grantResults[i] == PackageManager.PERMISSION_GRANTED;
                }
            }
            return false;
        }

        public static class PermissionDeniedDialog extends DialogFragment{
            //display permission denide msg
            public static final String ARG_FINISH_ACTIVITY = "finish";
            private boolean mFinishActivity = false;

            public static PermissionDeniedDialog newInstance(boolean finishActivity){
                Bundle arguments = new Bundle();
                arguments.putBoolean(ARG_FINISH_ACTIVITY, finishActivity);
                PermissionDeniedDialog dailog = new PermissionDeniedDialog();
                dailog.setArguments(arguments);
                return dailog;

            }

            @NonNull
            @Override
            public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
                mFinishActivity = getArguments().getBoolean(ARG_FINISH_ACTIVITY);


                return new AlertDialog.Builder(getActivity()).setMessage("Permission Denied").
                        setPositiveButton("Ok", null).create();
            }

            @Override
            public void onDismiss(DialogInterface dialog) {
                super.onDismiss(dialog);
                if (mFinishActivity){
                    Toast.makeText(getActivity(), "Permission required", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
            }
        }


    public static class RationaleDialog extends DialogFragment {

            private static final String ARGUMENTS_PERMISSION_REQUEST_CODE = "requestCode";
            private static final String ARGS_FINISH_ACTIVITY = "finish";
            private boolean finishActs = false;

        public static RationaleDialog newInstance(int request_id,
                                         boolean finishActivity) {
            Bundle args = new Bundle();
            args.putInt(ARGUMENTS_PERMISSION_REQUEST_CODE, request_id);
            args.putBoolean(ARGS_FINISH_ACTIVITY, finishActivity);
            RationaleDialog dialog = new RationaleDialog();
            dialog.setArguments(args);
            return dialog;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            Bundle arguments = getArguments();
            final int requestCode = arguments.getInt(ARGUMENTS_PERMISSION_REQUEST_CODE);
            finishActs = arguments.getBoolean(ARGS_FINISH_ACTIVITY);
            return new AlertDialog.Builder(getActivity()).setMessage("Access to the location service is required to demonstrate the \\'my location\\' feature, which shows your current location on the map.").
                    setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface,
                                            int i) {
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    requestCode);
                            finishActs = false;
                        }
                    }).setNegativeButton("cancel", null).create();
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            super.onDismiss(dialog);
            if (finishActs){
                Toast.makeText(getActivity(),
                        "Dismiss", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        }
    }



}
