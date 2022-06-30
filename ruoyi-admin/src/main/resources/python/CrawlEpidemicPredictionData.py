import json
import requests
import sys
import io
import config.DBConfig as DB
import ORM.EpidemicPredictionDataORM as ORM

session = DB.session
EpidemicPrediction_table = ORM.EpidemicPrediction_table

class EpidemicPredictionData:
    date = ""
    new_daily_data = ""
    new_daily_high = ""
    new_daily_low = ""
    name = ""
    def __init__(self):
        self.date = ""
        self.new_daily_data = ""
        self.new_daily_high = ""
        self.new_daily_low = ""
        self.name = ""

def saveEpidemicDataIntoDB(jsonData):
    for provinceAllData in jsonData["data"]:
        for provinceDayData in provinceAllData:
            epd = EpidemicPredictionData()
            epd.name = provinceDayData["name"]
            epd.date = provinceDayData["date"]
            epd.new_daily_data = provinceDayData["new_daily_data"]
            epd.new_daily_high = provinceDayData["new_daily_high"]
            epd.new_daily_low = provinceDayData["new_daily_low"]
            session.add(EpidemicPrediction_table(name=epd.name, date=epd.date, new_daily_high=epd.new_daily_high, new_daily_low=epd.new_daily_low, new_daily_data=epd.new_daily_data))
    session.commit()
    session.close()
    print("数据持久化更新已执行")

def getDataByPost(Url, header,postData):
    try:
        r = requests.post(url=Url, headers=header,data=postData)
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
    # 访问兰州大学疫情预测平台
    url = "http://120.55.241.242:8090/predictData/echartsData/lineData"
    # 设置请求头，伪装为浏览器
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36'
    }
    # 设置post请求数据
    post_data = {
        'mapName': 'china'
    }

    datas = getDataByPost(url, headers, post_data)
    saveEpidemicDataIntoDB(datas)

