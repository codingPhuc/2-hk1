while (current != NULL)
{
    next = current -> next ;
    current -> next =prev ;
    prev = current ;
    current =next ;
}