package com.bridgelabz.day16;

import java.util.Scanner;

class LinkedList {

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public void addFirst(String data) {
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
			return;
		}
		newnode.next = head;
		head = newnode;
	}

	public void addLast(String data) {
		Node newnode = new Node(data);
		Node tempnode = head;

		if (head == null) {
			head = newnode;
			return;
		}

		while (tempnode.next != null) {
			tempnode = tempnode.next;
		}
		tempnode.next = newnode;
	}

	public void add(String data, int index) {
		int i = 1;
		Node newnode = new Node(data);
		Node prevnode = head;
		Node tempnode = head.next;

		if (head == null) {
			addFirst(data);
			return;
		}

		while (tempnode != null) {
			if (i == index) {
				prevnode.next = newnode;
				newnode.next = tempnode;
				return;
			} else {
				i++;
				prevnode = prevnode.next;
				tempnode = tempnode.next;
			}
		}

		addLast(data);
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("List is empty! nothing to remove!");
			return;
		}
		head = head.next;
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("List is empty! nothing to remove!");
		}
		Node secondLast = head;
		Node last = head.next;

		while (last.next != null) {
			secondLast = secondLast.next;
			last = last.next;
		}
		secondLast.next = null;
	}

	public void delete(String data) {
		if (head == null) {
			System.out.println("List is empty! Nothing to delete!");
			return;
		}

		if (head.data == data) {
			deleteFirst();
			return;
		}

		Node prevnode = head;
		Node currnode = head.next;
		Node nextnode = currnode.next;

		while (nextnode != null) {
			if (currnode.data == data) {
				prevnode.next = nextnode;
				return;
			} else {
				prevnode = prevnode.next;
				currnode = currnode.next;
				nextnode = nextnode.next;
			}
		}

		if (currnode.data == data) {
			prevnode.next = null;
			return;
		}
		System.out.println(data + " does not exist in List!");
	}

	public void size() {
		int l = 0;
		Node tempnode = head;
		while (tempnode != null) {
			l++;
			tempnode = tempnode.next;
		}
		System.out.println("Size of list is " + l);
	}

	public int search(String data) {
		if (head == null) {
			System.out.println("List is empty!");
			addFirst(data);
			return -1;
		}
		if (head.data.equals(data)) {
			deleteFirst();
			return 0;
		}
		Node prevnode = head;
		Node tempnode = head.next;

		while (tempnode != null) {
			if (tempnode.data.equals(data)) {
				System.out.println(data + " present in linked list");
				prevnode.next = tempnode.next;
				return 0;
			} else {
				prevnode = prevnode.next;
				tempnode = tempnode.next;
			}
		}
		System.out.println(data + " element is not present!");
		addLast(data);
		return -1;
	}

	public void display() {
		if (head == null) {
			System.out.println("Linked List is null ");
			return;
		}
		Node tempnode = head;

		while (tempnode.next != null) {
			System.out.print(tempnode.data + "=>");
			tempnode = tempnode.next;
		}
		System.out.println(tempnode.data);
	}
}

public class UnorderedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String para = "A paragraph is a collection of words strung together to make a longer unit than a sentence. Several sentences often make a paragraph. There are normally three to eight sentences in a paragraph. Paragraphs can start with a five-space indentation or by skipping a line and then starting over. This makes it simpler to tell when one paragraph ends and the next starts simply it has 3-9 lines.\r\n"
				+ "\r\n"
				+ "A topic phrase appears in most ordered types of writing, such as essays. This paragraph's topic sentence informs the reader about the topic of the paragraph. In most essays, numerous paragraphs make statements to support a thesis statement, which is the essay's fundamental point.\r\n"
				+ "\r\n"
				+ "Paragraphs may signal when the writer changes topics. Each paragraph may have a number of sentences, depending on the topic.";

		String sarr[] = para.split("\\s");
		LinkedList li = new LinkedList();

		for (int i = 0; i < sarr.length; i++) {
			li.addLast(sarr[i]);
		}
		li.display();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter word you want to search");
		String word = sc.next();

		int n = li.search(word);
		if (n == 0)
			System.out.println(word + " deleted from linked list");
		else
			System.out.println(word + " added in linked List");

		li.display();
	}

}
