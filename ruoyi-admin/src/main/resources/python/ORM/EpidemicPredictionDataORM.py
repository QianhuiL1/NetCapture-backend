from importlib.resources import Package


Package
from sqlalchemy import create_engine, Column, Integer, String
import config.DBConfig as DB

Base = DB.Base

class EpidemicPrediction_table(Base):
    __tablename__ = 'epidemicPrediction_table'  # 表名
    date = Column(String)
    new_daily_data = Column(Integer)
    new_daily_high = Column(Integer)
    new_daily_low = Column(Integer)
    name = Column(String(10))
    id = Column(Integer, primary_key=True, autoincrement=True)