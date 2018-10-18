#Overcome all the defect of _bad-Builder_ :-)
No More Coupling!

Builder of subclass need to know and act only his own members.  
There is no "share" responsibility.  
Every change in **transparent** the super is to those who extend it

Each class has just **one single** constructor!

## Too good to be true :-(
Works only if:
1. super class is abstract

##Credit
Read the full post at: https://chrononaut.org/2012/02/24/subclassing-with-blochs-builder-pattern/

## Reference
See following classes in _catalogs-common-api_ :
1. abstract `FeedbackPipelineRequest`
1. `FeedbackPipelineUpdateRequest`
1. `FeedbackPipelineCreateRequest`