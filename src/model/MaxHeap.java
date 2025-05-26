package model;

import java.util.ArrayList;

public class MaxHeap {
	ArrayList<Task> heap;

	public MaxHeap() {
		this.heap = new ArrayList<>();
	}

	public Task peek() {
		if (heap.isEmpty()) return null;
		return heap.get(0);
	}

	public void insert(Task task) {
		heap.add(task);
		if (heap.size() > 1) {
			heapfiUp(heap.size() - 1);
		}
	}

	public void heapfiUp(int index) {
		while (index > 0) {
			int indicePai = (index - 1) / 2;

			Task elementoAtual = heap.get(index);
			Task paiAtual = heap.get(indicePai); 
			
			if (elementoAtual.getPrioridade() > paiAtual.getPrioridade()) {
				swap(index, indicePai);
				index = indicePai;
			} else {
				break;
			}
		}
	}

	public void swap(int indexFilho, int indexPai) {
		Task temp = heap.get(indexFilho);
		heap.set(indexFilho, heap.get(indexPai));
		heap.set(indexPai, temp);
	}

	public Task extractMax() {
		if (heap.isEmpty()) {
			return null;
		}

		Task max = heap.get(0);
		Task last = heap.remove(heap.size() - 1);

		if (!heap.isEmpty()) {
			heap.set(0, last);
			heapifyDown(0);
		}

		return max;
	}

	private void heapifyDown(int index) {
		int size = heap.size();
		while (index < size) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;
			int largest = index;

			if (leftChild < size && heap.get(leftChild).getPrioridade() > heap.get(largest).getPrioridade()) {
				largest = leftChild;
			}

			if (rightChild < size && heap.get(rightChild).getPrioridade() > heap.get(largest).getPrioridade()) {
				largest = rightChild;
			}

			if (largest != index) {
				swap(index, largest);
				index = largest;
			} else {
				break;
			}
		}
	}

	public void visualizarHeap() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.println(heap.get(i).toString());
		}
	}
}
