# EmailCheck

#### 介绍
改项目展示一个html，输入正确的邮箱地址，点击获取验证码，即可向此邮箱发送验证，填写验证码可以判断是否验证成功。
project contributor -- Jin


# 一、更新

## 1、验证码随机

```tcl
问题一：
由于验证码是用static创建的，不会刷新，因此需要将其修改（已解决）
1、首先，可以将相关的bean，搞成非单例模式，scope="prototype"
2、然后，想办法将此变量让其他类访问到
问题二：
没有将email和验证码绑定，即只适用于一次一个人使用，多人同时使用不行
```

##2、大概页面视图
![输入图片说明](src/main/resources/static/img/yuanshen-3.0.png)

```tcl
如上图所示，邮箱验证大致样式，输入邮箱地址，获取验证码，点击验证可以判断是否验证成功...
```
