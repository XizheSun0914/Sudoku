import sys
class Spot(object):
	"""docstring for Spot"""
	def __init__(self,value,x,y,poss,flag):
		super(Spot, self).__init__()
		self.value=value
		self.x = x
		self.y = y
		if value>0:
			self.poss=[]
		else:
			self.poss=[1,2,3,4,5,6,7,8,9]
		self.flag=False

	def getX(self):
		return self.x
	def getY(self):
		return self.y
	def getValue(self):
		return self.value
	def getFlag(self):
		return self.flag
	def setFlag(self,flag):
		self.flag=flag
	def whichSquare(self):
		square_num=0
		if (x>=1 and x<=3):
			if(y>=1 and y<=3):
				square_num=1
			if(y>=4 and y<=6):
				square_num=4
			if(y>=7 and y<=9):
				square_num=7
		
		if (x>=4 and x<=6):
			if(y>=1 and y<=3):
				square_num=2
			if(y>=4 and y<=6):
				square_num=5
			if(y>=7 and y<=9):
				square_num=8
		
		if (x>=7 and x<=9):
			if(y>=1 and y<=3):
				square_num=3
			if(y>=4 and y<=6):
				square_num=6
			if(y>=7 and y<=9):
				square_num=9
		if (square_num>9 or square_num<1):
			print("Error in whichSquare")
		return square_num
	def setValue(value,x,y):
		self.value=value
		self.x=x
		self.y=y


def main():
	print("hello world!")
if __name__=="__main__":
	main()