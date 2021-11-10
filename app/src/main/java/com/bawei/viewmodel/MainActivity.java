package com.bawei.viewmodel;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bawei.viewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private UserModel userModel;
    private SharedPreferences user;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setUser(new User(11, "((("));
        user = getSharedPreferences("user", MODE_PRIVATE);
//        if (savedInstanceState!=null){
//            text.setText(savedInstanceState.getString("age"));
//        }

        //构建ViewModel实例

        userModel = ViewModelProviders.of(this,new ViewModelFactory(new User(user.getInt("age", 0),"YHX"))).get(UserModel.class);

        userModel.mUserLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                activityMainBinding.text.setText(user.toString());
            }
        });

    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userModel.doSomething();
//                text.setText("&&&&&&&&&");
            }

        });
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("age", "&&&&&&&&&");
//    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor edit = user.edit();
        edit.putInt("age", userModel.mUserLiveData.getValue().age).commit();
    }
}