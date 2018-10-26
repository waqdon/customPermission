package com.qdwang.permission;

import android.content.DialogInterface;
import android.content.Intent;

import com.qdwang.permissionlib.PermissionManager;
import com.qdwang.permissionlib.dialog.DialogAppSettings;

import java.util.List;

/**
 * author: create by qdwang
 * date: 2018/10/26 11:21
 * described：
 */
public class PermissionActivity extends BaseActivity {

    @Override
    public void onPermissionDeined(int requestCode, List<String> permissionDenieds) {
        //检查用户是否拒绝了权限，并且点击了“不在询问”
        if(PermissionManager.somePermissionPermanentlyDeined(this, permissionDenieds)){
            new DialogAppSettings.Builder(this)
                    .setListener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).build().show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //从设置界面返回
    }
}
