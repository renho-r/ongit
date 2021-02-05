# 四种授权模式

## 密码模式

```shell
POST http://localhost:8000/oauth/token?grant_type=password&client_id=r&client_secret=rr&username=renho&password=123456&scope=all
```

适用：为遗留系统设计、支持refresh token

应用直接都是受信任的，都是由一家公司开发的

## 隐式授权

```shell
浏览器访问 http://localhost:8000/oauth/authorize?response_type=token&client_id=r&redirect_uri=http://localhost:7010/uaa/login
跳转到 http://localhost:8000/login
输入用户名、密码
跳转到 http://localhost:7010/uaa/login#access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDc5NzkxNTMsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiKiJdLCJqdGkiOiJiMWQzNjdkYS05NGZiLTQ0MTQtODA0Ny1iNTkyNjU5NDY3OWIiLCJjbGllbnRfaWQiOiJyIiwic2NvcGUiOlsiYWxsIl19.6nOalqjZwLpscSrPC5MDaSf88NIbbSdtSBcZff6C3p0&token_type=bearer&expires_in=42736&scope=all&jti=b1d367da-94fb-4414-8047-b5926594679b
```

适用：为web浏览器应用设计、不支持refresh token

用在移动app或者web app(这些app是在用户的设备上的，如在手机上调起微信来进行认证授权)

## 授权码模式

```shell
浏览器访问 http://localhost:8000/oauth/authorize?response_type=code&client_id=r&redirect_uri=http://localhost:7010/uaa/login
跳转到 http://localhost:8000/login
输入用户名、密码
跳转到 http://localhost:7010/uaa/login?code=fwZSpI
7010应用通过
POST http://localhost:8000/oauth/token?grant_type=authorization_code&client_id=r&client_secret=rr&redirect_uri=http://localhost:7010/uaa/login&code=RDYtbW
获取token
```

适用：正宗方式、支持refresh token

用在服务端应用之间

## 客户端

```shell
http://localhost:8000/oauth/token?client_id=r&client_secret=rr&grant_type=client_credentials
```

适用：为后台api服务消费者设计、不支持refresh token

用在应用API访问