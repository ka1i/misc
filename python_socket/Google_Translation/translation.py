#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
Time    :2019/3/14 下午 7:54
Auther  :Mardan
Web     :https://github.com/ka1i
Version :python 3.7
'''

import os
import re
import sys
import time
import timeit
import zipfile
import requests
import configparser
from bs4 import BeautifulSoup
from googletrans import Translator



class GoogleTranslate:
    def __init__(self, src='en', target='zh-cn'):
        self.translator = Translator(service_urls=['translate.google.cn'])
        self.src = src
        self.trg = target

    def translate(self, sentence, max_try=9, count=0):
        # text is string
        if count >= 3:
            return ''
        try:
            translation = self.translator.translate(sentence, dest='zh-cn', src='en')
        except:
            # time.sleep(5)
            translation = self.translate(sentence, time_start , max_try, count=count + 1)
        finally:
            time.sleep(0.1)

        return translation

    def translate_batch(self, sentences, time_start, max_try=10, count=0):
        # sentences is list
        results = []
        if count >= max_try:
            return ['' for _ in range(len(sentences))]
        try:
            translations = self.translator.translate(sentences, dest=self.trg, src=self.src)
            for translation in translations:
                try:
                    translation = translation.text
                except:
                    print('translate error...')
                    translation = ''
                results.append(translation)
        except:
            time.sleep(2.5)
            print('\n\033[1A\033[K' + '翻译重试次数' + str(count + 1)+ ' 耗费时间: ' + str(time_start) + "--->" + str(time.asctime(time.localtime(time.time()))) + ' 秒\033[0m' , end='')
            if count == 5:
                sys.exit(0)
            results = self.translate_batch(sentences, time_start=time.asctime(time.localtime(time.time())), max_try=10, count=count + 1)
        finally:
            # time.sleep(0.5)
            pass

        return results


def document_format():
    document = open('./document/tedx.srt','a')
    document.write("srt")
    document.close()


if __name__ == '__main__':
    start_index = 0
    cwe_config = configparser.ConfigParser()
    time_start = time.time()
    print("正在查询最新版本存档")
    official_cwe_xmlfile = prepare_cwec_file()
    if not os.path.exists('./document'):
        os.mkdir('./document')

    cwe_config.read('cwe.config', encoding='utf8')
    start_index = cwe_config.getint("base", "index_ID")
    w_id = cwe_config.getint("base", "id")

    print("开始进行翻译并写入文档")
    if start_index == 0:
        os.mknod('./document/CWE翻译计划.md')
        write_header()
    Analysis_xml(official_cwe_xmlfile, start_index, cwe_config)
    print("翻译时间: ", str(time.time() - time_start) + "秒")
