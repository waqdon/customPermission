package com.qdwang.permission;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qdwang.permissionlib.IPermissionCallback;
import com.qdwang.permissionlib.PermissionManager;

import java.util.List;

/**
 * author: create by qdwang
 * date: 2018/10/26 11:15
 * described：
 */
public abstract class BaseActivity extends AppCompatActivity implements IPermissionCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPermissionGranted(int requestCode, List<String> granted) {
        //权限通过回调
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.onRequestPermissionResult(requestCode, permissions, grantResults, this);
    }
}
