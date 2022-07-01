from importlib.resources import Package
from pymysql import Timestamp


Package
from sqlalchemy import TIMESTAMP, Column, Integer, String
import config.DBConfig as DB

Base = DB.Base

class EpidemicEvent_table(Base):
    __tablename__ = 'epedemicEvent_table'  # 表名
    eventDescription = Column(String(50))
    eventUrl = Column(String(250))
    eventTime = Column(String)
    eventID = Column(Integer, primary_key=True, autoincrement=True)