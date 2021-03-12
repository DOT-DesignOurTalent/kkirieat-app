package com.dot.jyp.lobby

import android.Manifest
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.dot.jyp.R
import com.dot.jyp.databinding.ActivityLobbyBinding
import com.dot.jyp.game.SelectMenuActivity
import com.google.android.material.snackbar.Snackbar


class LobbyActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLobbyBinding
    private val multiplePermissionsCode = 100
    private val requiredPermissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLobbyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //------ 퍼미션 요청
        requestPermissions()

        //------ back버튼 처리
        binding.imageLobbyBack.setOnClickListener {
            finish()
        }

        //------ 법정생성 클릭
        binding.btnLobbyCreate.setOnClickListener{
            if(checkPermissions())
                showDialog()
        }
    }

    //퍼미션 체크 함수
    fun checkPermissions() : Boolean {
        //------ 권한여부 체크
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ){
            //------ 권한없으면 스낵바 호출 후 false 리턴
            val view = binding.constraintLobbyLayout
            val snackBar = Snackbar.make(
                view,
                "위치 권한이 필요합니다. 확인을 누르시면 설정화면으로 이동합니다.",
                Snackbar.LENGTH_LONG
            )
            snackBar.setAction("확인") {
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }.show()
            return false
        }
        //------ 권한있으면 true리턴
        else
            return true
    }

    //퍼미션 권한 요청 함수
    fun requestPermissions() {
        //------ 거절되었거나 아직 수락하지 않은 권한(퍼미션)을 저장할 문자열 배열 리스트
        var requestPermissionList = ArrayList<String>()

        //------ 필요한 퍼미션들을 하나씩 비교하며 현재 권한을 받았는지 체크
        for(permission in requiredPermissions){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                //만약 권한이 없다면 rejectedPermissionList에 추가
                requestPermissionList.add(permission)
            }
        }

        //------ 요청할 퍼미션이 있다면
        if(requestPermissionList.isNotEmpty()){
            //권한 요청!
            val array = arrayOfNulls<String>(requestPermissionList.size)
            ActivityCompat.requestPermissions(
                this,
                requestPermissionList.toArray(array),
                multiplePermissionsCode
            )
        }
    }

    //법정생성 다이얼로그 생성및 호출 함수
    fun showDialog(){
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.dialog_lobby, null)
        val dialog = Dialog(this)
        dialog.setContentView(view)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        //------ 닫기버튼 클릭 이벤트 추가
        view.findViewById<ImageView>(R.id.image_dialog_lobby_close).setOnClickListener {
            dialog.dismiss()
        }

        //------ 클립보드 버튼 클릭 이벤트 추가
        view.findViewById<ImageView>(R.id.image_lobby_dialog_copy).setOnClickListener {
            val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("code",view.findViewById<TextView>(R.id.text_dialog_lobby_code).text)
            clipboardManager.setPrimaryClip(clipData)

            //------ 복사가 되었다면 토스트메시지 노출
            Toast.makeText(this,"코드가 복사되었습니다.",Toast.LENGTH_SHORT).show()


        }

        //------ 신청완료 버튼 클릭 이벤트 추가
        view.findViewById<Button>(R.id.btn_dialog_lobby_enter).setOnClickListener {
            val intent = Intent(this, SelectMenuActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
    }
}