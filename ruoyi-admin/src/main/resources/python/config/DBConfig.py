from importlib.resources import Package
import sqlalchemy


Package
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import *
from sqlalchemy import create_engine


DB_URI = "mysql+pymysql://root:dozen233@122.112.140.161:3306/idfs"
engine = create_engine(DB_URI,echo=False, pool_size=8, pool_recycle=60*30)
Base = declarative_base(engine)  # SQLORM基类
session = Session(engine)  # 构建session对象

