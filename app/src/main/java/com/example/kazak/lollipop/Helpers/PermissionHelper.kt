package com.example.kazak.lollipop.Helpers

import android.Manifest
import androidx.core.app.ActivityCompat
import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import com.example.kazak.lollipop.Helpers.Constants.Companion.ALL_PERMISSION_CODE
import com.example.kazak.lollipop.R


class PermissionHelper(activity: Activity) {
    private var activity = activity
    init {
        this.activity = activity
    }

    fun requestAllPermission(all_perms: Array<String>){
        if (shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.READ_PHONE_STATE ) ||
                shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.CAMERA ) ||
                shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE )){
            Toast.makeText(activity, "Application needs your permission",
                    Toast.LENGTH_LONG).show()
        }
        requestPermissions(activity,
                all_perms, ALL_PERMISSION_CODE)
    }

    fun requestPhotoPermission(){
        if (shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA) ||
                shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(activity, "Application needs your permission",
                    Toast.LENGTH_LONG).show()
        }
        requestAllPermission(arrayOf(Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE))
    }
}