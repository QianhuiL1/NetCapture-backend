import numpy as np
import matplotlib
import matplotlib.pyplot as plt
#import pandas as pd
import pylab


# 计算SEIR
def calc(T):
    global h
    global a
    global b

    for idx in range(0, len(T) - 1):
        S.append(S[idx] - h * S[idx] * I[idx] / N - h * E[idx] * S[idx] / N + c * E[idx])  # 易感人数迭代
        E.append(E[idx] + h * I[idx] * S[idx] / N + h * E[idx] * S[idx] / N - i * E[idx] - c * E[idx])  # 潜伏人数迭代
        I.append(I[idx] + i * E[idx] - (r + k) * I[idx] - q * I[idx])  # 计算累计确诊人数
        R.append(R[idx] + r * I[idx] + r1 * Q[idx])  # 康复人数迭代
        D.append(D[idx] + k * I[idx] + d1 * Q[idx])  # 隔离人数迭代
        Q.append(Q[idx] + q * I[idx] - r1 * Q[idx] - d1 * Q[idx])
        Iq.append(I[idx] + Q[idx])
        if idx == day:
            a = 5
            h = a * b
        if idx > day:
            S[idx + 1] = S[idx] - f * S[idx]
        sum_I.append(sum_I[idx] + i * E[idx])


def plot(T, S, E, I, R, D, Q, Iq, sum_I):
    shanghai = [1, 4, 6, 9, 12, 16, 19, 23, 34, 39, 40, 81, 90, 95, 103, 160, 168, 185, 209, 240, 244, 248, 277, 315,
                360, 410, 506, 832, 1187, 1545, 1805, 2243, 2268, 2936, 3247, 3569, 4393, 5408, 6414, 7328, 8322, 9511,
                12084, 15284, 18874, 22112, 24529, 27613, 30107, 32741, 34672, 37048, 41281, 42942, 44548, 45840, 51327,
                52576, 53364, 54091, 54365, 54625, 54886, 55131, 55384, 55599, 55921, 56155, 56383, 56527, 56754, 56948,
                57114, 57183, 57260, 57356, 57438, 57526, 57610, 57662, 57717, 57775, 57819, 57867, 57912, 57951, 57980,
                57986, 57995, 58000, 58005, 58013, 58018, 58024, 58028, 58031, 58035, 58039, 58045, 58052, 58062, 58073,
                58076, 58089, 58098, 58100, 58101, 58104, 58114, 58120, 58124]
    plt.figure()
    plt.title("SEIR-Time Curve of Virus Transmission")
    # plt.plot(T, S, color='#FFB6C1', label='yiganran')
    plt.plot(T, E, color='#8B008B', label='qianfu')
    plt.plot(T, I, color='#FF4500', label='ganran')
    plt.plot(T, R, color='#FFD700', label='zhiyu')
    plt.plot(T, D, color='b', label='siwang')
    plt.plot(T, Q, color='#D2691E', label='geli')
    plt.plot(T, Iq, color='#ADFF2F', label='xiancunganranrenshu')
    plt.plot(T, sum_I, color='#40E0D0', label='leijiganranrenshu')
    plt.plot(T, shanghai, color='b', label='leijiganranrenshu')
    plt.grid(False)
    plt.legend()
    plt.xlabel("Time(day)")
    plt.ylabel("Population")
    plt.show()


S, E, I, R, D, Q, Iq, sum_I = [], [], [], [], [], [], [], []
N = 2890000  # 人口总数
I.append(1)  # 感染者
S.append(N - I[0])  # 易感染者
E.append(0)  # 潜伏者
R.append(0)  # 康复者
D.append(0)  # 死亡者数量
Q.append(0)  # 隔离者人数
Iq.append(1)  # 现存感染人数
F = 0  # 自我隔离人数
sum_I.append(1)  # 累计感染人数
a = 20  # 传染者接触人数
b = 0.0296  # 传染者传染概率
h = a * b  # 传染系数（以SARS为标准）
k = 0.05  # 死亡概率
i = 0.125  # 潜伏者患病概率 1/8
r = 0.2  # 康复概率
r1 = r * 1.15  # 隔离者治愈率
q = 0.91  # 隔离速率
d1 = k * 0.05  # 隔离者死亡率
f = 0.5 # 自我隔离速率
day = 30 # 采取控制措施的天数
c = 0.05  # 转阴率

pylab.rcParams['figure.figsize'] = (17.0, 17.0)
T = [3,10,23,54,12,12,44,23,75]
#T = [i for i in range(0, 111)]
calc(T)
print(T,S,E,I,R,D,Q,Iq,sum_I)
#plot(T, S, E, I, R, D, Q, Iq, sum_I)
