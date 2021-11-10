package com.bawei.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @ProjectName: ViewModel
 * @Package: com.bawei.viewmodel
 * @ClassName: UserModel
 * @Description: java类作用描述写这里
 * @Author: Y_hoxi
 * @CreateDate: 2021-11-09 13:17
 * @UpdateUser: Y_hoxi
 * @UpdateDate: 2021-11-09 13:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserModel extends ViewModel {
    public final MutableLiveData<User> mUserLiveData = new MutableLiveData<>();

    public UserModel(User user) {
        mUserLiveData.postValue(user);
    }
    public void doSomething(){
        User value = mUserLiveData.getValue();
        if (value!=null){
            value.age++;
            value.name="杨昊鑫";
            mUserLiveData.setValue(value);
        }
    }
}
