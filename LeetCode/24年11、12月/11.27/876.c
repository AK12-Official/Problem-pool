// 给你单链表的头结点 head ，请你找出并返回链表的中间结点。

// 如果有两个中间结点，则返回第二个中间结点。

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#include <stdio.h>
struct ListNode {
    int val;
    struct ListNode *next;
};
typedef struct ListNode ListNode;
struct ListNode* middleNode(struct ListNode* head) {
    int depth=0;ListNode* temp=head;
    while(temp!=NULL)
    {
        temp=temp->next;
        depth++;
        if(depth%2==0&&head!=NULL)head=head->next;
    }
    return head;
}
//本质上是快慢指针的方法(快指针(depth)走两步慢指针(head)走一步)  但是这里是用了一个depth来记录链表的长度(因为我一开始打算用表长来做)