#!/usr/bin/env python3

secret='password'
pw =''

animals ={'bear','bunny','dog','cat','velero'};


for pet in animals:
    print(pet)

for i in range(5):
    print(i)

while secret != pw:
    pw = input("whats the password ??")

passcode ='passcode'
count =0
while passcode != pw:
    count = count+1
    if count <= 3:
        pw = input("Enter the passcode")
    else:
        print("max attempt reached")
        break
else:
    print("you are auhtorized ....")