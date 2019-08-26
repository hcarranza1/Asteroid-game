package com.mycompany.a3;

import java.util.Vector;

import GameObject.GameObject;

public class Collection implements ICollection {

	private Vector theCollection;

	public Collection() {
		theCollection = new Vector();
	}

	public void add(Object newObject) {
		theCollection.addElement(newObject);
	}

	public void remove(Object object) {
		theCollection.removeElement(object);
	}

	public void remove(int i) {
		theCollection.remove(i);
	}

	public IIterator getIterator() {
		return new GameVectorIterator();
	}

	private class GameVectorIterator implements IIterator {
		private int currElementIndex;

		public GameVectorIterator() {
			currElementIndex = -1;
		}

		public boolean hasNext() {
			if (theCollection.size() <= 0)
				return false;
			if (currElementIndex == theCollection.size() - 1)
				return false;
			return true;
		}

		public Object getNext() {
			currElementIndex++;
			return (theCollection.elementAt(currElementIndex));
		}

		public Object checkNext() {
			return (theCollection.elementAt(currElementIndex));
		}

		@Override
		public void remove() {
			theCollection.remove(currElementIndex);
			// TODO Auto-generated method stub

		}

	}

	public Object elementAt(int i) {
		// TODO Auto-generated method stub
		return theCollection.elementAt(i);
	}

	public int iteratorSize() {
		// TODO Auto-generated method stub
		return theCollection.size();
	}

}
