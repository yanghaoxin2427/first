package com.bawei.viewmodel;

import java.io.Serializable;

/**
 * @ProjectName: ViewModel
 * @Package: com.bawei.viewmodel
 * @ClassName: User
 * @Description: java类作用描述写这里
 * @Author: Y_hoxi
 * @CreateDate: 2021-11-09 13:16
 * @UpdateUser: Y_hoxi
 * @UpdateDate: 2021-11-09 13:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User implements Serializable {
    public int age;
    public String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
