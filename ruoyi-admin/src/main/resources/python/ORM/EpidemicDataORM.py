from importlib.resources import Package


Package
from sqlalchemy import create_engine, Column, Integer, String
import config.DBConfig as DB

Base = DB.Base

class TodayEpidemic_table(Base):
    __tablename__ = 'todayEpidemic_table'  # 表名
    country = Column(String(25))
    province = Column(String(10))
    confirm = Column(Integer)
    storeConfirm = Column(Integer)
    heal = Column(Integer)
    dead = Column(Integer)
    input = Column(Integer)
    lastUpdateTime = Column(String)
    area = Column(String(25))
    incrNoSymptom = Column(Integer)
    todayEpidemicID = Column(Integer, primary_key=True, autoincrement=True)

class TotalEpidemic_table(Base):
    __tablename__ = 'totalEpidemic_table'  # 表名
    country = Column(String(25))
    province = Column(String(10))
    confirm = Column(Integer)
    input = Column(Integer)
    heal = Column(Integer)
    dead = Column(Integer)
    lastUpdateTime = Column(String)
    area = Column(String(25))
    noSymptom = Column(Integer)
    totalEpidemicID = Column(Integer, primary_key=True, autoincrement=True)