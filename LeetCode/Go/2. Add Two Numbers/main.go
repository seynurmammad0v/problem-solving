package ___Add_Two_Numbers

//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order, and each of their nodes contains a single digit.
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	result := &ListNode{}
	tmp := result
	reminder := 0
	fVal, sVal := l1.Val, l2.Val
	for {
		sum := fVal + sVal + reminder
		tmp.Val = sum % 10
		reminder = sum / 10
		fVal, sVal = 0, 0
		l1, fVal = getNextVal(l1, &fVal)
		l2, sVal = getNextVal(l2, &sVal)
		if l1 == nil && l2 == nil && reminder == 0 {
			break
		} else {
			tmp.Next = &ListNode{}
		}
		tmp = tmp.Next
	}

	return result
}

func getNextVal(listNode *ListNode, val *int) (*ListNode, int) {
	if listNode != nil {
		listNode = listNode.Next
		if listNode != nil {
			val = &listNode.Val
		}
	}
	return listNode, *val
}
