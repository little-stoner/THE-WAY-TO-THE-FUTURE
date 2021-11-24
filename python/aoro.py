from types import coroutine

@coroutine
def nice():
    yield

async def nico():
    print(">>>>> enter nico")
    await nice()
    return "nico"
    
async def hello(name):
    print("---> enter")
    await nico()
    print("---> next")
    print(f'Hello, {name}')

task = hello('world')
print("before first send")

print(">>>>>>", task.send(None))

print("after first send")
try:
    print("===>", task.send(None))
except StopIteration:
    print("stop ex")
    pass

