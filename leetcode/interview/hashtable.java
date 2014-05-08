class Elem {
	int key;
	int val;

	public Elem(int a, int b) {
		key = a;
		val = b;
	}
}

class hashtable {
	private Elem[] elem;
	private int count;
	private int cnum;
	private int addr;

	public hashtable() {
		count = 0;
		addr = 0;
		elem = new Elem[19];
		for (int i = 0; i < elem.length; i++)
			elem[i].key = 0;
	}

	public int hash(Elem e) {
		return e.key % elem.length;
	}

	public int collision(int p, int count) {
		return (p + count) % elem.length;
	}

	public boolean contains(Elem e) {
		cnum = 0;
		int p = hash(e);
		while (elem[p].key != 0 && elem[p].key != e.key) {
			cnum++;
			if (cnum < elem.length / 2)
				p = collision(p, cnum);
			else
				return false;
		}
		if (elem[p].key == e.key) {
			addr = p;
			return true;
		} else
			return false;
	}

	public boolean add(Elem e) {
		if (contains(e))
			return true;
		else if (cnum < elem.length / 2) {
			elem[addr] = e;
			count++;
			return true;
		} else
			recreate_table();
		return false;
	}

	public void recreate_table() {
		hashtable h = new hashtable();
		h.elem = new Elem[elem.length * 2];
		for (int i = 0; i < elem.length; i++)
			if (elem[i].key != 0)
				h.add(elem[i]);
		this.elem = h.elem;
		this.addr = h.addr;
		this.cnum = h.cnum;
		this.count = h.count;
	}
}