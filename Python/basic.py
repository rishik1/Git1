import string #importing string modules

#start of python

print("Hello World")
my_message ="This is pythonn basics"
print(my_message)

price ="$1200"
print("stock price of company xyz is " +price)

#id is used for memory location of variable
print(id(price))

#INDEXING of variable
name = "Indexing of Variable"
print("index 0 value is " +name[0])

#negative indexing for last index of a variable
print("last index value is "+ name[-1])

#Strings are immutable in python , to change value you must re assign
# name[-1] = "E"  #TypeError: 'str' object does not support item assignment

# name[9] ="O"  #TypeError: 'str' object does not support item assignment
print(name)

#SLICING with python  variablName[START_INDEX : END_INDEX+1(or EMPTY for entire String)]
print("slicing from 0 to index 4 :: " +name[0:5])

#slicing show entire string
print("Slicing from begining to end of variable :: "+ name[0:])

#SLICING WITH STEP SIZE variablName[START_INDEX : END_INDEX+1 : STEP__SIZE]
nums = "0123456789"
print("Slicing with step of 2 :: " + nums[0::2])

#slicing in reverse order by 1
print("slicing in reverse order by steep 1 :: "+ nums[::-1])

#slicing in reverse order by 3
print("slicing in reverse order by steep 1 :: "+ nums[::-3])


#len() : number of character in the string
mesg = "hEllo" 
print("length of msg is ")
print(len(mesg))

#len() counts white spaces as well
msg1 = "hello  " 
print("length of msg is ")
print(len(msg1))

#Type of string
print(type(mesg))
print(type(len(mesg)))


#Capitalize() makes the first letter capital
print("Capitalize mesg " +msg1.capitalize()+ "with length " , len(msg1))

#Upper case lowe case
print("upper case ", mesg.upper() , " lower case " ,mesg.lower())

#Stripping msg of extra spaces
print(msg1.strip())
print(msg1.strip().upper())

#Splitting a string b character
meessage = "HI-My-name-Chelsea-fc,We are the king of London."
print(meessage.split("-"))

#Join cobines a list into a String
meessage = "HI-My-name-Chelsea-fc,We are the king of London."
print(meessage.split("-"))
print( " ".join(meessage.split("-")))


print("From Imported string module asccii lower case method " ,string.ascii_lowercase)