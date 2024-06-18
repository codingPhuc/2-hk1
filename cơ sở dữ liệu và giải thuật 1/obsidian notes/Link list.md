
#definition 
- each iteam in the list is link to one another 
- operation like add and sub an elements in the link list can be done much more easier by cuting or adding a link 
- there is no limit to link list 
- the item in the link list contains both data and a link 
- you can use [[Object referents]] to created a link list 

# node in link list 
- the first block in a note contains the data of the node the second block contain the link to the next node 
```
package IntegerList;
class IntegerNode {
  int item;
  IntegerNode next;
  IntegerNode(int newItem) {
    item = newItem;
    next = null;
  } // end constructor
  IntegerNode(int newItem, IntegerNode nextNode) {
    item = newItem;
    next = nextNode;
  } // end constructor
} // end class IntegerNode
```
- This definition of a node restricts the data to a single integer field. Since  we would like to have this class be as reusable as possible, it would be better to   change the data field to be of type Object
- The item field is initialized for  each node. The next field for the node n1 is then set to n2
# [^1] head in link list
- the varible head let you access the list beginning 
- head aways exits 
# [^2] coding 
## displaying the Contents of a Linked List 
the solution to display the list at hige level 
```
Let a variable curr reference the first node in  
the linked list  
while (the curr reference is not null) {  
Display the data portion of the current node  
Set the curr reference to the next field of the  
current node  
} // end while
```
The variable curr references each node in a nonempty linked list during  
the course of the for loop’s execution, and so the data portion of each node is  
displayed. After the last node is displayed, curr becomes null and the for  
loop terminates. When the list is empty—that is, when head is null—the for  
loop is correctly skipped.
## deleting a specified node from a Linked list 
1. first you need to created two different referent point ex: curr and pev 
2. then when curr referents  the currents block that you want to del 
3. you set the referents for next pev note to next curr note so that the pev will not referents the currents curr note 
4. this will ensure that the pev note be deleted 
prev.next = curr.next;

### deleting the first note in the head 
this is a speacial case now you dont need to make a referents to the previous but instead you asign your head as next head essentialy  replacing the first note in the list 
head = head.next;
### summarize the del process has three hige-level step :
1. locate the node you want to del 
2. disconnerct the note from the link list by chaging it predisecsor referents note 
3. return the note to the system 
## inserting a node into a Position of a Linked List 
you can insert a new node which the reference varible newNode references ,between the two node that prev and curr reference 
![[Pasted image 20220827152724.png|250]]
1. you need to find the position that you insert first by finding the two note that you want per and curr to referent too
2. then use the new opperator to created the notes that referents the item  ex : newNode = new Node(item);
3. you can now insert the node in by ex per.next = newNode ,newNode.next = curr
### inserting a node in the first postion 
![[Pasted image 20220827154044.png]]
1. you must first assign the next node to the head 
2. then make the head referent the new node 
ex: 
newNode.next = head;  
head = newNode;
### inserting a node in the end of link list 
this is a speacial case that happen you should insert the node where curr is the value of null 
![[Pasted image 20220827154259.png]]
## determind curr and prev 
// determine the point of insertion into a sorted  
// linked list  
// initialize prev and curr to start the traversal  
// from the beginning of the list  
prev = null  
curr = head
// advance prev and curr as long as  
// newValue > the current data item  
// Loop invariant: newValue > data items in all  
// nodes at and before the node that prev references  
while (newValue > curr.item) { // causes a problem!  
prev = curr  
curr = curr.next  
} // end while

# foot note 
[^1]: link list contain head 
[^2]: coding in the link list 