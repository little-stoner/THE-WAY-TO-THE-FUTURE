

class Dog:

    def speak(self):
        print("Arf!")

    def sit(self):
        print("Sitting!")

    def reproduce(self):
        pass

class Robot:
    def speak(self):
        print("click!")
    def sit(self):
        print("Clank!")
    def oilChange(self):
        pass

def perform(anything):
    anything.speak()
    anything.sit()

if __name__ == '__main__':
    a = Dog()
    b = Robot()
    perform(a)
    perform(b)