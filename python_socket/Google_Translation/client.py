# -*- coding: utf-8 -*-
# @Author: mardan
# @Date:   2019-04-20 10:25:41
# @Last Modified by:   mardan
# @Last Modified time: 2019-04-20 10:55:33


import requests
from bs4 import BeautifulSoup


def GetHtml(url,data):
    headers = {
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/73.0.3683.86 Chrome/73.0.3683.86 Safari/537.36'
    'Accept': '*/*'
    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    }
    try:
        r = requests.get(url, timeout=30)
        r.raise_for_status()
        r.encoding = r.apparent_encoding
        return r.text
    except:
        return "error"


def CleanHtml(html):
    soup = BeautifulSoup(html, "html.parser")
    result = soup
    return(result)

def calc_tk():


if __name__ == '__main__':
    client = 'webapp'
    sl = 'en'
    tl = 'zh-CN'
    tk = calc_tk()

    url = "https://translate.google.cn/translate_a/single?client=webapp&sl=zh-CN&tl=en&hl=en"
    data = 'q=' + "The article, born on June 26, 1984 in Xi'an, Shaanxi Province, is a Chinese actor and director. In 2006, he graduated from the Performance Department of the Central Academy of Drama."
    html = GetHtml(url,data)
    result = CleanHtml(html)
    print(result)
