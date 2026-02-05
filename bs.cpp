#include <iostream>
using namespace std;

struct Node{
    int data;
    Node* next;
};

void addAtFront(Node* &headRef, int newVal){

    Node* newNode = new Node();
    newNode->data = newVal;
    newNode->next = headRef;
    headRef = newNode;

}

void printList(Node* node){

    cout << "Linked List: ";
    while (node != NULL){
        cout << node->data << "->";
        node = node->next;

    }

    cout << "NULL" << endl;

}

int main(){

    Node* head = NULL;

    addAtFront(head, 30);
    addAtFront(head, 20);
    addAtFront(head, 10);

    printList(head);

    return 0;

}