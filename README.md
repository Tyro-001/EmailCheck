# EmailCheck

#### 介绍
改项目展示一个html，输入正确的邮箱地址，点击获取验证码，即可向此邮箱发送验证，填写验证码可以判断是否验证成功。

#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)

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