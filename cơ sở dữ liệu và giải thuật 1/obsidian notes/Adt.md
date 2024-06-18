#definition 
The abstract datatype is special kind of datatype, whose behavior is defined by a set of values and set of operations. The keyword “Abstract” is used as we can use these datatypes, we can perform different operations. But how those operations are working that is totally hidden from the user. The ADT is made of with primitive datatypes, but operation logics are hidden

## different form [[data structor]]
- ADT is in the logical level and data structure is in the implementation level.
## the base operation of the [[Adt]]
1. The operation add adds data to a data collection.  
2. The operations remove and removeAll remove data from a data collection.  
3.  The operations isEmpty, size, and get ask questions about the data in a  data collection.
## some code 
this code will print the array list
```
displayList( in aList: List) // Displays the items on the list aList.  
for (index = 0 through aList.size() - 1) {
  dataItem = aList.get(index)
  Display dataItem
} // end for  

```
this code will  As another application of the ADT operations, suppose that you want a  method replace that replaces the item in position i with a new item. If the   item exists, replace deletes the item and inserts the new item at position i, 
as   follows:
```
replace( in aList: List, in i: integer, in newItem: ListItemType
    // Replaces the ith item on the list aList with  
    // newItem.  
    if (i >= 0 and i < aList.size()) {
      aList.remove(i)
      aList.add(i, newItem)
    } // end if
```
### notice how you can focus on the task  at hand without the distraction of implementation details such as arrays.
- To summarize, you can specify the behavior of an ADT independently of  its implementation.
- Given such a specification, and without any knowledge of  how the ADT will be implemented, you can design applications that use the  ADT’s operations to access its data.

