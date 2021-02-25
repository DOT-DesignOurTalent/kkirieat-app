package com.dot.jyp.register

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.dot.jyp.R
import com.dot.jyp.databinding.ActivityLoginBinding
import com.dot.jyp.databinding.ActivityRegisterBinding
import com.dot.jyp.login.LoginActivity
import com.dot.jyp.server.RetrofitSingleTon
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //--이메일-----------------------------------------------------------------------------------
        // 이메일 유효성 검사
       binding.edittextRegisterEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun afterTextChanged(p0: Editable?) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0.toString()).matches()){
                    binding.textRegisterEmailWrong.text = "이메일 형식을 확인해주세요."
                    binding.edittextRegisterEmail.setBackgroundResource(R.drawable.edit_error)
                }else{
                    binding.textRegisterEmailWrong.text = ""
                    binding.edittextRegisterEmail.setBackgroundResource(R.drawable.edit_activate)
                }
            }
        })

        // 이메일 중복 체크 버튼 액션
        binding.btnRegisterEmailCheck.setOnClickListener {

        }

        //--비밀번호---------------------------------------------------------------------------------
        // 비밀번호 유효성 검사
        binding.edittextRegisterPwd.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun afterTextChanged(p0: Editable?) {
                // 숫자, 문자, 특수문자 포함 8~20자리
                if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&]).{8,20}.\$", p0.toString())){
                    binding.edittextRegisterPwd.setBackgroundResource(R.drawable.edit_alert)
                    binding.textRegisterPwdWrong.text="숫자, 문자, 특수 문자 포함 8자리 이상인지 확인해주세요."
                    binding.textRegisterPwdWrong.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAlert))
                }else{
                    binding.edittextRegisterPwd.setBackgroundResource(R.drawable.edit_activate)
                    binding.textRegisterPwdWrong.text=""
                    binding.textRegisterPwdWrong.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorError))
                }
            }

        })

        // 비밀번호 확인 검사
        binding.edittextRegisterPwd2.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!binding.edittextRegisterPwd.text.toString().equals(binding.edittextRegisterPwd2.text.toString())){
                    binding.edittextRegisterPwd.setBackgroundResource(R.drawable.edit_error)
                    binding.edittextRegisterPwd2.setBackgroundResource(R.drawable.edit_error)
                    binding.textRegisterPwdWrong.text = "비밀번호를 확인해주세요."
                    binding.textRegisterEmailWrong.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorError))
                }else{
                    binding.edittextRegisterPwd.setBackgroundResource(R.drawable.edit_check)
                    binding.edittextRegisterPwd2.setBackgroundResource(R.drawable.edit_check)
                    binding.textRegisterPwdWrong.text = "사용 가능한 비밀번호입니다."
                    binding.textRegisterPwdWrong.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorCheck))
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

        // 임시 회원가입 : register -> login
        binding.btnRegister.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }

    }


}