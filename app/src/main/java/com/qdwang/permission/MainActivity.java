package com.qdwang.permission;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qdwang.permissionlib.PermissionManager;
import com.qdwang.permissionlib.annotation.IPermission;

import java.security.Permission;

public class MainActivity extends PermissionActivity {

    private static final int REQUESTCODECAMERA = 100;
    private static final int REQUESTCODECONTACTS = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {
        requestContacts();
    }

    public void btn2(View view) {
        Toast.makeText(this, "按钮2", Toast.LENGTH_SHORT).show();
    }

    public void btn0(View view) {
        requestCamera();
    }

    @IPermission(REQUESTCODECAMERA)
    private void requestCamera(){
        if(PermissionManager.hasPermission(this, Manifest.permission.CAMERA)){
            //权限通过
            Toast.makeText(this, "相机权限通过", Toast.LENGTH_SHORT).show();
        }else {
            PermissionManager.requestPermissions(this, "请求相机权限", REQUESTCODECAMERA, Manifest.permission.CAMERA);
        }
    }

    @IPermission(REQUESTCODECONTACTS)
    private void requestContacts(){
        if(PermissionManager.hasPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS)){
            //权限通过
            Toast.makeText(this, "读取sd卡、写入sd卡、读取联系人", Toast.LENGTH_SHORT).show();
        }else {
            PermissionManager.requestPermissions(this, "请求读取sd卡、写入sd卡、读取联系人权限", REQUESTCODECONTACTS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS);
        }
    }
}
