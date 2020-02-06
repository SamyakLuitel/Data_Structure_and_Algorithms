#abstract data type date example
#Extracts a collection  of birth date from user and determines
#if each individual is at leat 21 years of age

from datetime import date

#prompts for and extracts the Greogorian date comppnents.Returns a
#date object or None when the user has finished enering dates


def main():
    #date before which a person must have been born to be 21
    bornBefore = date(1999,2,2)

    #extract birth date from user and determine if 21 or older
    date1 = promptAndExtractDate()
    while date1 is not None:
        if date1 <= bornBefore:
            print("is at least 21 years of age:",)
        date1 = promptAndExtractDate()
    
def promptAndExtractDate():
    print ("enter a birth date.")
    month = int(input("month(0 to quit )"))
    if month == 0:
        return None
    else :
        day = int(input("day: "))
        year =int(input("year: "))
        return date(year,month,day)     
#call the main module 
main()


