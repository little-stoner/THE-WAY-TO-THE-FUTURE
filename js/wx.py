import requests


def fetch_user_info():

    url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx731dcf0e41351545&redirect_uri=http%3A%2F%2Fwww.pmtalk.club&&response_type=code&scope=snsapi_userinfo&state=9527#wechat_redirect'
    resp = requests.get(url)
    print(resp)


if __name__ == '__main__':
    fetch_user_info()
