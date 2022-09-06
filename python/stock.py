import requests
import json

def stock_code():
    rsp = requests.get('http://quote.eastmoney.com/newapi/gethotgubalist')
    return rsp.content.decode('utf-8')

def stock_data():
    s = requests.Session()
    rsp = requests.get('http://75.push2.eastmoney.com/api/qt/stock/trends2/sse?fields1=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f17&fields2=f51,f52,f53,f54,f55,f56,f57,f58&mpi=1000&ut=fa5fd1943c7b386f172d6893dbfba10b&secid=1.688253&ndays=1&iscr=0&iscca=0&wbp2u=|0|0|0|web')
    with s.get(url, headers=None, stream=True) as resp:
        for line in resp.iter_lines():
            if line:
                print(line.data)

def get_stream(url):
    s = requests.Session()
    trends = []
    with s.get(url, headers=None, stream=True) as resp:        
        for line in resp.iter_lines():
            if line:
                rsp = line.decode('utf-8')
                data = json.loads(rsp[6:])
                # hisPrePrices = data['data']['hisPrePrices']
                trends = data['data']['trends']
                break
    
