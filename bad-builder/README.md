#The bad :-(
There is a Coupling between the super class `Share` and the who extends it `Rectangle`.  

Whenever a new member is added to `Share` and its builder, it has to be added also to the following:
1. `Rectangle` 1'st constructor
1. `Rectangle` 2'nd constructor
1. `Rectangle` n' constructor
1. `Rectangle` builder

Any modification to the super will cause a modification to all the classes who extends it as well.
