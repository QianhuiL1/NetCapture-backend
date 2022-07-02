import json
import requests
import sys
import io
import config.DBConfig as DB
import ORM.EpidemicEventORM as ORM
from selenium import webdriver
from selenium.webdriver.common.by import By

session = DB.session
EpidemicEvent_table = ORM.EpidemicEvent_table

class EpidemicEvent:
    eventDescription  = ""
    eventTime = ""
    eventUrl = ""
    def __init__(self):
        self.eventDescription = ""
        self.eventTime = ""
        self.eventUrl = ""

def saveEpidemicEventsIntoDB(jsonData):
    session.add(EpidemicEvent_table(eventDescription=EE.eventDescription, eventTime=EE.eventTime, eventUrl=EE.eventUrl))
    session.commit()
    session.close()
    print("数据持久化更新已执行")

def getData(Url, header):
    try:
        r = requests.get(url=Url, headers=header)
        r.encoding = r.apparent_encoding
        status = r.status_code
        # 将原始数据类型转换为json类型，方便处理
        data_json = json.loads(r.text)
        print("网页响应状态码: {}".format(status))
        return data_json
    except:
        print("爬取失败")

if __name__ == "__main__":
    sys.stdout = io.TextIOWrapper(sys.stdout.buffer,encoding="utf8")
    # 访问百度地图慧眼人员流动热力图
    url = "http://huiyan.baidu.com/migration/cityrank.jsonpt=city&id=441200&type=move_in&callback=jsonp_1656639076123_4665368&date=20220629"
    # 设置请求头，伪装为浏览器
    headers = {
        'User-Agent': 'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Mobile Safari/537.36 Edg/103.0.1264.37'

    }

    datas = getData(url, headers)
    print(datas)
    # options = webdriver.ChromeOptions()
    # options.add_argument('headless')
    # web = webdriver.Chrome(options=options)
    # web.get("http://huiyan.baidu.com/migration/cityrank.jsonp?dt=country&type=move_in")
    # s = web.find_element(By.TAG_NAME,"pre")

    #saveEpidemicEventsIntoDB(datas)
