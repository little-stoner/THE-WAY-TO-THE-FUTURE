import asyncio
from types import coroutine
from inspect import iscoroutine

@coroutine
def nice():
    yield

@coroutine
def spawn(task):
    yield task

async def hello(name):
    await nice()
    print(">>>>>>>>", name)

async def main():
    await spawn(hello('world'))

def run_until_complete(task):
    tasks = [(task, None)]
    while tasks:
        queue, tasks = tasks, []
        for task, data in queue:
            try:
                data = task.send(data)
                print("======>", data)
            except StopIteration:
                print(">>>>>>>>>..")
            except Exception as error:
                print(error)
            else:
                if iscoroutine(data):
                    tasks.append((data, None))
                tasks.append((task, None))

def a():
    print("------- a()")
    x = yield 1
    print(">>>>>>>a: ", x)
def b():
    print("------- b()")    
    x = yield from a()
    print("======b: ", x)
def c():
    print("------- c()")    
    x = yield from b()
    print('>>>>>>c: ', x)
                

if __name__ == '__main__':
    # loop = asyncio.get_event_loop()
    # loop.run_until_complete(main())
    run_until_complete(main())
    x = c()
    print(">>>>>> x: ", x)
    #print(">>> next: ", next(x))
    print("=================================")
    print(">>> send:", x.send(None))
    print(">>> send:", x.send(99))
    
