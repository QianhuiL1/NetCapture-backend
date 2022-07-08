from importlib.resources import Package


Package
from sqlalchemy import create_engine, Column, Integer, String
import config.DBConfig as DB

Base = DB.Base

class RiskArea_table(Base):
    __tablename__ = 'riskArea_table'  # 表名
    area = Column(String(50))
    lastUpdateTime = Column(String)
    address = Column(String(100))
    riskLevel = Column(String(1))
    riskAreaId = Column(Integer, primary_key=True, autoincrement=True)