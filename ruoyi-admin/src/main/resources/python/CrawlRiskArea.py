from bs4 import BeautifulSoup
import requests
import sys
import io
import config.DBConfig as DB
import ORM.RiskAreaORM as ORM

session = DB.session
RiskArea_table = ORM.RiskArea_table


class RiskArea:
    area = ""
    lastUpdateTime = ""
    address = ""
    riskLevel = ""
    def __init__(self):
        self.area = ""
        self.lastUpdateTime = ""
        self.address = ""
        self.riskLevel = ""

def getHtml(Url, header):
    try:
        r = requests.get(url=Url, headers=header)
        r.encoding = r.apparent_encoding
        status = r.status_code
        print("网页响应状态码: {}".format(status))
        return r.text
    except:
        print("爬取失败")

def getRiskAreaList(datas):
    soup = BeautifulSoup(datas,'html.parser')
    riskAreaList = []
    riskArea = RiskArea()
    lastUpdateTime = soup.select(".time")[0].get_text()[2:]
    
    #print("高风险地区")
    for cityInfo in soup.select('.height.info-item .info-list'):
        # print(cityInfo.select(".shi p")[0].get_text().replace('\n',''))
        for areaInfo in cityInfo.select("ul span"):
            # print(areaInfo.get_text())
            riskArea.area = cityInfo.select(".shi p")[0].get_text().replace('\n','')
            riskArea.riskLevel = '2'
            riskArea.lastUpdateTime = lastUpdateTime
            riskArea.address = areaInfo.get_text()
            riskAreaList.append(riskArea)
            riskArea = RiskArea()
        # print("------")
    #print("中风险地区")
    for cityInfo in soup.select('.middle.info-item .info-list'):
        # print(cityInfo.select(".shi p")[0].get_text().replace('\n',''))
        for areaInfo in cityInfo.select("ul span"):
            # print(areaInfo.get_text())
            riskArea.area = cityInfo.select(".shi p")[0].get_text().replace('\n','')
            riskArea.riskLevel = '1'
            riskArea.lastUpdateTime = lastUpdateTime
            riskArea.address = areaInfo.get_text()
            riskAreaList.append(riskArea)
            riskArea = RiskArea()
        # print("------")
    return riskAreaList

def saveRiskAreaIntoDB(datas):
    riskAreaList = getRiskAreaList(datas)
    for riskArea in riskAreaList:
        session.add(RiskArea_table(area=riskArea.area,address=riskArea.address,lastUpdateTime=riskArea.lastUpdateTime,riskLevel=riskArea.riskLevel))
    session.commit()
    session.close()
    print("数据持久化更新已执行")

    # #print("今日调高")
    # for cityInfo in soup.select('.middle.info-item .info-list'):
    #     print(cityInfo.select(".shi p")[0].get_text().replace('\n',''))
    #     for areaInfo in cityInfo.select("ul span"):
    #         print(areaInfo.get_text())
    #     print("------")
    # #print("今日调中")
    # for cityInfo in soup.select('.middle.info-item .info-list'):
    #     print(cityInfo.select(".shi p")[0].get_text().replace('\n',''))
    #     for areaInfo in cityInfo.select("ul span"):
    #         print(areaInfo.get_text())
    #     print("------")
    # #print("今日调低")
    # for cityInfo in soup.select('.middle.info-item .info-list'):
    #     print(cityInfo.select(".shi p")[0].get_text().replace('\n',''))
    #     for areaInfo in cityInfo.select("ul span"):
    #         print(areaInfo.get_text())
    #     print("------")


if __name__ == "__main__":
    sys.stdout = io.TextIOWrapper(sys.stdout.buffer,encoding="utf8")
    # 访问本地宝风险地区数据
    url = "http://m.su.bendibao.com/news/gelizhengce/fengxianmingdan.php"
    # 设置请求头，伪装为浏览器
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36'
    }

    datas = getHtml(url, headers)

    saveRiskAreaIntoDB(datas)
