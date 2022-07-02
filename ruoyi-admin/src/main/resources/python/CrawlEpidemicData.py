from asyncio.windows_events import NULL
import json
from xml.dom.pulldom import PROCESSING_INSTRUCTION
import requests
import pandas as pd
import sys
import io
import config.DBConfig as DB
import ORM.EpidemicDataORM as ORM

session = DB.session
TodayEpidemic_table = ORM.TodayEpidemic_table
TotalEpidemic_table = ORM.TotalEpidemic_table

def getEpidemicData(dict,isChild):
    #初始化数据
    data = EpidemicData()
    #data.Children = EpidemicData()
    data.total = TotalEpidemic()
    data.today = TodayEpidemic()
    #添加数据
    data.today = getToday(dict["today"])
    data.total = getTotal(dict["total"], isChild)
    data.name = dict["name"]
    data.lastUpdateTime = dict["lastUpdateTime"]
    #递归入口
    if dict["children"] != []:
        for i in dict["children"]:
            data.Children.append(getEpidemicData(i,1))
    #递归出口
    return data


def getEpidemicDataList(dict):
    dataArr = []
    for i in dict:
        dataArr.append(getEpidemicData(i,0))
    return dataArr

def getCountryDataList(data_China):
    countryDataList = []
    countryData = EpidemicData()
    countryTodayData = TodayEpidemic()
    countryTodayData.confirm = data_China["chinaTotal"]["today"]["confirm"]
    countryTodayData.heal = data_China["chinaTotal"]["today"]["heal"]
    countryTodayData.dead = data_China["chinaTotal"]["today"]["dead"]
    countryTodayData.storeConfirm = data_China["chinaTotal"]["today"]["storeConfirm"]
    countryTodayData.input = data_China["chinaTotal"]["today"]["input"]
    countryTodayData.incrNoSymptom = data_China["chinaTotal"]["extData"]["incrNoSymptom"]
    countryTodayData.noSymptom = data_China["chinaTotal"]["extData"]["noSymptom"]
    countryData.today = countryTodayData
    countryTotalData = TotalEpidemic()
    countryTotalData.confirm = data_China["chinaTotal"]["total"]["confirm"]
    countryTotalData.heal = data_China["chinaTotal"]["total"]["heal"]
    countryTotalData.dead = data_China["chinaTotal"]["total"]["dead"]
    countryTotalData.input = data_China["chinaTotal"]["total"]["input"]
    countryData.total = countryTotalData
    countryData.name = "中国"
    countryData.lastUpdateTime = data_China["lastUpdateTime"]
    countryDataList.append(countryData)
    return countryDataList


def saveDataToDB(data_province, data_China):
    dataObjectList = getEpidemicDataList(data_province)
    countryDataObject = getCountryDataList(data_China)[0]
    # session.execute("delete from todayEpidemic_table")
    # session.execute("delete from totalEpidemic_table")
    session.add(TodayEpidemic_table(country=countryDataObject.name,confirm=countryDataObject.today.confirm,heal=countryDataObject.today.heal,dead=countryDataObject.today.dead,storeConfirm=countryDataObject.today.storeConfirm,input=countryDataObject.today.input,lastUpdateTime=countryDataObject.lastUpdateTime,incrNoSymptom=countryDataObject.today.incrNoSymptom,noSymptom=countryDataObject.today.noSymptom))
    session.add(TotalEpidemic_table(country=countryDataObject.name,confirm=countryDataObject.total.confirm,heal=countryDataObject.total.heal,dead=countryDataObject.total.dead,input=countryDataObject.total.input,lastUpdateTime=countryDataObject.lastUpdateTime))
    # for dataObjParent in dataObjectList:
    #     session.add(TodayEpidemic_table(country = "中国",province=dataObjParent.name,confirm=dataObjParent.today.confirm,storeConfirm=dataObjParent.today.storeConfirm,heal=dataObjParent.today.heal,dead=dataObjParent.today.dead,lastUpdateTime=dataObjParent.lastUpdateTime))
    #     session.add(TotalEpidemic_table(country = "中国",province=dataObjParent.name,confirm=dataObjParent.total.confirm,input=dataObjParent.total.input,heal=dataObjParent.total.heal,dead=dataObjParent.total.dead,lastUpdateTime=dataObjParent.lastUpdateTime))
    #     for dataObjChildren in dataObjParent.Children:
    #         session.add(TotalEpidemic_table(country = "中国",province=dataObjParent.name,area=dataObjChildren.name,confirm=dataObjChildren.total.confirm,input=None,heal=dataObjChildren.total.heal,dead=dataObjChildren.total.dead,lastUpdateTime=dataObjChildren.lastUpdateTime))
    #         session.add(TodayEpidemic_table(country = "中国",province=dataObjParent.name,area=dataObjChildren.name,confirm=dataObjChildren.today.confirm,storeConfirm=dataObjChildren.today.storeConfirm,heal=dataObjChildren.today.heal,dead=dataObjChildren.today.dead,lastUpdateTime=dataObjChildren.lastUpdateTime))
    session.commit()
    session.close()
    print("数据持久化更新已执行")


