#Finally - success :-) :-) :-)
All the defects of _subclassing-abstract-builder_ are gone!  
This new pattern works for any level of subclassing  

In each class there are the following:
1. The actual POJO
1. An abstract builder that **his responsibility** is to set values to the POJO members
1. A private implementation of the abstract builder that handles the _types_ 
    1. implement `getThis()` - returns the default builder of the POJO
    1. implement `build()` - returns the POJO it self
    
Notice, that the constructor is **private!**  
you cannot create an instance of the POJO, unless you're using the builder.  
*(For Jackson, you will have to create a default empty constructor)

##Credit
Read the full post at: https://chrononaut.org/2013/03/19/subclassing-with-blochs-builder-pattern-revised/

## Reference
See following classes in _catalogs-common-api_ :
1. `ProductDetails`
1. `PipelineProductDetails`