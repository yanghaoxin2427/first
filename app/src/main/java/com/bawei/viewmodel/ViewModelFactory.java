package com.bawei.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @ProjectName: ViewModel
 * @Package: com.bawei.viewmodel
 * @ClassName: ViewModelFactory
 * @Description: java类作用描述写这里
 * @Author: Y_hoxi
 * @CreateDate: 2021-11-09 15:21
 * @UpdateUser: Y_hoxi
 * @UpdateDate: 2021-11-09 15:21
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ViewModelFactory implements ViewModelProvider.Factory {
    private User user;

    public ViewModelFactory(User user) {
        this.user = user;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserModel(user);
    }
}
