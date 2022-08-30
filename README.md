# EmailCheck

#### 介绍
改项目展示一个html，输入正确的邮箱地址，点击获取验证码，即可向此邮箱发送验证，填写验证码可以判断是否验证成功。
project contributor -- Jin


#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


# 一、更新

## 1、验证码随机

```tcl
由于验证码是用static创建的，不会刷新，因此需要将其修改
1、首先，可以将相关的bean，搞成非单例模式，scope="prototype"
2、然后，想办法将此变量让其他类访问到
```

##2、大概页面视图
![输入图片说明](src/main/resources/static/img/yuanshen-3.0.png)

```tcl
如上图所示，邮箱验证大致样式，输入邮箱地址，获取验证码，点击验证可以判断是否验证成功...
```