# OOP_EX1 Observer Pattern

### Made By Ori Elimelech And Daniel Rivni

This is a program that demonstrates the observer pattern in Java using an UndoableStringBuilder that we built in our
last assignment as the subject.
The observer pattern is a design pattern in which an object, called observable(subject), utilizing an ArrayList of
observers, and notifies them when any state changes, usually by calling one of their methods.

## Table of Contents

- [How the Program Works](#How the Program Works)
- [Prerequisites](#prerequisites)
- [Installing](#installing)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## How the Program Works

This program consists of 5 classes:'UndoableStringBuilder','GroupAdmin','ConcreteMember','Tests','JvmUtilities'.
And also consists of 2 interfaces: 'Member','Sender'.

### GroupAdmin

The GroupAdmin class acts as the subject and utilizes an ArrayList of Observers using an ArrayList as a DataBase.
The class has register and unregister methods for adding and removing observers from the database, and a notifyObservers
method that is
called whenever the subject's state is changed.
The notifyObservers method iterates through the ArrayList of observers using a for-each loop and calls their update
method
(from our ConcreteMember class).

#### Fields

```
ArrayList<Member> clients:
An ArrayList which contains clients(observers) that implemented from our interface 'Member'

private UndoableStringBuilder:
A StringBuilder we created last assignment which can use all the methods a regular StringBuilder has and also can use undo().
```

#### GroupAdmins Methods(Implemented From 'Sender' Interface)

```
register(Member obj),unregister(Member obj):
methods to register and unregister observers

insert(int offset, String obj):
Inserts the string into our UndoableStringBuilder object.

append(String obj):
Appends the specified string to this character sequence.

delete(int start, int end):
Removes the characters in a substring of this sequence.

undo():
Erases the last change done to the document, reverting
it to an older state.

notifyObservers():
The notifyObservers method iterates through the ArrayList of observers using a for-each loop and calls their update
method (from our ConcreteMember class).

```

### ConcreteMember

The ConcreteMember class contains a shallow copy of UndoableStringBuilder Member from our observer class
and use a method update() implemented from "Member" to update the UndoableStringBuilder to the current state.

#### Fields

```
private UndoableStringBuilder usbDB:
A StringBuilder we created last assignment which can use all the methods a regular StringBuilder 
has and also can use undo(). with this we can do a shallow copy 

private final String name:
granting the ability to name each observer(ConcreteMember) so it'll be easier to identify 
```

#### ConcreteMember Methods(Implemented From 'Sender' Interface)

```
update(UndoableStringBuilder usb):
a function implemented from 'Member' interface, this function used to sync all the observers
to the current state of our subject (UndoableStringBuilder).
```

#### Tests

this program has a JvmUtilities and a Tests classes where we checked if the program run correctly and efficiently.

## Prerequisites

To run this program you will need a Java IDE and java(.jar) and JDK installed to your computer.
an example for an IDE is Intellij and Eclipse.

## Installing

download the project and open the Folder contains the project in your IDE (preferably Intellij).
you will need to create a Drive Class so you can run the code
this class will need to be in the package 'observer' you can reach it from this path: ```src/main/java/observer```

## Usage

In the created Drive class you will need to declare A groupAdmin and a few observers (As many as you want).
you can do this using this following code:

```
GroupAdmin Insert_Name_HERE = new GroupAdmin();
ConcreteMember NAME_1 = new ConcreteMember("NAME_1");
ConcreteMember NAME_2 = new ConcreteMember("NAME_2");
```

afterwards you can use the UndoableStringBuilder Methods mentioned in [GroupAdmin](#GroupAdmin) like this following
example:

```
//declaring the observers and the GroupAdmin
GroupAdmin Elon_Musk = new GroupAdmin();
oncreteMember SpaceX = new ConcreteMember("SpaceX");
ConcreteMember Tesla = new ConcreteMember("Tesla");
//using methods:
Elon_Musk.register(Tesla); 
 Elon_Musk.register(SpaceX);
//added the observers to the database
Elon_Musk.insert(0, "Everyone will get Tesla model plaid for Xmas");
Elon_Musk.delete(0, 5); //deleting some of the text
Elon_Musk.append(" only if he Sent OOP_EX1 for Natan and ELizabeth");
Elon_Musk.undo(); // undo the last UndoableStringBuilder method we used.
```
