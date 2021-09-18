# Design Document

## The Application

## Domain Model
![](domainmodel.png "")

The domain model consists of the three objects *account*, *poll* and *vote*.

Account keeps information about those registered as users of the system.
An email is used as their ID, and is what they use with a password to login.
A poll is something only a registered user is able to create,
and they will then be the owner of the poll. 
The owner is able to publish and decide when to close the poll. 
They also have the choice to restrict the poll to only registered users.
Which is necessary since the system allows for non-registered voters.
This rises the question of how many times a person should be able to vote on one poll.
We believe it is desirable to restrict a person to only one vote pr poll.
To make this possible each vote is linked to an email.


## Use Case Diagram
![](usecase.png "")

The use case diagram describes three types of roles. 
- Voter, which is someone without a user account.
- User, which is someone with a user account.
- Admin, which is someone with administrative rights. 

An admin should be able to do everything a user is able to do, 
and a user should be able to do everything a vote is able to do.



## Application Flow Diagram
![](applicationflow.png "")

The application flow diagram shows the different steps in the voting process. 
At the start screen the user/voter will be prompted to either login, 
register or enter a pollcode to access a poll directly.

## User Screens Mock-Up

### Front Page

### Login and Sign Up Pages

### Home Page

### Vote Page

### Poll Status Page

## System-specific architectural diagram