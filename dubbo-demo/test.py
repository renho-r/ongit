import urllib.request
import threading

def getHtml(id):
    stdout = urllib.request.urlopen("http://localhost:8080/dubbo-demo-consumer/api/sayHello/renhaiou")
    jp = stdout.read().decode('utf-8')
    print(jp)

threads = []

for i in range(100):
    t = threading.Thread(target=getHtml, args=(i,))
    threads.append(t)

for t in threads:
    t.start()