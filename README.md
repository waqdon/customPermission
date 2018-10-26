# customPermission
跟据西门老师的思想封装的一款android动态权限请求框架

使用方式
第一步：
Baseactivity implements IPermissionCallback{

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //收到权限拒绝或者通过的结果回调
        PermissionManager.onRequestPermissionResult(requestCode, permissions, grantResults, this);
    }
    
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
    public void onPermissionGranted(int requestCode, List<String> granted) {
        //权限通过回调
    }
}

第二步：
通过注解请求码区分对应的回调结果

MainActivity extends Baseactivity｛

    @IPermission(REQUESTCODECAMERA)
    private void requestCamera(){
        if(PermissionManager.hasPermission(this, Manifest.permission.CAMERA)){
            //权限通过
            Toast.makeText(this, "相机权限通过", Toast.LENGTH_SHORT).show();
        }else {
            PermissionManager.requestPermissions(this, "请求相机权限", REQUESTCODECAMERA, Manifest.permission.CAMERA);
        }
    }
   ｝
