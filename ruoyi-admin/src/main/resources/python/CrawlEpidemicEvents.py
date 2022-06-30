import json
import requests
import sys
import io
import config.DBConfig as DB
import ORM.EpidemicEventORM as ORM
import time

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
    for event in jsonData["data"][0]["resultData"]["tplData"]["result"]["items"]:
        EE = EpidemicEvent()
        EE.eventDescription = event["eventDescription"]
        EE.eventUrl = event["eventUrl"]
        EE.eventTime = time.strftime("%Y-%m-%d %H:%M:%S",time.struct_time(time.localtime(float(event["eventTime"]))))
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
    # 访问百度疫情实时大数据报告
    url = "https://opendata.baidu.com/data/inner?resource_id=28565&query=%E5%9B%BD%E5%86%85%E6%96%B0%E5%9E%8B%E8%82%BA%E7%82%8E%E6%9C%80%E6%96%B0%E5%8A%A8%E6%80%81"
    # 设置请求头，伪装为浏览器
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36'
    }

    datas = getData(url, headers)
    
    # d = time.localtime(float('1656549619'))
    # s = time.asctime(d)
    # print(s)
    saveEpidemicEventsIntoDB(datas)