def get_html(Url, header):
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


# 将提取34个省数据的方法封装为函数
def get_data(data, info_list):
    # 直接提取["id","name","lastUpdateTime"] 的数据
    info = pd.DataFrame(data)[info_list]

    # 获取today的数据
    today_data = pd.DataFrame([province["today"] for province in data])
    # 修改列名
    today_data.columns = ["today_" + i for i in today_data.columns]

    # 获取total的数据
    total_data = pd.DataFrame([province["total"] for province in data])
    # 修改列名
    total_data.columns = ["total_" + i for i in total_data.columns]

    return pd.concat([info, today_data, total_data], axis=1)


def getToday(dict):
    today = TodayEpidemic()
    today.confirm = dict["confirm"]
    today.dead = dict["dead"]
    today.heal = dict["heal"]
    today.storeConfirm = dict["storeConfirm"]
    return today

def getTotal(dict,isChild):
    total = TotalEpidemic()
    total.confirm = dict["confirm"]
    total.dead = dict["dead"]
    total.heal = dict["heal"]
    if isChild == 0:
        total.input = dict["input"]
    return total



class Children:
    pass

class today:
    pass

class total:
    pass

class EpidemicData:
    today = today()
    total = total()
    Children = []
    name = ""
    lastUpdateTime = ""
    def __init__(self):
        self.today = TodayEpidemic()
        self.total = TotalEpidemic()
        self.Children = []
        self.name = ""
        self.lastUpdateTime = ""

class TodayEpidemic:
    confirm = ""
    storeConfirm = ""
    heal = ""
    dead = ""
    storeConfirm = ""
    input = ""
    incrNoSymptom = ""
    noSymptom = ""
    def __init__(self):
        self.confirm = ""
        self.storeConfirm = ""
        self.heal = ""
        self.dead = ""
        self.storeConfirm = ""
        self.input = ""

class TotalEpidemic:
    confirm = ""
    heal = ""
    dead = ""
    input = ""
    def __init__(self):
        self.confirm = ""
        self.input = ""
        self.heal = ""
        self.dead = ""

if __name__ == "__main__":
    sys.stdout = io.TextIOWrapper(sys.stdout.buffer,encoding="utf8")
    # 访问网易实时疫情播报平台网址
    url = "https://c.m.163.com/ug/api/wuhan/app/data/list-total"
    # 设置请求头，伪装为浏览器
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) \
        AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36'
    }

    """爬取中国各省的疫情数据"""
    # 1.获取数据（此时的数据未经处理）
    datas = get_html(url, headers)

    # 2.找到储存中国34省的数据所在
    data_China = datas["data"]
    data_province = datas["data"]["areaTree"][2]["children"]
    # 3.提取34个省数据
    #all_data = get_data(data_province, ["id", "name", "lastUpdateTime"])

    # 4.持久化保存数据
    #save_data(all_data, "today_province")

    saveDataToDB(data_province,data_China)
